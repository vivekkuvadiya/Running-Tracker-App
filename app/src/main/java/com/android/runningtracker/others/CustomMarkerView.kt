package com.android.runningtracker.others

import android.content.Context
import android.widget.TextView
import com.android.runningtracker.R
import com.android.runningtracker.db.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
    val runs:List<Run>,
    c:Context,
    layoutId:Int
):MarkerView(c, layoutId) {

    override fun getOffset(): MPPointF {
        return MPPointF(-width/2f, -height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if (e == null)
            return
        val currentId = e.x.toInt()
        val run = runs[currentId]

        findViewById<TextView>(R.id.tvDate).apply {
            val calendar = Calendar.getInstance().apply {
                timeInMillis = run.timestamp
            }
            val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            text = dateFormat.format(calendar.time)
        }

        findViewById<TextView>(R.id.tvDuration).apply {
            text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
        }

        findViewById<TextView>(R.id.tvAvgSpeed).apply {
            val avgSpeed = "${run.avgSpeedInKMH}km/h"
            text = avgSpeed
        }

        findViewById<TextView>(R.id.tvDistance).apply {
            val distanceInKm = "${run.distanceInMeters/1000}km"
            text = distanceInKm
        }

        findViewById<TextView>(R.id.tvCaloriesBurned).apply {
            val caloriesBurned = "${run.caloriesBurned}kcal"
            text = caloriesBurned
        }

    }

}