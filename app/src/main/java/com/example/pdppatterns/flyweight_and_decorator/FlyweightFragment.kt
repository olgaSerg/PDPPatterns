package com.example.pdppatterns.flyweight_and_decorator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pdppatterns.base.BaseFragment
import com.example.pdppatterns.databinding.FragmentFlyweightBinding
import kotlin.random.Random

class FlyweightFragment : BaseFragment<FragmentFlyweightBinding>() {

    private val shapeFactory by lazy { ShapeFactory() }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentFlyweightBinding {
        return FragmentFlyweightBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layout: ConstraintLayout = binding.flyweightFragment

        binding.buttonCircle.setOnClickListener {
            val (x, y) = getRandomCoordinates(layout)
            val shape = shapeFactory.getShape(ShapeType.CIRCLE)
            if (shape is Circle) {
                val newView = shape.draw(x, y, requireContext())
                layout.addView(newView)
            }
        }

        binding.buttonSquare.setOnClickListener {
            val (x, y) = getRandomCoordinates(layout)
            val shape = shapeFactory.getShape(ShapeType.SQUARE)
            if (shape is Square) {
                val newView = shape.draw(x, y, requireContext())
                layout.addView(newView)
            }
        }

        binding.buttonCircleWithBorder.setOnClickListener {
            val (x, y) = getRandomCoordinates(layout)
            val shape = shapeFactory.getShapeWithBorder(ShapeType.CIRCLE)
            val newView = shape.draw(x, y, requireContext())
            layout.addView(newView)
        }

        binding.buttonSquareWithBorder.setOnClickListener {
            val (x, y) = getRandomCoordinates(layout)
            val shape = shapeFactory.getShapeWithBorder(ShapeType.SQUARE)
            val newView = shape.draw(x, y, requireContext())
            layout.addView(newView)
        }
    }

    private fun getRandomCoordinates(layout: ConstraintLayout): Pair<Float, Float> {
        val x = Random.nextFloat() * layout.width
        val y = Random.nextFloat() * layout.height
        return Pair(x, y)
    }
}