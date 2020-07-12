package com.example.myapplication.appinessworldAssignment.recent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.appinessworldAssignment.core.DaggerFragment
import com.example.myapplication.appinessworldAssignment.photodetails.PhotoDetailsActivity
import com.example.myapplication.databinding.RecentPhotosBinding
import com.miguelcatalan.materialsearchview.MaterialSearchView
import javax.inject.Inject

class RecentPhotosFragment : DaggerFragment() {
  @Inject lateinit var viewModel: RecentPhotosViewModel

  @SuppressLint("CheckResult")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    retainInstance = true

    viewModel.loadPhotos(savedInstanceState)
    viewModel.onErrorLoadingPhotos.subscribe {
      view?.let {
        /***
         * retry logic
         */
      }
    }
    viewModel.onPhotoTapped.subscribe {
      startActivity(PhotoDetailsActivity.newIntent(requireActivity(), it))
    }
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    viewModel.onSaveInstanceState(outState)
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    val binding = RecentPhotosBinding.inflate(inflater)

    binding.swipeRefreshLayout.isEnabled = false
    binding.toolbar.inflateMenu(R.menu.recent_photos)
    binding.searchView.setMenuItem(binding.toolbar.menu.findItem(R.id.search))
    binding.searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String?): Boolean = viewModel.onQueryTextSubmit(query)

      override fun onQueryTextChange(newText: String?): Boolean = false
    })

    // To configure columns for different orientations.
    // e.g. for portrait, column count is 2 while for landscape, the count is 4.

    binding.photosView.adapter=PhotoItemAdapter(activity!!)
    addDividers(binding.photosView)
    binding.viewModel = viewModel

    return binding.root
  }

  private fun addDividers(photosView: RecyclerView) {
    val verticalDividerItemDecoration = DividerItemDecoration(
      activity, DividerItemDecoration.VERTICAL
    ).apply {
      setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vertical_divider)!!)
    }
    photosView.addItemDecoration(verticalDividerItemDecoration)

    val horizontalDividerItemDecoration = DividerItemDecoration(
      activity, DividerItemDecoration.HORIZONTAL
    ).apply {
      setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.horizontal_divider)!!)
    }
    photosView.addItemDecoration(horizontalDividerItemDecoration)
  }

  override fun onDestroy() {
    viewModel.onCleared()
    super.onDestroy()
  }
}
