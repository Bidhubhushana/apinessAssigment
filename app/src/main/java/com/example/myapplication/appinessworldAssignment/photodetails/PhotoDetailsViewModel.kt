package com.example.myapplication.appinessworldAssignment.photodetails

import android.net.Uri
import android.os.Bundle
import androidx.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.myapplication.appinessworldAssignment.core.BaseViewModel
import com.example.myapplication.query.GetOriginalPhoto
import javax.inject.Inject

const val KEY_PHOTO_ID = "photoId"

class PhotoDetailsViewModel @Inject internal constructor(
  private val getOriginalPhoto: GetOriginalPhoto
) : BaseViewModel() {
  val title = ObservableField<String>()
  val link = ObservableField<Uri>()

  fun extractPhotoId(arguments: Bundle?) {
    val photoId = arguments?.getString(KEY_PHOTO_ID)
    checkNotNull(photoId) {
      "Must specify photo id"
    }

    getOriginalPhoto(photoId)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { (photo, size) ->
        title.set(photo.title)
        link.set(Uri.parse(size.link))
      }
      .autoDispose()
  }
}
