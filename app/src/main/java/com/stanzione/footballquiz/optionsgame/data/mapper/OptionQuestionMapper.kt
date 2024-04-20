package com.stanzione.footballquiz.optionsgame.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

interface OptionQuestionMapper {
    fun map(document: DocumentSnapshot): OptionQuestion
}