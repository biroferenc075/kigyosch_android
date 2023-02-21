package bme.kigyosch.persistent.data


import androidx.room.*

@Dao
interface HighScoreItemDAO {
    @Query("SELECT * FROM highscores ORDER BY score DESC, time ASC")
    fun getAll(): List<HighScoreItem>

    @Insert
    fun insert(highScoreItem: HighScoreItem): Long

    @Delete
    fun deleteItem(highScoreItem: HighScoreItem)

    @Query("DELETE FROM highscores")
    fun deleteAll()
}
