package com.flesh.weatherforecastview.library

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.cell_day_forecast_mini.view.*

/**
 * Created by afleshner on 2/7/2017.
 * The view inside of the horizontal recyclerview.
 */
class MiniDayView : LinearLayout {

    var dayName: String? = null
    var high: String? = null
    var low: String? = null
    var image: String? = null

    var view: View = View.inflate(context, R.layout.cell_day_forecast_mini, this)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    fun setData(dayName: String, weatherType: String, high: String, low: String, image: String){
        this.dayName = dayName
        this.low = low
        this.high = high
        this.image = image
        view.tvMiniCellDay.text = dayName
        view.tvMiniCellTemperature.text = context.getString(R.string.high_low,high,low)
        view.ivMiniDay.getWeatherImage(weatherType, false)
    }

    init {

    }


}
