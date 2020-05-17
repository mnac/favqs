package com.android.favqs.ui.main.landing

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android.favqs.FavQsApp
import com.android.favqs.R
import javax.inject.Inject


class LandingFragment : Fragment() {
    @Inject
    lateinit var viewModel: LandingViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as FavQsApp)
            .appComponent
            .landingComponent()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.landing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val navController = findNavController()
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                LandingViewModel.AuthenticationState.PENDING -> {
                }
                LandingViewModel.AuthenticationState.AUTHENTICATED -> navController.navigate(R.id.quotesFragment)
                LandingViewModel.AuthenticationState.UNAUTHENTICATED -> navController.navigate(R.id.loginFragment)
            }
        })

        viewModel.usernameState.observe(viewLifecycleOwner, Observer { username ->
            context?.let {
                Toast.makeText(it, "Welcome back $username", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.onSubscribe()
    }
}
