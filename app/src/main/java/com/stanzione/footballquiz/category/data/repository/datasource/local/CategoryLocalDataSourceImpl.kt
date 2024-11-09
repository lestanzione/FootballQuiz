package com.stanzione.footballquiz.category.data.repository.datasource.local

import com.stanzione.footballquiz.category.data.model.Category

class CategoryLocalDataSourceImpl : CategoryLocalDataSource {

    override fun getCategories(): List<Category> {
        return listOf(
            Category(
                id = 1,
                label = "Geral",
                enabled = true
            ),
            Category(
                id = 2,
                label = "Guess player by transfers",
                enabled = true
            ),
            Category(
                id = 3,
                label = "Guess team by uniform",
                enabled = true
            ),
            Category(
                id = 4,
                label = "Guess team by squad",
                enabled = true
            ),
        )
    }

}