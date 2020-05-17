package com.android.favqs.views

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:error")
fun setErrorMessage(view: TextInputLayout, errorMessage: String?) {
    view.error = errorMessage
}

@BindingAdapter("app:errorRes")
fun setErrorMessage(view: TextInputLayout, @StringRes errorMessage: Int?) {
    errorMessage?.let { view.error = view.context.getString(it) }
}