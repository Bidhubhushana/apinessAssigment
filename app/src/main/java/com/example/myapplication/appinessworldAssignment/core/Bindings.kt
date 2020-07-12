package com.example.myapplication.appinessworldAssignment.core

import android.net.Uri
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.facebook.drawee.view.SimpleDraweeView
import me.relex.photodraweeview.PhotoDraweeView

object Bindings {
  @BindingConversion
  @JvmStatic
  fun convertBooleanToViewVisibility(value: Boolean): Int =
      if (value) View.VISIBLE else View.GONE

  @BindingAdapter("imageUri")
  @JvmStatic
  fun setImageUri(view: SimpleDraweeView, imageUri: Uri?)
      = view.setImageURI(imageUri)

  @BindingAdapter("largeImageUri")
  @JvmStatic
  fun setLargeImageUri(view: PhotoDraweeView, imageUri: Uri?)
      = view.setPhotoUri(imageUri)
}
