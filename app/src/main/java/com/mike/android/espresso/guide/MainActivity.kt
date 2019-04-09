package com.mike.android.espresso.guide

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
  private lateinit var greetingView: TextView
  private lateinit var greetButton: View

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initTitlebar()
    initGreet()
    initRecycleView()
  }

  private fun initGreet() {
    greetingView = findViewById(R.id.greeting)
    greetButton = findViewById(R.id.greet_button)
  }

  private fun initTitlebar() {
    setTitle(R.string.title)
  }

  fun greet(v: View) {
    greetButton.isEnabled = false
    greetingView.setText(R.string.hello)
  }

  private fun initRecycleView() {
    val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
    val footer = findViewById<TextView>(R.id.footer)
    footer.setBackgroundColor(Color.LTGRAY)
    footer.visibility = View.VISIBLE

    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = NumberAdapter(30, object : NumberAdapter.OnItemClickListener {
      override fun onItemClick(position: Int) {
        footer.text = position.toString()
        footer.visibility = View.VISIBLE
      }
    })
  }
}
