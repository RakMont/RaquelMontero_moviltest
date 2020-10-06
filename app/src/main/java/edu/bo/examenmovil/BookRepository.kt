package edu.bo.examenmovil


class BookRepository(private val bookDao: IBookDao) {
    suspend fun insert(book: Book) {
        bookDao.insertAll(book)
    }
    fun getListBooks(): List<Book> {
        return bookDao.getAll()
    }

}