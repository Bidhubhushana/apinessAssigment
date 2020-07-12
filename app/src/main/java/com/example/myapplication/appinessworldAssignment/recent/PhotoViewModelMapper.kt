package com.example.myapplication.appinessworldAssignment.recent

import android.net.Uri
import com.example.myapplication.query.Photo
import javax.inject.Inject

open class PhotoViewModelMapper @Inject internal constructor() {
  open operator fun invoke(photo: Photo) = PhotoViewModel(
      id = photo.id,
      link = Uri.parse(photo.link),
      title = photo.title
  )
}
