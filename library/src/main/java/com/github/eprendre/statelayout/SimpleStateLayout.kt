package com.github.eprendre.statelayout

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by eprendre on 13/01/2018.
 */
class SimpleStateLayout(context: Context, attrs: AttributeSet) : StateLayout(context, attrs) {
  val errTextView by lazy { errorView.findViewById<TextView>(R.id.text) }
  val errImageView by lazy { errorView.findViewById<ImageView>(R.id.image) }
  val emptyTextView by lazy { emptyView.findViewById<TextView>(R.id.text) }
  val emptyImageView by lazy { emptyView.findViewById<ImageView>(R.id.image) }

  override fun getErrorRes(): Int {
    return R.layout.state_error
  }

  override fun getEmptyRes(): Int {
    return R.layout.state_empty
  }

  override fun getLoadingRes(): Int {
    return R.layout.state_loading
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
}