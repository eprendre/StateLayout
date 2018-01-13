package com.github.eprendre.statelayout.demo

import android.content.Context
import android.util.AttributeSet
import com.github.eprendre.statelayout.StateLayout

/**
 * Created by eprendre on 13/01/2018.
 */
class CustomStateLayout(context: Context, attrs: AttributeSet) : StateLayout(context, attrs) {

  override fun getStateLayouts(): List<Int> {
    return listOf(
        R.layout.state_my_error,
        R.layout.state_my_empty,
        R.layout.state_my_loading,
        R.layout.state_custom_one,
        R.layout.state_custom_two)
  }

  fun showError() {
    displayedChildId = R.id.state_my_error
  }

  fun showEmpty() {
    displayedChildId = R.id.state_my_empty
  }

  fun showLoading() {
    displayedChildId = R.id.state_my_loading
  }

  fun showCustomOne() {
    displayedChildId = R.id.state_custom1 //id from R.layout.state_custom_one
  }

  fun showCustomTwo() {
    displayedChildId = R.id.state_custom2 //id from R.layout.state_custom_two
  }

}