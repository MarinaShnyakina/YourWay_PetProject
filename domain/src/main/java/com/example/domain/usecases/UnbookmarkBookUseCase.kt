package com.example.domain.usecases

import com.example.domain.entities.Volume
import com.example.domain.repositories.BooksRepository

class UnbookmarkBookUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(book: Volume) = booksRepository.unbookmark(book)
}