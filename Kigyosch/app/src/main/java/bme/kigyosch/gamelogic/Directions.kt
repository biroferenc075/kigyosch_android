package bme.kigyosch.gamelogic

import android.graphics.Point

enum class Directions {
    UP, RIGHT, DOWN, LEFT;
    fun getOffs():Point {
        return when(this) {
            UP -> Point(0,-1)
            RIGHT -> Point(1,0)
            DOWN -> Point(0,1)
            LEFT -> Point(-1,0)
        }
    }
}