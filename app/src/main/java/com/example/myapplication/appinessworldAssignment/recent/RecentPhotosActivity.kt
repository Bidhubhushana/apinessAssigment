package com.example.myapplication.appinessworldAssignment.recent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RecentPhotosActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .replace(android.R.id.content, RecentPhotosFragment())
          .commit()
    }
  }
}
