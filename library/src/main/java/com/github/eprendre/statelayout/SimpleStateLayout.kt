package com.github.eprendre.statelayout

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by eprendre on 13/01/2018.
 */
class SimpleStateLayout(context: Context, attrs: AttributeSet) : StateLayout(context, attrs) {
  protected val errorView: ViewGroup by lazy { findViewById<ViewGroup>(R.id.state_error) }
  protected val emptyView: ViewGroup by lazy { findViewById<ViewGroup>(R.id.state_empty) }
  protected val loadingView: ViewGroup by lazy { findViewById<ViewGroup>(R.id.state_loading) }

  val errTextView by lazy { errorView.findViewById<TextView>(R.id.text) }
  val errImageView by lazy { errorView.findViewById<ImageView>(R.id.image) }
  val emptyTextView by lazy { emptyView.findViewById<TextView>(R.id.text) }
  val emptyImageView by lazy { emptyView.findViewById<ImageView>(R.id.image) }

  override fun getStateLayouts(): List<Int> {
    return listOf(
        R.layout.state_error,
        R.layout.state_empty,
        R.layout.state_loading)
  }

  fun setErrorText(errMsg: CharSequence) {
    errTextView.text = errMsg
  }

  fun setErrorImage(@DrawableRes resId: Int) {
    errImageView.setImageResource(resId)
  }

  fun setEmptyText(emptyMsg: CharSequence) {
    emptyTextView.text = emptyMsg
  }

  fun setEmptyImage(@DrawableRes resId: Int) {
    emptyImageView.setImageResource(resId)
  }

  fun setErrorListener(click: (() -> Unit)?) {
    if (click == null) {
      errTextView.setOnClickListener(null)
      errTextView.isClickable = false
    } else {
      errTextView.setOnClickListener {
        click()
      }
    }
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

  companion object {
    val STATE_ERROR = R.id.state_error
    val STATE_EMPTY = R.id.state_empty
    val STATE_LOADING = R.id.state_loading
    val STATE_CONTENT = R.id.state_content
  }
}