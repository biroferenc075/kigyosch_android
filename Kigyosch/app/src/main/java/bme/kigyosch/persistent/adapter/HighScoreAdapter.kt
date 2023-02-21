package bme.kigyosch.persistent.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bme.kigyosch.R
import bme.kigyosch.TimeFormatter
import bme.kigyosch.persistent.data.HighScoreItem


class HighScoreAdapter(private val dataSet: List<HighScoreItem>) :
    RecyclerView.Adapter<HighScoreAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val no: TextView
        val name: TextView
        val score: TextView
        val time: TextView
        val pic: ImageView
        init {
            no = view.findViewById(R.id.no)
            name = view.findViewById(R.id.name)
            score = view.findViewById(R.id.score)
            time = view.findViewById(R.id.time)
            pic = view.findViewById(R.id.posIcon)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.highscore_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.no.text = (position+1).toString()
        viewHolder.name.text = dataSet[position].name
        viewHolder.score.text = dataSet[position].score.toString()
        viewHolder.time.text = TimeFormatter.formatTime(dataSet[position].time)
        viewHolder.pic.setImageResource(when(position+1){
            1 -> R.drawable.crown_gold
            2 -> R.drawable.crown_silver
            3 -> R.drawable.crown_bronze
            else -> R.drawable.crown_none
        })
    }

    override fun getItemCount() = dataSet.size
}