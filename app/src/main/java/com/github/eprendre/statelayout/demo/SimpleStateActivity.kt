package com.github.eprendre.statelayout.demo

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_simple_state.*

class SimpleStateActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_simple_state)
    error_button.setOnClickListener { state_layout.showError() }
    empty_button.setOnClickListener { state_layout.showEmpty() }
    loading_button.setOnClickListener { state_layout.showLoading() }
    content_button.setOnClickListener { state_layout.showContent() }

    state_layout.setErrorListener {
      state_layout.showLoading()
      Handler().postDelayed({
        state_layout.showContent()
      }, 1000)
    }
  }
}
