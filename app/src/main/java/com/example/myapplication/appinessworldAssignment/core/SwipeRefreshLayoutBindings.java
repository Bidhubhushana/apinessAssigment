package com.example.myapplication.appinessworldAssignment.core;


import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

@BindingMethods({
    @BindingMethod(
        type = SwipeRefreshLayout.class,
        attribute = "android:onRefresh",
        method = "setOnRefreshListener"
    )
})
public final class SwipeRefreshLayoutBindings {
  private SwipeRefreshLayoutBindings() {}

  @BindingAdapter("refreshing")
  public static void setRefreshing(final SwipeRefreshLayout v, final boolean refreshing) {
    // If we invoke setRefreshing(true) while the SwipeRefreshLayout isn't added to the root view,
    // its progress indicator won't be shown up. In order to deal with that, we schedule the first
    // call of setRefreshing() until it's added to the root view via this post().
    v.post(() -> v.setRefreshing(refreshing));
  }
}
