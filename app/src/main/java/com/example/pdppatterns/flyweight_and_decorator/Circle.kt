package com.example.pdppatterns.flyweight_and_decorator

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.pdppatterns.R

class Circle(private val diameter: Float) : Shape {

    override fun draw(x: Float, y: Float, context: Context): View {
        val newView = View(context)
        newView.layoutParams = ViewGroup.LayoutParams(diameter.toInt(), diameter.toInt())
        newView.x = x
        newView.y = y
        newView.setBackgroundResource(R.drawable.circle)
        return newView
    }
}