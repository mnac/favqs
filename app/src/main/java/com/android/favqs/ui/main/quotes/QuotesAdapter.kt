package com.android.favqs.ui.main.quotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.favqs.R
import com.android.favqs.domain.models.quotes.Quote
import kotlinx.android.synthetic.main.quotes_view.view.*

class QuotesAdapter : RecyclerView.Adapter<QuoteViewHolder>() {
    var list = ArrayList<Quote>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(parent)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItem(list: List<Quote>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}

class QuoteViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(R.layout.quotes_view, parent, false)
    )

    fun bind(quote: Quote) {
        itemView.quoteBodyTxtVw.text = quote.body
        itemView.quoteAuthorTxtVw.text = quote.author
    }
}