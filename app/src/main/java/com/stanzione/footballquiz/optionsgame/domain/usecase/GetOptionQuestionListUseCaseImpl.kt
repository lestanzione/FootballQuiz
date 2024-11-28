package com.stanzione.footballquiz.optionsgame.domain.usecase

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import com.stanzione.footballquiz.optionsgame.domain.repository.OptionQuestionRepository

class GetOptionQuestionListUseCaseImpl(
    private val optionQuestionRepository: OptionQuestionRepository
) : GetOptionQuestionListUseCase {

    override suspend fun execute(levelId: Int): List<OptionQuestion> {
        return optionQuestionRepository.getQuestions(levelId)
//        return listOf(
//            OptionQuestion(
//                title = "Quem é esse jogador?",
//                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjCjgVv-4Cl9Z-XQT3uCV_KKtjPzSNG-q2XA&usqp=CAU",
//                optionList = listOf(
//                    "Cristiano Ronaldo",
//                    "Messi",
//                    "Mbappé",
//                    "Rony"
//                ),
//                answerIndex = 1
//            ),
//            OptionQuestion(
//                title = "Quem é esse jogador?",
//                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbrDhCdnlxaFrtPM0U1GihgmbsWlb8ex1C5w&usqp=CAU",
//                optionList = listOf(
//                    "Cristiano Ronaldo",
//                    "Messi",
//                    "Mbappé",
//                    "Rony"
//                ),
//                answerIndex = 0
//            ),
//            OptionQuestion(
//                title = "Quem é esse jogador?",
//                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcHbJjrVE4NwON3ypdAkxluteWSOzASgofcQ&usqp=CAU",
//                optionList = listOf(
//                    "Cristiano Ronaldo",
//                    "Messi",
//                    "Mbappé",
//                    "Rony"
//                ),
//                answerIndex = 2
//            ),
//            OptionQuestion(
//                title = "Quem é esse jogador?",
//                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5u9mHKx7v-rvLQPbcRwfa6TUJR8m0Yh2gBw&usqp=CAU",
//                optionList = listOf(
//                    "Cristiano Ronaldo",
//                    "Messi",
//                    "Mbappé",
//                    "Rony"
//                ),
//                answerIndex = 3
//            ),
//            OptionQuestion(
//                title = "Quem é esse jogador?",
//                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR10YsRv4WdPqFl-W8KRa8w6_AAncGf8yeLng&usqp=CAU",
//                optionList = listOf(
//                    "Lewandowski",
//                    "Salah",
//                    "Gavi",
//                    "Militão"
//                ),
//                answerIndex = 0
//            ),
//            OptionQuestion(
//                title = "Quem é esse jogador?",
//                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qwKZI104pJwuzekNkyuBtzKYmmuvHO1nmg&usqp=CAU",
//                optionList = listOf(
//                    "Mané",
//                    "Rodrygo",
//                    "Vini Jr.",
//                    "Gabriel Jesus"
//                ),
//                answerIndex = 1
//            ),
//        )
    }
}