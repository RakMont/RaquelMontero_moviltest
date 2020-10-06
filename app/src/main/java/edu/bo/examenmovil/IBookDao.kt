package edu.bo.examenmovil

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface IBookDao {
    @Query("SELECT * FROM book_table")
    fun getAll(): List<Book>
    @Query("SELECT * FROM book_table WHERE id IN (:id)")
    fun loadAllByIds(id: IntArray): List<Book>
    /* @Query("SELECT * FROM book_table"+" WHERE title LIKE :title")
     fun findByTitle(first: String, last: String): Book*/
    @Insert
    fun insertAll(vararg users: Book)
    @Delete
    fun delete(user: Book)
}