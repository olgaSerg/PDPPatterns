package com.example.pdppatterns.flyweight_and_decorator

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.view.View
import androidx.core.content.ContextCompat
import com.example.pdppatterns.R

class BorderShapeDecorator(
    decoratedShape: Shape,
    private val borderType: ShapeType
) : ShapeDecorator(decoratedShape) {

    override fun draw(x: Float, y: Float, context: Context): View {
        val view = super.draw(x, y, context)
        val borderResource = when (borderType) {
            ShapeType.CIRCLE -> R.drawable.circle_border
            ShapeType.SQUARE -> R.drawable.square_border
        }

        val layerDrawable = LayerDrawable(arrayOf(view.background, ContextCompat.getDrawable(context, borderResource)))
        view.background = layerDrawable

        return view
    }
}