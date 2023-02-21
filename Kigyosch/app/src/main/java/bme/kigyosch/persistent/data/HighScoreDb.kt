package bme.kigyosch.persistent.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HighScoreItem::class], version = 1, exportSchema = false)
abstract class HighScoreDb : RoomDatabase() {
    abstract fun highScoreItemDAO(): HighScoreItemDAO
    companion object {
        fun getDatabase(applicationContext: Context): HighScoreDb {
            return Room.databaseBuilder(
                applicationContext,
                HighScoreDb::class.java,
                "highscores"
            ).build()
        }
    }
}