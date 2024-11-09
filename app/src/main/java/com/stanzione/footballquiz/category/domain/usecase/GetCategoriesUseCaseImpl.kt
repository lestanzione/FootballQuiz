package com.stanzione.footballquiz.category.domain.usecase

import com.stanzione.footballquiz.category.data.model.Category
import com.stanzione.footballquiz.category.domain.repository.CategoryRepository

class GetCategoriesUseCaseImpl(
    private val categoryRepository: CategoryRepository
) : GetCategoriesUseCase {

    override fun invoke(): List<Category> {
        return categoryRepository.getCategories()
    }

}