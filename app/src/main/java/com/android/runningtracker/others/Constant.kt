package com.android.runningtracker.others

import android.graphics.Color

object Constant {

    const val RUNNING_DATABASE_NAME = "running_db"

    const val REQUEST_CODE_LOCATION = 0

    const val ACTION_START_OR_RESUME_SERVICES = "ACTION_START_OR_RESUME_SERVICES"
    const val ACTION_PAUSE_SERVICES = "ACTION_PAUSE_SERVICES"
    const val ACTION_STOP_SERVICES = "ACTION_STOP_SERVICES"
    const val ACTION_SHOW_TRACKING_FRAGMENT = "ACTION_SHOW_TRACKING_FRAGMENT"

    const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
    const val NOTIFICATION_CHANNEL_NAME = "Tracking"
    const val NOTIFICATION_ID = 1

    const val POLYLINE_COLOR = Color.RED
    const val POLYLINE_WIDTH = 8f
    const val MAP_ZOOM = 15f

    const val TIMER_UPDATE_INTERVAL = 50L

    const val LOCATION_UPDATE_INTERVAL = 5000L
    const val LOCATION_FAST_INTERVAL = 2000L

    const val SHARED_PREFERENCE_NAME = "sharedPref"
    const val KEY_FIRST_TIME_TOGGLE = "KEY_FIRST_TIME_TOGGLE"
    const val KEY_NAME = "KEY_NAME"
    const val KEY_WIGHT = "KEY_WIGHT"

    const val CANCEL_TRACKING_DIALOG_TAG = "CANCEL_TRACKING_DIALOG_TAG"

}