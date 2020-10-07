package edu.bo.examenmovil

import androidx.room.*


@Dao
interface IBookDao {
    @Query("SELECT * FROM book_table")
    fun getAll(): List<Book>
    @Query("SELECT * FROM book_table WHERE id IN (:id)")
    fun loadAllByIds(id: IntArray): List<Book>
    /* @Query("SELECT * FROM book_table"+" WHERE title LIKE :title")
     fun findByTitle(first: String, last: String): Book*/
    @Insert
    fun insertAll(vararg books: Book)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBook(user: Book)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateBook(user: Book)

    @Query("DELETE FROM book_table WHERE id IN (:id)")
    fun deleteOneBook(id:Int)

    @Delete
    fun delete(book: Book)
}