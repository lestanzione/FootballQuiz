package com.stanzione.footballquiz.main.domain.repository

import com.stanzione.footballquiz.main.data.model.Category

interface CategoryRepository {

    fun getCategories(): List<Category>

}