package com.example.pdppatterns.flyweight_and_decorator

class ShapeFactory {

    private val shapeCache = mutableMapOf<ShapeType, Shape>()
    private val shapeWithBorderCache = mutableMapOf<ShapeType, Shape>()

    init {
        shapeCache[ShapeType.CIRCLE] = Circle(50f)
        shapeCache[ShapeType.SQUARE] = Square(50f)
    }

    fun getShape(shapeType: ShapeType): Shape? {
        return shapeCache[shapeType]
    }

    fun getShapeWithBorder(shapeType: ShapeType): Shape {
        return shapeWithBorderCache[shapeType] ?: let {
            val shape = getShape(shapeType)
            val shapeWithBorder = when (shapeType) {
                ShapeType.CIRCLE -> BorderShapeDecorator(shape as Circle, ShapeType.CIRCLE)
                ShapeType.SQUARE -> BorderShapeDecorator(shape as Square, ShapeType.SQUARE)
            }
            shapeWithBorderCache[shapeType] = shapeWithBorder
            shapeWithBorder
        }
    }
}