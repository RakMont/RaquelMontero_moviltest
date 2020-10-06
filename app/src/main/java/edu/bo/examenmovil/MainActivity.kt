package edu.bo.examenmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("The knight in rusty armor","dfgsdfs","sdfsdf","sdfsd","sdfsd","sdfsd"))
            repository.insert(Book("The knight in rusty armor","fsdfsdf","fsdfs","sdfsdf","sdfsd","dsfsd"))

            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title:${it.title}, Pages:${it.pages},Editorial:${it.editorial},author:${it.author},description:${it.description},photoUrl:${it.photoUrl}")
            }
        }
    }

}