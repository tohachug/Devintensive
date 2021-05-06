package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, timeUnits: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (timeUnits){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String{
    var humanDate: String
    var time = this.time
    var timeCompare = date.time
    val countSecond = (timeCompare-time) / SECOND
    when{
        countSecond in 0..1 -> humanDate = "только что"
        countSecond in 2..45 -> humanDate = "несколько секунд назад"
        countSecond in 46..75 -> humanDate = "минуту назад"
        countSecond in 76..2700 -> humanDate = "${countSecond/60} минут назад"
        countSecond in 2701..4500 -> humanDate = "час назад"
        countSecond in 4501..79200 -> humanDate = "${countSecond/3600} часов назад"
        countSecond in 79201..93600 -> humanDate = "день назад"
        countSecond in 93601..31104000 -> humanDate = "${countSecond/(3600*24)} дней назад"
        countSecond in -45..-1 -> humanDate = "через несколько секунд"
        countSecond in -75..-46 -> humanDate = "через минуту"
        countSecond in -2700..-76 -> humanDate = "через ${-countSecond/60} минут"
        countSecond in -4500..-2701 -> humanDate = "через час"
        countSecond in -79200..-4501 -> humanDate = "через ${-countSecond/3600} часов"
        countSecond in -93600..-79201 -> humanDate = "через день"
        countSecond in -31104000..-93601 -> humanDate = "через ${-countSecond/(3600*24)} дней"
        countSecond>31104000 -> humanDate = "более года назад"
        countSecond<-31104000 -> humanDate = "более чем через год"
        else -> humanDate = "неизвестаня ситуация"
    }
    return humanDate
}

fun TimeUnits.plural(value: Int): String{
    var result: String
    var ostDivided = value % 100 / 10
    if(ostDivided==1) {
        when(this){
            TimeUnits.SECOND -> result = "$value секунд"
            TimeUnits.MINUTE -> result = "$value минут"
            TimeUnits.HOUR -> result = "$value часов"
            TimeUnits.DAY -> result = "$value дней"
        }
    }else
        when(value % 10) {
            1 -> when (this) {
                TimeUnits.SECOND -> result = "$value секунда"
                TimeUnits.MINUTE -> result = "$value минута"
                TimeUnits.HOUR -> result = "$value час"
                TimeUnits.DAY -> result = "$value день"
            }
            2, 3, 4 -> when (this) {
                TimeUnits.SECOND -> result = "$value секунды"
                TimeUnits.MINUTE -> result = "$value минуты"
                TimeUnits.HOUR -> result = "$value часа"
                TimeUnits.DAY -> result = "$value дня"
            }
            else -> when (this) {
                TimeUnits.SECOND -> result = "$value секунд"
                TimeUnits.MINUTE -> result = "$value минут"
                TimeUnits.HOUR -> result = "$value часов"
                TimeUnits.DAY -> result = "$value дней"
            }
        }
    return result
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

