package com.stanzione.footballquiz.main.data.repository.datasource.local

import com.stanzione.footballquiz.main.data.model.Category

interface CategoryLocalDataSource {

    fun getCategories(): List<Category>

}