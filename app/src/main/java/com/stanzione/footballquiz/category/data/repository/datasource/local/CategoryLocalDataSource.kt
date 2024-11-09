package com.stanzione.footballquiz.category.data.repository.datasource.local

import com.stanzione.footballquiz.category.data.model.Category

interface CategoryLocalDataSource {

    fun getCategories(): List<Category>

}