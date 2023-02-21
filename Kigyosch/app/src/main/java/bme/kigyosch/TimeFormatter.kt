package bme.kigyosch

class TimeFormatter {
    companion object {
        fun formatTime(time: Long) : String {
            val min = time/60
            val sec = time%60
            val minStr = String.format("%d",min)
            val secStr = if(sec < 10) String.format("0%d", sec) else String.format("%d",sec)
            return "$minStr:$secStr"
        }
    }
}