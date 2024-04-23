package lando.com.example.bookshelf.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lando.com.example.bookshelf.R

class BookAdapter(private val books: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCover: ImageView = itemView.findViewById(R.id.imageViewCover)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewAuthor: TextView = itemView.findViewById(R.id.textViewAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.imageViewCover.setImageResource(book.coverImage)
        holder.textViewTitle.text = book.title
        holder.