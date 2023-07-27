package com.stanzione.footballquiz.main.domain.usecase

import com.stanzione.footballquiz.main.data.model.Category

interface GetCategoriesUseCase {

    fun invoke(): List<Category>

}