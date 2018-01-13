package com.github.eprendre.statelayout.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_custom_state.*

class CustomStateActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_custom_state)
    error_button.setOnClickListener { custom_state_layout.showError() }
    empty_button.setOnClickListener { custom_state_layout.showEmpty() }
    loading_button.setOnClickListener { custom_state_layout.showLoading() }
    content_button.setOnClickListener { custom_state_layout.showContent() }
    custom_one_button.setOnClickListener { custom_state_layout.showCustomOne() }
    custom_two_button.setOnClickListener { custom_state_layout.showCustomTwo() }
  }
}
