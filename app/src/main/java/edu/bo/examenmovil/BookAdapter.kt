package edu.bo.examenmovil
import android.content.ContentValues.TAG
import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row.view.*
import android.widget.ImageView
import android.widget.TextView

class BookAdapter(val arrayList: ArrayList<Book>,val context: Context):
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(book: Book){
            itemView.title.text=book.title
            itemView.pages.text=book.pages
            itemView.editorial.text=book.editorial
            itemView.author.text=book.author
            itemView.description.text=book.description
            //itemView.photoUrl.text=book.photoUrl
            //Log.d(TAG, "url = " + Uri.parse(arrayList.get(position).getImageUri()));
            val picasso = Picasso.get()
            picasso.load(
                book.photoUrl)
                .into(itemView.photoUrl)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])


    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}