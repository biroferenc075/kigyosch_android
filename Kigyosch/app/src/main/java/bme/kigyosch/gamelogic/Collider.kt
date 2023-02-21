package bme.kigyosch.gamelogic


interface Collider {
    fun checkCollision(snake: Snake): Boolean
    fun collide(snake: Snake)
}