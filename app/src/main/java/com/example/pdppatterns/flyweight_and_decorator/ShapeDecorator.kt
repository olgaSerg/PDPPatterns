package com.example.pdppatterns.flyweight_and_decorator

import android.content.Context
import android.view.View

open class ShapeDecorator(private val decoratedShape: Shape) : Shape {

    override fun draw(x: Float, y: Float, context: Context): View {
        return decoratedShape.draw(x, y, context)
    }
}