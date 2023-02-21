package bme.kigyosch

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.view.doOnLayout
import bme.kigyosch.drawing.Drawable

class GameView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var size = 50.0f
    var drawables: MutableList<Drawable> = mutableListOf()
    val w: Int get() {return (width/size).toInt()}
    val h: Int get() {return (height/size).toInt()}
    private var xPadding = 0
    private var yPadding = 0
    private lateinit var rect:Rect
    private lateinit var bgr:Rect
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 1F
    }
    private val bgrPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 5F
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(bgr, bgrPaint)
        canvas.drawRect(rect, paint)
        for(drawable in drawables)
            drawable.draw(size, canvas, xPadding, yPadding)
    }

    init {
        this.doOnLayout {
            xPadding = ((width-(width/size.toInt())*size)/2).toInt()
            yPadding = ((height-(height/size.toInt())*size)/2).toInt()
            bgr = Rect(0,0,width, height)
            rect = Rect(xPadding,yPadding, width-xPadding, height-yPadding)
            xPadding = ((width-(width/size.toInt())*size)/2).toInt()
            yPadding = ((height-(height/size.toInt())*size)/2).toInt()
            size = 50.0f
        }
    }
}