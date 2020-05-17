package com.android.favqs.ui.main.quotes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.favqs.FavQsApp
import com.android.favqs.R
import javax.inject.Inject


class QuotesFragment : Fragment() {

    @Inject
    lateinit var viewModel: QuotesViewModel

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
        return inflater.inflate(R.layout.quotes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.loadQuotes()
    }

}
