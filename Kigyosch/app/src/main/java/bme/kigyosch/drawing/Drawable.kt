package bme.kigyosch.drawing

import android.graphics.Canvas

interface Drawable {
    fun draw(size: Float, canvas: Canvas, xPadding: Int, yPadding: Int)
}