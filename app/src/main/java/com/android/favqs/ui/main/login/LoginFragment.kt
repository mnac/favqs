package com.android.favqs.ui.main.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.favqs.FavQsApp
import com.android.favqs.R
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as FavQsApp)
            .appComponent
            .loginComponent()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.connect()
    }
}
