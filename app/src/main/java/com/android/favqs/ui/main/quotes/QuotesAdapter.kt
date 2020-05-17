package com.android.favqs.ui.main.quotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.favqs.databinding.QuotesViewBinding
import com.android.favqs.domain.models.quotes.Quote

class QuotesAdapter(private val viewModel: QuotesViewModel) :
    RecyclerView.Adapter<QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        viewModel.quotes.value?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = viewModel.quotes.value?.size ?: 0
}

class QuoteViewHolder constructor(private val binding: QuotesViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(quote: Quote) {
        binding.quoteBodyTxtVw.text = quote.body
        binding.quoteAuthorTxtVw.text = quote.author
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): QuoteViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = QuotesViewBinding.inflate(layoutInflater, parent, false)

            return QuoteViewHolder(binding)
        }
    }
}