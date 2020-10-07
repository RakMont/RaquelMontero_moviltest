package edu.bo.examenmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
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

            /*repository.deleteOnebook(8)
            repository.deleteOnebook(9)
            repository.deleteOnebook(10)
            repository.deleteOnebook(11)
            repository.deleteOnebook(12)
            repository.deleteOnebook(13)
            repository.deleteOnebook(14)
*/

            //repository.deleteOnebook(19)
            //repository.deleteOnebook(22)
            val arrayList= ArrayList<Book>()
           /* repository.insert(Book("Los mitos de Cthulhu","1200","The same","H.P. Lovecraft","Un libro que contiene las historias más aterradoras que se hayan contado jamás. Lovecraft te dejará traumatizado de por vida, no sabrás si sólo son historias fantásticas o relatos de historias reales.","https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"))
            repository.insert(Book("IT","234","The same","Stephen King","¿Quién o qué mutila y mata a los niños de un pequeño pueblo norteamericano? ¿Por qué llega cíclicamente el horror a Derry en forma de un payaso siniestro que va sembrando la destrucción a su paso?","https://www.troa.es/imagenes_grandes/9788466/978846634792.JPG"))
            repository.insert(Book("Drácula","4234","The same","Bram Stoker","Drácula comienza con el diario que el abogado inglés Jonathan Harker escribe mientras viaja desde Inglaterra hasta Europa del Este.","https://prodimage.images-bn.com/pimages/9780486295671_p0_v2_s1200x630.jpg"))
            repository.insert(Book("Cuentos completos","200","The same","Edgar Allan Poe","Edgar Allan Poe ocupa un lugar de honor en la historia de la literatura debido a sus cuentos, es considerado como el padre de la novela detectivesca.","https://d26lpennugtm8s.cloudfront.net/stores/001/252/381/products/97898762834341-3ea0ac09f6a585a55615945991052696-640-0.jpg"))
            repository.insert(Book("The knight in rusty armor","100","The same","sdfsd","sdfsd","https://boutiquedezothique.es/1503-large_default/los-mitos-de-cthulhu.jpg"))
            */
            repository.insert(Book("Drácula","4234","The same","Bram Stoker","Drácula comienza con el diario que el abogado inglés Jonathan Harker escribe mientras viaja desde Inglaterra hasta Europa del Este.","https://prodimage.images-bn.com/pimages/9780486295671_p0_v2_s1200x630.jpg"))

            val lista = repository.getListBooks()
                lista.forEach {
                Log.d(
                    "DBTEST",
                    "Id book = ${it.id}, Title:${it.title}, Pages:${it.pages},Editorial:${it.editorial},author:${it.author},description:${it.description},photoUrl:${it.photoUrl}"
                )
            }
            val myAdapter = BookAdapter(lista as ArrayList<Book>,this)
            recyclerView.layoutManager= LinearLayoutManager(applicationContext)
            recyclerView.adapter=myAdapter


        }



    }
}

