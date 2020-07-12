package com.example.myapplication.appinessworldAssignment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.example.myapplication.appinessworldAssignment.photodetails.PhotoDetailsFragment
import com.example.myapplication.appinessworldAssignment.recent.RecentPhotosFragment

@Module
abstract class AndroidBindingModule {
  @ContributesAndroidInjector
  abstract fun getRecentPhotosFragment(): RecentPhotosFragment

  @ContributesAndroidInjector
  abstract fun getPhotoDetailsFragment(): PhotoDetailsFragment
}
