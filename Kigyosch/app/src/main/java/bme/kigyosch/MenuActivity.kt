package bme.kigyosch

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import bme.kigyosch.databinding.ActivityMenuBinding


class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var rotAnimator:ObjectAnimator
    private lateinit var scalexAnimator: ObjectAnimator
    private lateinit var scaleyAnimator: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, ScoreBoardActivity::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }

        rotAnimator = ObjectAnimator.ofFloat(binding.imageView, "rotation", 5f).apply {
            duration = 2000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }
        scalexAnimator =ObjectAnimator.ofFloat(binding.imageView, "scaleX", 1.1f).apply {
            duration = 1000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }
        scaleyAnimator = ObjectAnimator.ofFloat(binding.imageView, "scaleY", 1.1f).apply {
            duration = 1000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }

    override fun onResume() {
        super.onResume()
        rotAnimator.resume()
        scalexAnimator.resume()
        scaleyAnimator.resume()
    }

    override fun onPause() {
        super.onPause()
        rotAnimator.pause()
        scalexAnimator.pause()
        scaleyAnimator.pause()
    }
}