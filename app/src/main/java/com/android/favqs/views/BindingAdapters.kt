package com.android.favqs.views

import android.view.View
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.android.favqs.R
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso

@BindingAdapter("app:error")
fun setErrorMessage(view: TextInputLayout, errorMessage: String?) {
    view.error = errorMessage
}

@BindingAdapter("app:errorRes")
fun setErrorMessage(view: TextInputLayout, @StringRes errorMessage: Int?) {
    errorMessage?.let { view.error = view.context.getString(it) }
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

@BindingAdapter("app:imageUrl")
fun setImageUrl(view: ImageView, path: String?) {
    if (path.isNullOrBlank()) {
        Picasso
            .get()
            .load(R.drawable.ic_avatar)
            .transform(CircleTransformation())
            .into(view)
        return
    }
    Picasso
        .get()
        .load(path)
        .transform(CircleTransformation())
        .placeholder(R.drawable.ic_avatar)
        .into(view)
}