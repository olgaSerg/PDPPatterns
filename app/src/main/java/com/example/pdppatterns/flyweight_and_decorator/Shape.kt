package com.example.pdppatterns.flyweight_and_decorator

import android.content.Context
import android.view.View

interface Shape {

    fun draw(x: Float, y: Float, context: Context): View
}