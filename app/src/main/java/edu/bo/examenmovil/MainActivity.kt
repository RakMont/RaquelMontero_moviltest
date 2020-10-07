package edu.bo.examenmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        insertbook.setOnClickListener{
            val intent = Intent(this@MainActivity, FormBookActivity::class.java)
            startActivity(intent)
        }
        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            /*repository.insert(
                Book(
                    "The knight in rusty armor",
                    "dfgsdfs",
                    "sdfsdf",
                    "sdfsd",
                    "sdfsd",
                    "https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"
                )
            )
            repository.insert(
                Book(
                    "The knight in rusty armor",
                    "fsdfsdf",
                    "fsdfs",
                    "sdfsdf",
                    "sdfsd",
                    "https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"
                )
            )
*/
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d(
                    "DBTEST",
                    "Id book = ${it.id}, Title:${it.title}, Pages:${it.pages},Editorial:${it.editorial},author:${it.author},description:${it.description},photoUrl:${it.photoUrl}"
                )
            }

        }
        val arrayList= ArrayList<Book>()
        arrayList.add(Book("The knight in rusty armor","dfgsdfs","sdfsdf","sdfsd","sdfsd","https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"))
        arrayList.add(Book("The knight in rusty armor","dfgsdfs","sdfsdf","sdfsd","sdfsd","https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"))
        arrayList.add(Book("The knight in rusty armor","dfgsdfs","sdfsdf","sdfsd","sdfsd","https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"))
        arrayList.add(Book("The knight in rusty armor","dfgsdfs","sdfsdf","sdfsd","sdfsd","https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"))
        arrayList.add(Book("The knight in rusty armor","dfgsdfs","sdfsdf","sdfsd","sdfsd","https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"))

        val myAdapter = BookAdapter(arrayList,this)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=myAdapter

       /* Snackbar.make(layoutPrincipal , getString(R.string.mensaje_snackbar),
            Snackbar.LENGTH_LONG)
            .setBackgroundTint(resources.getColor(R.color.backgroundTint))
            .setActionTextColor(resources.getColor(R.color.actionTextColor))
            .show()*/
        }
    }

