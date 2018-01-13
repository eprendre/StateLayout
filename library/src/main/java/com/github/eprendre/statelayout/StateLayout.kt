package com.github.eprendre.statelayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ViewAnimator
import java.lang.IllegalArgumentException

/**
 * Created by eprendre on 13/01/2018.
 */
abstract class StateLayout(context: Context, attrs: AttributeSet) : ViewAnimator(context, attrs) {
  protected val errorView: FrameLayout by lazy { findViewById<FrameLayout>(R.id.state_error) }
  protected val emptyView: FrameLayout by lazy { findViewById<FrameLayout>(R.id.state_empty) }
  protected val loadingView: FrameLayout by lazy { findViewById<FrameLayout>(R.id.state_loading) }
  protected var contentView: FrameLayout? = null

  init {
    initLayout()
    setupStates()
  }

  abstract fun getErrorRes(): Int
  abstract fun getEmptyRes(): Int
  abstract fun getLoadingRes(): Int
  open fun getCustomResList(): List<Int> = emptyList()

  private fun initLayout() {
    View.inflate(context, R.layout.state_switch, this)
    getCustomResList().forEach {
      View.inflate(context, it, this)
    }
    contentView = findViewById(STATE_CONTENT) //延后初始化，解决重写addView的问题
  }

  private fun setupStates() {
    if (getErrorRes() != -1) {
      View.inflate(context, getErrorRes(), errorView)
    }
    if (getEmptyRes() != -1) {
      View.inflate(context, getEmptyRes(), emptyView)
    }
    if (getLoadingRes() != -1) {
      View.inflate(context, getLoadingRes(), loadingView)
    }
  }

  var displayedChildId: Int
    get() = getChildAt(displayedChild).id
    set(id) {
      if (displayedChildId == id) {
        return
      }
      for (i in 0 until childCount) {
        if (getChildAt(i).id == id) {
          displayedChild = i
          return
        }
      }
      val name = resources.getResourceEntryName(id)
      throw IllegalArgumentException("No view with ID " + name)
    }

  fun showError() {
    displayedChildId = STATE_ERROR
  }

  fun showEmpty() {
    displayedChildId = STATE_EMPTY
  }

  fun showLoading() {
    displayedChildId = STATE_LOADING
  }

  fun showContent() {
    displayedChildId = STATE_CONTENT
  }

  override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
    if (contentView == null) {
      super.addView(child, index, params)
    } else {
      contentView!!.addView(child, index, params)
    }
  }

  companion object {
    val STATE_ERROR = R.id.state_error
    val STATE_EMPTY = R.id.state_empty
    val STATE_LOADING = R.id.state_loading
    val STATE_CONTENT = R.id.state_content
  }
}