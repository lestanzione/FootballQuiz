package com.stanzione.footballquiz.optionsgame.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import com.stanzione.footballquiz.optionsgame.domain.usecase.GetOptionQuestionListUseCase
import com.stanzione.footballquiz.optionsgame.domain.usecase.UpdateLevelPointsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OptionsGameViewModel(
    private val getOptionQuestionListUseCase: GetOptionQuestionListUseCase,
    private val updateLevelPointsUseCase: UpdateLevelPointsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main.immediate
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    private lateinit var optionQuestionList: List<OptionQuestion>
    private var optionQuestionIndex = -1
    private var points = 0
    private var levelId = 0

    private fun initialize(levelId: Int) {
        this.levelId = levelId
        viewModelScope.launch(dispatcher) {
            getOptionQuestionList(levelId)
            displayOptionQuestion(optionQuestionList.first())
        }
    }

    private suspend fun getOptionQuestionList(levelId: Int) {
        optionQuestionList = getOptionQuestionListUseCase.execute(levelId)
    }

    private fun displayOptionQuestion(optionQuestion: OptionQuestion) {
        optionQuestionIndex = optionQuestionList.indexOf(optionQuestion)
        _uiState.value = UiState.GameScreen(
            currentQuestionNumber = optionQuestionIndex + 1,
            totalQuestionNumber = optionQuestionList.size,
            optionQuestion = optionQuestion
        )
    }

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            is UiAction.Initialize -> {
                initialize(uiAction.levelId)
            }

            is UiAction.SelectOption -> {
                checkAnswer(uiAction.selectedIndex)
                showNextQuestionOrEndGame()
            }
        }
    }

    private fun checkAnswer(selectedIndex: Int) {
        val answerIndex = optionQuestionList[optionQuestionIndex].answerIndex
        if (selectedIndex == answerIndex) {
            points++
        }
    }

    private fun showNextQuestionOrEndGame() {
        val nextIndex = optionQuestionIndex + 1
        if (optionQuestionList.size > nextIndex) {
            val nextOptionQuestion = optionQuestionList[nextIndex]
            displayOptionQuestion(nextOptionQuestion)
        } else {
            updateLevelPointsUseCase.execute(levelId, points)
            _uiState.value = UiState.EndGame(
                points = points,
                totalQuestionNumber = optionQuestionList.size
            )
        }
    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class GameScreen(
            val currentQuestionNumber: Int,
            val totalQuestionNumber: Int,
            val optionQuestion: OptionQuestion
        ) : UiState()

        data class EndGame(
            val points: Int,
            val totalQuestionNumber: Int
        ) : UiState()
    }

    sealed class UiAction {
        data class Initialize(
            val levelId: Int
        ) : UiAction()
        data class SelectOption(
            val selectedIndex: Int
        ) : UiAction()
    }

}