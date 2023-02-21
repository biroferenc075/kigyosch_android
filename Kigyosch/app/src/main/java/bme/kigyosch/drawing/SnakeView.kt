package bme.kigyosch.drawing

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import bme.kigyosch.gamelogic.Snake

class SnakeView(private var snake: Snake) : Drawable {
    companion object {
        val colors: ArrayList<Int> = ArrayList()
        val border = Paint().apply { style = Paint.Style.STROKE; strokeWidth= 8F; color = Color.WHITE }
        const val res = 16
        const val colorSize = 2* res
        init {
            for(i in 0 until res +1)
                colors.add(Color.rgb(255-255/ res *i,255/ res *i,255))
            for(i in res downTo  0)
                colors.add(Color.rgb(255-255/ res *i,255/ res *i,255))

        }
    }
    override fun draw(size: Float, canvas: Canvas, xPadding: Int, yPadding: Int) {
        val paint = Paint().apply {
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 1F

        }
        for(part in snake.parts.reversed()){
            canvas.drawRect(part.pos.x*size+xPadding-1,part.pos.y*size+yPadding-1,(part.pos.x+1)*size+xPadding+1,(part.pos.y+1)*size+yPadding+1, border)
        }
        for((i, part) in snake.parts.reversed().withIndex()) {
            paint.color = colors[i % colorSize]
            canvas.drawRect(part.pos.x*size+xPadding,part.pos.y*size+yPadding,(part.pos.x+1)*size+xPadding,(part.pos.y+1)*size+yPadding, paint)
        }
    }
}