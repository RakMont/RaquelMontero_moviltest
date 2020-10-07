package edu.bo.examenmovil

import android.util.Log
import kotlin.math.log


class BookRepository(private val bookDao: IBookDao) {
    fun insert(book: Book) {
        bookDao.insertAll(book)
    }
    fun getListBooks(): List<Book> {
        return bookDao.getAll()
    }
    fun insertBook(book: Book){
            print("llega aqui")
            bookDao.insertBook(book)
    }

    fun deleteBook(book: Book){
        print("llega aqui")
        bookDao.delete(book)
    }
    fun deleteOnebook(id: Int){
        print("llega aqui")
        bookDao.deleteOneBook(id)
    }

    }