package bme.kigyosch.gamelogic

import android.graphics.Point

class Apple(var pos: Point) : Collider {
    override fun checkCollision(snake: Snake): Boolean {
        if(snake.headPos == pos) {
            collide(snake)
            return true
        }
        return false
    }

    override fun collide(snake: Snake) {
        snake.grow()
    }

}