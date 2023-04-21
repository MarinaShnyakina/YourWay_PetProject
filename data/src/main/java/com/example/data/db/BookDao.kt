package com.example.data.db

import androidx.room.*
import com.example.data.entities.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBook(book: BookEntity)

    @Query("SELECT * FROM book")
    fun getSaveBook(): Flow<List<BookEntity>>

    @Delete
    suspend fun deleteBook(book: BookEntity)

}