package edu.bo.examenmovil

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FormBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_book)
        var idTitle=findViewById<View>(R.id.idTitle) as EditText
        var idAuthor=findViewById<View>(R.id.idAuthor)as EditText
        var idDescription=findViewById<View>(R.id.idDescription)as EditText
        var idEditorial=findViewById<View>(R.id.idEditorial)as EditText
        var idPage=findViewById<View>(R.id.idPage)as EditText
        var idPhoto=findViewById<View>(R.id.idPhoto)as EditText
        var btn_createbook=findViewById<View>(R.id.btn_createbook) as Button
        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
        btn_createbook.setOnClickListener {
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)
                val book =Book(idTitle.text.toString(),idPage.text.toString(),idEditorial.text.toString(),idAuthor.text.toString(),idDescription.text.toString(),idPhoto.text.toString())
                AppRoomDatabase.getDatabase(applicationContext).bookDato().insertBook(book)
                //repository.insertBook(book)
                val intent = Intent(this@FormBookActivity, MainActivity::class.java)
                startActivity(intent)
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }

        }



    }
    /*AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            // Insert Data
            AppRoomDatabase.getDatabase(applicationContext).bookDato().insertBook(new User(1,"James","Mathew"));*/

}