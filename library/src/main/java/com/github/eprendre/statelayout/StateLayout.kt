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

  protected var contentView: FrameLayout? = null

  init {
    initLayout()
  }

  /**
   * provide layouts for each state, with id in each root layout.
   */
  abstract fun getStateLayouts(): List<Int>

  private fun initLayout() {
    View.inflate(context, R.layout.state_container, this)
    setupStates()
    contentView = findViewById(R.id.state_content) //延后初始化，解决重写addView的问题
  }

  private fun setupStates() {
    getStateLayouts().forEach {
      View.inflate(context, it, this)
    }
  }

  fun showContent() {
    displayedChildId = R.id.state_content
  }

  /**
   * switch layout
   */
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

  override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
    if (contentView == null) {
      super.addView(child, index, params)
    } else {
      contentView!!.addView(child, index, params)
    }
  }
}