package com.android.favqs.ui.main.quotes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.android.favqs.FavQsApp
import com.android.favqs.R
import com.android.favqs.databinding.QuotesFragmentBinding
import javax.inject.Inject


class QuotesFragment : Fragment() {

    @Inject
    lateinit var viewModel: QuotesViewModel

    private lateinit var viewDataBinding: QuotesFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as FavQsApp)
            .appComponent
            .quotesComponent()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.quotes_fragment, container, false)
        viewDataBinding = QuotesFragmentBinding.bind(root)
            .apply {
                this.viewmodel = viewModel
                this.lifecycleOwner = this@QuotesFragment.viewLifecycleOwner
            }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initQuoteList()
        viewModel.loadQuotes()
    }

    private fun initQuoteList() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            viewDataBinding.quotePager.adapter = QuotesAdapter(viewModel)
            viewModel.quotes.observe(viewLifecycleOwner, Observer {
                viewDataBinding.quotePager.adapter?.notifyDataSetChanged()
            })
        }
    }
}
