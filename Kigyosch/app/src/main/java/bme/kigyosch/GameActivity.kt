package bme.kigyosch

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import bme.kigyosch.databinding.ActivityGameBinding
import bme.kigyosch.gamelogic.Directions
import bme.kigyosch.gamelogic.GameController
import java.util.*


class GameActivity : AppCompatActivity(), ViewTreeObserver.OnGlobalLayoutListener, GameListener {
    lateinit var binding: ActivityGameBinding
    private lateinit var timer: Timer
    var timerTicks: Int = 0
    val timerPeriod: Long = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gameView
        initButton(binding.buttonDown, Directions.DOWN)
        initButton(binding.buttonUp, Directions.UP)
        initButton(binding.buttonLeft, Directions.LEFT)
        initButton(binding.buttonRight, Directions.RIGHT)
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    override fun onResume() {
        super.onResume()
        binding.gameView.viewTreeObserver.addOnGlobalLayoutListener(this)
    }

    private fun initButton(btn: ImageButton, dir: Directions) {
        btn.setOnClickListener {
            GameController.setDirection(dir)
        }
    }

    override fun onGlobalLayout() {
        binding.gameView.viewTreeObserver.removeOnGlobalLayoutListener(this)
        GameController.listener = this
        GameController.startGame(binding.gameView.w,binding.gameView.h)
        binding.gameView.drawables.addAll(GameController.drawables)

        val repeatedTask: TimerTask = object : TimerTask() {
            override fun run() {
                timerTicks++
                GameController.step()
                runOnUiThread {
                    binding.scoreText.text = getString(R.string.scoreText, GameController.score)
                    binding.timeText.text = getString(R.string.timerText,TimeFormatter.formatTime(timerTicks*timerPeriod/1000.0f.toLong()))
                    binding.gameView.invalidate()
                }
            }
        }
        timer = Timer("Timer")
        timer.scheduleAtFixedRate(repeatedTask, 0, timerPeriod)

    }

    override fun onGameEnd(score: Int) {
        timer.cancel()
        runOnUiThread {
            val intent = Intent(this, GameOverActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("time", (timerTicks*timerPeriod/1000.0f.toInt()))
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
}