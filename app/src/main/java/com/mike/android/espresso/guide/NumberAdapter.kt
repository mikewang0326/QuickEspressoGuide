package com.mike.android.espresso.guide;

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NumberAdapter(count: Int, private val listener: OnItemClickListener?) : RecyclerView.Adapter<NumberAdapter.TextViewHolder>() {
    private val labels: MutableList<String>

    init {
        labels = ArrayList(count)
        for (i in 0 until count) {
            labels.add(i.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.footer, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val label = labels[position]
        holder.textView.setText(label)

        if (listener != null) {
            holder.textView.setOnClickListener {
                listener.onItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return labels.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView as TextView
    }
}