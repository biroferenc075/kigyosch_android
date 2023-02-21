package bme.kigyosch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import bme.kigyosch.databinding.ActivityScoreBoardBinding
import bme.kigyosch.persistent.adapter.HighScoreAdapter
import bme.kigyosch.persistent.data.HighScoreDb
import kotlin.concurrent.thread

class ScoreBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_menu)
        binding = ActivityScoreBoardBinding.inflate(layoutInflater)
        thread(start = true) {
            val dataSet = HighScoreDb.getDatabase(this).highScoreItemDAO().getAll()
            runOnUiThread {
                binding.recycler.layoutManager = LinearLayoutManager(this)
                binding.recycler.adapter = HighScoreAdapter(dataSet)
            }
            }
        setContentView(binding.root)
    }
}