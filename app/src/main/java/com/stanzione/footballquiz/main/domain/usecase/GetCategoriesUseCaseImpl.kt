package com.stanzione.footballquiz.main.domain.usecase

import com.stanzione.footballquiz.main.data.model.Category
import com.stanzione.footballquiz.main.domain.repository.CategoryRepository

class GetCategoriesUseCaseImpl(
    private val categoryRepository: CategoryRepository
) : GetCategoriesUseCase {

    override fun invoke(): List<Category> {
        return categoryRepository.getCategories()
    }

}