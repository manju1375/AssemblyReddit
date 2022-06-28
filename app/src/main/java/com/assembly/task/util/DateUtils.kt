package com.assembly.task.util

import java.text.SimpleDateFormat
import java.util.*


/**
 * Developed by Manjunath on 19,June,2022
 */

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
    return format.format(date)
}
