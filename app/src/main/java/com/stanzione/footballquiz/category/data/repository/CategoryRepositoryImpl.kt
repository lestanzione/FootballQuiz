package com.stanzione.footballquiz.category.data.repository

import com.stanzione.footballquiz.category.data.model.Category
import com.stanzione.footballquiz.category.data.repository.datasource.local.CategoryLocalDataSource
import com.stanzione.footballquiz.category.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryLocalDataSource: CategoryLocalDataSource
) : CategoryRepository {

    override fun getCategories(): List<Category> {
        return categoryLocalDataSource.getCategories()
    }

}