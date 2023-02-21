package bme.kigyosch.gamelogic

import android.graphics.Point

class SnakeBodyPart(var pos: Point, var dir: Directions) : Collider {
    override fun checkCollision(snake: Snake): Boolean {
        if(snake.headPos == pos) {
            collide(snake)
            return true
        }
        return false
    }

    override fun collide(snake: Snake) {

    }
}