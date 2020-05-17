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

    val isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isConnected = MutableLiveData<Boolean>().apply { value = false }

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val emailError = MutableLiveData<String>()
    val emailResError = MutableLiveData<Int>()
    val isEmailError = MutableLiveData<Boolean>()

    val passwordError = MutableLiveData<String>()
    val passwordResError = MutableLiveData<Int>()
    val isPasswordError = MutableLiveData<Boolean>()

    val login = MutableLiveData<String>()

    fun init() {
        email.value = "nacrymathias@hotmail.com"
        password.value = "ygZGp21sugjVDoUF"
    }

    fun connect() {
        email.value?.let { email ->
            isEmailError.value = false
            password.value?.let { password ->
                isPasswordError.value = false
                viewModelScope.launch {
                    try {
                        isLoading.value = true
                        val user = accountRepository.connectUser(email = email, password = password)
                        login.value = user.login
                        isConnected.value = true
                        isLoading.value = false
                    } catch (e: Exception) {
                        isLoading.value = false
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
