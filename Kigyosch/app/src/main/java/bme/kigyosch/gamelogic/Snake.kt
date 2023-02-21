package bme.kigyosch.gamelogic

import android.graphics.Point
import androidx.core.graphics.plus
import java.util.LinkedList

class Snake(pos: Point, baseLen: Int) {
    var parts : LinkedList<SnakeBodyPart> = LinkedList()
    val len get() = parts.size
    val headPos get() = parts.first.pos
    private val listeners: ArrayList<SnakeListener> = ArrayList()

    init {
        for(i in 0 until baseLen)
        {
            parts.add(SnakeBodyPart(pos, Directions.RIGHT))
        }
    }
    fun step(dir: Directions) {
        var prevDir = dir
        var prevPos = parts.first.pos+dir.getOffs()
        var tempPos: Point
        var tempDir: Directions

        for(part in parts) {
            tempDir = part.dir
            part.dir = prevDir
            prevDir = tempDir

            tempPos = part.pos
            part.pos = prevPos
            prevPos = tempPos
        }

        for(listener in listeners) {
            listener.onStep()
        }
    }

    fun grow() {
        parts.add(SnakeBodyPart(parts.last.pos, parts.last.dir))
        for(listener in listeners) {
           listener.onGrow(len)
        }
    }

}

interface SnakeListener {
    fun onGrow(len: Int)
    fun onStep()
}
