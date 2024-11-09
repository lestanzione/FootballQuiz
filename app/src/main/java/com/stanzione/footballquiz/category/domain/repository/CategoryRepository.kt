package com.stanzione.footballquiz.category.domain.repository

import com.stanzione.footballquiz.category.data.model.Category

interface CategoryRepository {

    fun getCategories(): List<Category>

}