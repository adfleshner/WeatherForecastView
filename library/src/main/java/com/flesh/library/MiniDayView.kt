package com.flesh.weatherforcast

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.flesh.library.R

import kotlinx.android.synthetic.main.cell_day_forecast_mini.view.*

/**
 * Created by afleshner on 2/7/2017.
 */
class MiniDayView(context: Context, dayName: String, weatherType: String, high: String, low: String, image: String) : LinearLayout(context) {

    var dayName: String? = null
    var high: String? = null
    var low: String? = null
    var image: String? = null

    var view: View = View.inflate(context, R.layout.cell_day_forecast_mini, this)

    init {
        this.dayName = dayName
        this.low = low
        this.high = high
        this.image = image
        view.tvMiniCellDay.text = dayName
        view.tvMiniCellTemperature.text = "$high\u2109 / $low\u2109"
        view.ivMiniDay.getWeatherImage(weatherType, false)
    }


}
