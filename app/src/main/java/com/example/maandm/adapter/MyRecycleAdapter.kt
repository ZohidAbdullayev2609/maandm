package com.example.maandm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maandm.R
import com.example.maandm.model.Person
import com.example.maandm.ui.FirstFragment

class MyRecycleAdapter(
    private var context: Context,
    private val list: ArrayList<Person>,
    private val onClick: OnClick
) :
    RecyclerView.Adapter<MyRecycleAdapter.ViewHolder>() {

    var lastPosition = -1

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val Image: ImageView = itemView.findViewById(R.id.item_image)
        val Text: TextView = itemView.findViewById(R.id.item_text)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                onClick.onClickListener(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Image.setImageResource(list[position].image)
        holder.Text.text = list[position].name
        setAnimation(holder.itemView, position)
    }

    override fun getItemCount(): Int = list.size

    interface OnClick {
        fun onClickListener(position: Int)
    }

    private fun setAnimation(view: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            view.startAnimation(animation)
            lastPosition = position
        }
    }
}