package com.stanzione.footballquiz.optionsgame.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

class OptionQuestionMapperImpl : OptionQuestionMapper {
    override fun map(document: DocumentSnapshot): OptionQuestion {
        return OptionQuestion(
            title = document.data?.get("title").toString(),
            imageUrl = document.data?.get("imageUrl").toString(),
            optionList = document.data?.get("optionList") as List<String>,
            answerIndex = document.data?.get("answerIndex").toString().toInt(),
            levelId = listOf(1, 2) // TODO get from firestore
        )
    }
}