package bme.kigyosch

import android.app.ActivityOptions
import android.content.Intent
import android.content.Intent.*
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import bme.kigyosch.databinding.ActivityGameOverBinding
import bme.kigyosch.persistent.data.HighScoreDb
import bme.kigyosch.persistent.data.HighScoreItem
import com.google.android.material.snackbar.Snackbar
import kotlin.concurrent.thread

class GameOverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameOverBinding
    private var playerName: String = ""
    private var score = 0
    private var time = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        score = intent.getIntExtra("score", 0)
        time = intent.getLongExtra("time", 0)
        binding.timeText.text = getString(R.string.final_time, TimeFormatter.formatTime(time))
        binding.scoreText.text = getString(R.string.final_score, score)
        binding.btnSaveScore.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Do you wish to save your score?")
            builder.setCancelable(false)
            val input = EditText(this)
            input.hint = "Username"
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            builder.setPositiveButton(
                "Save"
            ) { _, _ ->
                playerName = input.text.toString()
                save()
            }
            builder.setNegativeButton(
                "Cancel"
            ) { dialog, _ -> dialog.cancel() }

            val dialog = builder.create()
            dialog.show()
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = false
            input.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).isEnabled = input.text.toString().isNotEmpty()
                }
                override fun afterTextChanged(s: Editable) {}
            })
        }
        binding.btnToMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
            }
        binding.btnNewGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.flags = FLAG_ACTIVITY_CLEAR_TOP
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        binding.btnHighScores.setOnClickListener {
            val intent = Intent(this, ScoreBoardActivity::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }

    }
    private fun save() {
        thread(start = true) {
            HighScoreDb.getDatabase(this).highScoreItemDAO().insert(
                HighScoreItem(
                    name = playerName,
                    score = score,
                    time = time))
        }
        binding.btnSaveScore.background.setTint(Color.DKGRAY)
        binding.btnSaveScore.setOnClickListener {
            Snackbar.make(binding.root, R.string.already_saved, Snackbar.LENGTH_SHORT).setAction(R.string.dismiss) {}.show()
        }
    }
}