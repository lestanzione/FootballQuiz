package com.stanzione.footballquiz.main.data.repository

import com.stanzione.footballquiz.main.data.model.Category
import com.stanzione.footballquiz.main.data.repository.datasource.local.CategoryLocalDataSource
import com.stanzione.footballquiz.main.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryLocalDataSource: CategoryLocalDataSource
) : CategoryRepository {

    override fun getCategories(): List<Category> {
        return categoryLocalDataSource.getCategories()
    }

}