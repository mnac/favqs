package com.android.favqs.ui.main.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.android.favqs.FavQsApp
import com.android.favqs.R
import com.android.favqs.databinding.LoginFragmentBinding
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModel: LoginViewModel

    private lateinit var viewDataBinding: LoginFragmentBinding

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
        val root = inflater.inflate(R.layout.login_fragment, container, false)
        viewDataBinding = LoginFragmentBinding.bind(root)
            .apply {
                this.viewmodel = viewModel
                this.lifecycleOwner = this@LoginFragment.viewLifecycleOwner
            }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.login.observe(viewLifecycleOwner, Observer { username ->
            context?.let {
                Toast.makeText(it, "Welcome back $username", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.init()
    }
}
