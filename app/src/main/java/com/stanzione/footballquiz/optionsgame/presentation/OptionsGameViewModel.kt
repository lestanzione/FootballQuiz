package com.stanzione.footballquiz.optionsgame.presentation

import androidx.lifecycle.ViewModel
import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import com.stanzione.footballquiz.optionsgame.domain.usecase.GetOptionQuestionListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OptionsGameViewModel(
    private val getOptionQuestionListUseCase: GetOptionQuestionListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Uninitialized)
    val uiState: StateFlow<UiState> = _uiState

    private lateinit var optionQuestionList: List<OptionQuestion>
    private var optionQuestionIndex = -1

    private fun getOptionQuestionList() {
        optionQuestionList = getOptionQuestionListUseCase.execute()
    }

    private fun displayOptionQuestion(optionQuestion: OptionQuestion) {
        optionQuestionIndex = optionQuestionList.indexOf(optionQuestion)
        _uiState.value = UiState.GameScreen(optionQuestion)
    }

    val onUiAction: (UiAction) -> Unit = { uiAction ->
        when (uiAction) {
            UiAction.Initialize -> {
                getOptionQuestionList()
                displayOptionQuestion(optionQuestionList.first())
            }

            is UiAction.SelectOption -> {
                val nextIndex = optionQuestionIndex + 1
                if (optionQuestionList.size > nextIndex) {
                    val nextOptionQuestion = optionQuestionList[nextIndex]
                    displayOptionQuestion(nextOptionQuestion)
                } else {
                    //todo finished quiz
                }
            }
        }
    }

    sealed class UiState {
        object Uninitialized : UiState()
        data class GameScreen(
            val optionQuestion: OptionQuestion
        ) : UiState()
    }

    sealed class UiAction {
        object Initialize : UiAction()
        object SelectOption : UiAction()
    }

}