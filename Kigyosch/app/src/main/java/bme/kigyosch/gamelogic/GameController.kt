package bme.kigyosch.gamelogic

import bme.kigyosch.GameListener
import bme.kigyosch.drawing.AppleView
import bme.kigyosch.drawing.Drawable
import bme.kigyosch.drawing.SnakeView

object GameController {
        private lateinit var board: Board
        lateinit var listener: GameListener
        private var dir: Directions = Directions.RIGHT
        private var prevDir: Directions = Directions.RIGHT
        private const val snakeDefLen = 10
        val score: Int get() {
            return board.snake.len - snakeDefLen
        }
        val drawables: ArrayList<Drawable> get() {
            val arr = ArrayList<Drawable>()
            arr.add(AppleView(board.apple))
            arr.add(SnakeView(board.snake))
            return arr
        }
        fun startGame(width: Int, height: Int) {
            board = Board(width, height, snakeDefLen)
            dir = Directions.RIGHT
        }
        fun endGame() {
            listener.onGameEnd(score)
        }
        fun step() {
            board.step(dir)
            prevDir = dir
        }
        fun setDirection(_dir: Directions) {
            when(prevDir) {
                Directions.UP -> if(_dir != Directions.DOWN) dir = _dir
                Directions.RIGHT -> if(_dir != Directions.LEFT) dir = _dir
                Directions.DOWN -> if(_dir != Directions.UP) dir = _dir
                Directions.LEFT -> if(_dir != Directions.RIGHT) dir = _dir
            }
        }
}