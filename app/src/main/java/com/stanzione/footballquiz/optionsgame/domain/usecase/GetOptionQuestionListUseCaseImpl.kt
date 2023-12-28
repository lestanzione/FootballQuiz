package com.stanzione.footballquiz.optionsgame.domain.usecase

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

class GetOptionQuestionListUseCaseImpl : GetOptionQuestionListUseCase {
    override fun execute(): List<OptionQuestion> {
        return listOf(
            OptionQuestion(
                title = "Quem é esse jogador?",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjCjgVv-4Cl9Z-XQT3uCV_KKtjPzSNG-q2XA&usqp=CAU",
                optionList = listOf(
                    "Cristiano Ronaldo",
                    "Messi",
                    "Mbappé",
                    "Rony"
                )
            ),
            OptionQuestion(
                title = "Quem é esse jogador?",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbrDhCdnlxaFrtPM0U1GihgmbsWlb8ex1C5w&usqp=CAU",
                optionList = listOf(
                    "Cristiano Ronaldo",
                    "Messi",
                    "Mbappé",
                    "Rony"
                )
            ),
            OptionQuestion(
                title = "Quem é esse jogador?",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcHbJjrVE4NwON3ypdAkxluteWSOzASgofcQ&usqp=CAU",
                optionList = listOf(
                    "Cristiano Ronaldo",
                    "Messi",
                    "Mbappé",
                    "Rony"
                )
            ),
            OptionQuestion(
                title = "Quem é esse jogador?",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5u9mHKx7v-rvLQPbcRwfa6TUJR8m0Yh2gBw&usqp=CAU",
                optionList = listOf(
                    "Cristiano Ronaldo",
                    "Messi",
                    "Mbappé",
                    "Rony"
                )
            ),
        )
    }
}