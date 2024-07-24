package com.example.pdppatterns.flyweight_and_decorator

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.pdppatterns.R

class Square(private val size: Float) : Shape {

    override fun draw(x: Float, y: Float, context: Context): View {
        val newView = View(context)
        newView.layoutParams = ViewGroup.LayoutParams(size.toInt(), size.toInt())
        newView.x = x
        newView.y = y
        newView.setBackgroundResource(R.drawable.square)
        return newView
    }
}