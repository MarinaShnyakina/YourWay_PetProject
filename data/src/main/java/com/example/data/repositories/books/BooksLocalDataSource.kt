package com.example.data.repositories.books

import com.example.domain.entities.Volume
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {
    suspend fun bookmark(book: Volume)
    suspend fun unbookmark(book: Volume)
    suspend fun getBookmarks(): Flow<List<Volume>>
}