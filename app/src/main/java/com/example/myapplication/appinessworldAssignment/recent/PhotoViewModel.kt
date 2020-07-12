package com.example.myapplication.appinessworldAssignment.recent

import android.net.Uri
import com.example.myapplication.appinessworldAssignment.core.TapAction
import java.util.*

typealias PhotoId = String

data class PhotoViewModel(
    val id: PhotoId = UUID.randomUUID().toString(),
    val link: Uri,
    val title: String? = null
) {
  val tapAction: TapAction<PhotoViewModel> = TapAction.create { this }
}
