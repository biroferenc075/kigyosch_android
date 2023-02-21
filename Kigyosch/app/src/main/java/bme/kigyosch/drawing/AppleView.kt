package bme.kigyosch.drawing

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import bme.kigyosch.gamelogic.Apple

class AppleView(private val apple: Apple) : Drawable {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(255,184,187,255)
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 1F
    }
    private val border = SnakeView.border
    override fun draw(size: Float, canvas: Canvas, xPadding: Int, yPadding: Int) {
        canvas.drawRect(apple.pos.x*size+xPadding,apple.pos.y*size+yPadding,(apple.pos.x+1)*size+xPadding,(apple.pos.y+1)*size+yPadding,paint)

            canvas.drawRect(apple.pos.x*size+xPadding-1,apple.pos.y*size+yPadding-1,(apple.pos.x+1)*size+xPadding+1,(apple.pos.y+1)*size+yPadding+1,
                border)
            canvas.drawRect(apple.pos.x*size+xPadding,apple.pos.y*size+yPadding,(apple.pos.x+1)*size+xPadding,(apple.pos.y+1)*size+yPadding, paint)

    }
}