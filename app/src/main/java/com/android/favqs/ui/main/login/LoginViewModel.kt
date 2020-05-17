package com.android.favqs.ui.main.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.favqs.R
import com.android.favqs.di.ActivityScope
import com.android.favqs.domain.repository.AccountRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class LoginViewModel @Inject constructor(
    private val accountRepository: AccountRepository
) : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val emailError = MutableLiveData<String>()
    val emailResError = MutableLiveData<Int>()
    val isEmailError = MutableLiveData<Boolean>()

    val passwordError = MutableLiveData<String>()
    val passwordResError = MutableLiveData<Int>()
    val isPasswordError = MutableLiveData<Boolean>()

    fun connect() {
        email.value?.let { email ->
            isEmailError.value = false
            password.value?.let { password ->
                isPasswordError.value = false
                viewModelScope.launch {
                    try {
                        val connectionResult = accountRepository.connectUser(
                            email = email,
                            password = password
                        )
                    } catch (e: Exception) {
                        isEmailError.value = true
                        emailError.value = e.message

                        isPasswordError.value = true
                        passwordError.value = e.message
                    }
                }
            } ?: run {
                isPasswordError.value = true
                passwordResError.value = R.string.mandatory_field_error
            }
        } ?: run {
            isEmailError.value = true
            emailResError.value = R.string.mandatory_field_error
        }
    }
}
