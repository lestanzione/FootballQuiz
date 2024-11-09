package com.stanzione.footballquiz.category.domain.usecase

import com.stanzione.footballquiz.category.data.model.Category

interface GetCategoriesUseCase {

    fun invoke(): List<Category>

}