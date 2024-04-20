package com.stanzione.footballquiz.optionsgame.data.repository.remote.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.stanzione.footballquiz.optionsgame.data.mapper.OptionQuestionMapper
import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume

class OptionQuestionRemoteDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val mapper: OptionQuestionMapper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : OptionQuestionRemoteDataSource {

    override suspend fun getQuestions(): List<OptionQuestion> = withContext(dispatcher) {
        suspendCancellableCoroutine { continuation ->
            firestore.collection("option-questions")
                .get()
                .addOnSuccessListener { result ->
                    val optionQuestionList = result.documents.map { document ->
                        println("LSTAN - ${document.id} => ${document.data}")
                        mapper.map(document)
                    }
                    continuation.resume(optionQuestionList)
                }
                .addOnFailureListener { exception ->
                    println("LSTAN - Error getting documents: ${exception.message}")
                    continuation.resume(emptyList())
                }
        }
    }
}