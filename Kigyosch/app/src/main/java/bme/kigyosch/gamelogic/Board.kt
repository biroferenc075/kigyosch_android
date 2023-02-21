package bme.kigyosch.gamelogic

import android.graphics.Point
import kotlin.random.Random

class Board(var width: Int, var height: Int, snakeLen: Int) {
    var snake: Snake = Snake(Point(width/2,height/2),snakeLen)
    var apple: Apple = Apple(Point(2*width/3, 2*height/3))

    fun step(dir: Directions) {
        snake.step(dir)
        if(snake.headPos.x < 0)
            snake.headPos.x = width-1
        else if(snake.headPos.x >= width)
            snake.headPos.x = 0

        if(snake.headPos.y < 0)
            snake.headPos.y = height-1
        else if(snake.headPos.y >= height)
            snake.headPos.y = 0

        for(i in 1 until snake.len) {
            if(snake.parts[i].checkCollision(snake))
                GameController.endGame()
        }
        if(apple.checkCollision(snake))
            placeApple()
    }

    private fun placeApple() {
        var rnd = Random.nextInt(width*height-snake.len)

        val brd = Array(width) {Array(height) {true} }
        for (part in snake.parts) {
            brd[part.pos.x][part.pos.y] = false
        }

        for(i in 0 until width)
            for (j in 0 until height) {
                if(!brd[i][j])
                    continue
                if(rnd-- == 0) {
                    apple.pos = Point(i, j)
                    return
                }
            }
    }
}