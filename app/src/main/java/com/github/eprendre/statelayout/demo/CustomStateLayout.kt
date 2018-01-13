package com.github.eprendre.statelayout.demo

import android.content.Context
import android.util.AttributeSet
import com.github.eprendre.statelayout.StateLayout

/**
 * Created by eprendre on 13/01/2018.
 */
class CustomStateLayout(context: Context, attrs: AttributeSet) : StateLayout(context, attrs) {
  override fun getErrorRes(): Int {
    return R.layout.state_my_error
  }

  override fun getEmptyRes(): Int {
    return R.layout.state_my_empty
  }

  override fun getLoadingRes(): Int {
    return R.layout.state_my_loading
  }

  override fun getCustomResList(): List<Int> {
    return listOf(R.layout.state_custom_one, R.layout.state_custom_two)
  }

  fun showCustomOne() {
    displayedChildId = R.id.state_custom1 //id from R.layout.state_custom_one
  }

  fun showCustomTwo() {
    displayedChildId = R.id.state_custom2 //id from R.layout.state_custom_two
  }
}