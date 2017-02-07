package com.flesh.weatherforcast

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.flesh.library.R
import com.flesh.weatherforcast.helper.WeatherHelper
import com.flesh.weatherforcast.interfaces.WeatherForecastInterface
import edu.ua.caps.emergencypreparedness.extensions.loadLocalImage
import kotlinx.android.synthetic.main.cell_day_forecast_full.view.*

/**
 * Created by afleshner on 2/3/2017.
 */
class ForecastView : RelativeLayout {

    internal var view: View = View.inflate(context, R.layout.cell_day_forecast_full, this)
    internal var data: MutableList<WeatherHelper> = mutableListOf()
    internal var mRefreshListener: RefreshForCastListener? = null

    fun setResfreshListener(listener: RefreshForCastListener) {
        this.mRefreshListener = listener
    }

    interface RefreshForCastListener {
        fun onRefresh()
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {

    }

    fun showLoading() {
        pbDayForecastWeatherLoading.visibility = View.VISIBLE
        ivDayForecastRefresh.visibility = View.GONE
    }

    fun hideLoading() {
        pbDayForecastWeatherLoading.visibility = View.GONE
        ivDayForecastRefresh.visibility = View.VISIBLE
    }


    fun setForecastData(weatherInterface: WeatherForecastInterface) {
        tvDayForecastLocation.text = weatherInterface.getWeatherLocation()
        tvDayForecastCurrTemp.text = weatherInterface.getCurrentTemperature()

        tvDayForecast.text = weatherInterface.getCurrentWeatherForecast()

        var list = weatherInterface.getHeatherHelperList()

        var isNight = list[0].startPeriodName.contains("Tonight")
        ivDayWeather.getWeatherImage(list[0].weather.toLowerCase(), isNight)
        var high: String = weatherInterface.getTodaysHigh(isNight)
        var low: String = weatherInterface.getTodaysLow(isNight)
        tvDayForecastHighAndLowTemp.text = context.getString(R.string.high_low,high,low)
        tvDayForecastDescription.text = context.getString(R.string.chance_of_rain,weatherInterface.getTodaysPOP())
        if (isNight) {
            for (i in 3 until list.size - 4) {
                if (i % 2 == 1)
                    view.llDayConditions.addView(MiniDayView(context, list[i].startPeriodName, list[i].weather.toLowerCase(), list[i].temperature ?: "--", list.getOrNull(i - 1)?.temperature ?: "-", list[i].iconLink))
            }
        } else {
            for (i in 2 until list.size - 3) {
                if (i % 2 == 0)
                    view.llDayConditions.addView(MiniDayView(context, list[i].startPeriodName, list[i].weather.toLowerCase(), list[i].temperature ?: "--", list.getOrNull(i + 1)?.temperature ?: "-", list[i].iconLink))
            }
        }
        llDayForecastRefresh.setOnClickListener {
            llDayConditions.removeAllViews()
            mRefreshListener?.onRefresh()
        }
        tvCurrentObservation.text = "Last forecast update: ${weatherInterface.getCurrentObservationDate()}"
    }


}

fun ImageView.getWeatherImage(weatherType: String, isNight: Boolean) {
    if (weatherType.contains("clearing") || (weatherType.contains("partly") && weatherType.contains("cloudy")) || ((weatherType.contains("mostly") || weatherType.contains("partly")) && weatherType.contains("sunny")) || (weatherType.contains("decreasing") && weatherType.contains("clouds"))) {
        // Clearing or Partly Cloudy
        if (isNight) {
            this.loadLocalImage(context, R.drawable.ic_partly_cloudy_night)
        } else {
            this.loadLocalImage(context, R.drawable.ic_partly_cloudy)
        }
    } else if (weatherType.contains("sunny")) {
        // Sunny
        this.loadLocalImage(context, R.drawable.ic_sunny)

    } else if (weatherType.contains("storm")) {
        // T-Storm
        this.loadLocalImage(context, R.drawable.ic_storm)
    } else if (weatherType.contains("shower")) {
        // Showers
        this.loadLocalImage(context, R.drawable.ic_rain)
    } else if (weatherType.contains("rain")) {
        // Rain
        this.loadLocalImage(context, R.drawable.ic_heavy_rain)
    } else if (weatherType.contains("snow")) {
        // Snow
        this.loadLocalImage(context, R.drawable.ic_snow)
    } else if (weatherType.contains("wind")) {
        // Windy
        this.loadLocalImage(context, R.drawable.ic_windy)
    } else if (weatherType.contains("sleet") || (weatherType.contains("rain") && weatherType.contains("snow"))) {
        // Sleet/Snow mixed with rain
        this.loadLocalImage(context, R.drawable.ic_sleet)
    } else if (weatherType.contains("shower") || weatherType.contains("rain") && (weatherType.contains("partly") && weatherType.contains("cloudy"))) {
        // Partly cloudy then rain/showers
        this.loadLocalImage(context, R.drawable.ic_partly_cloudy_rain)
    } else if (weatherType.contains("cloudy") || weatherType.contains("overcast")) {
        // Cloudy
        this.loadLocalImage(context, R.drawable.ic_cloudy)
    } else if (weatherType.contains("clear")) {
        // Clear
        if (isNight) {
            this.loadLocalImage(context, R.drawable.ic_clear)
        } else {
            this.loadLocalImage(context, R.drawable.ic_sunny)
        }
    } else if (weatherType.contains("fog")) {
        // Fog
        if (isNight) {
            this.loadLocalImage(context, R.drawable.ic_fog_night)
        } else {
            this.loadLocalImage(context, R.drawable.ic_fog_day)
        }
        this.loadLocalImage(context, R.drawable.ic_partly_cloudy)
    } else {
        this.loadLocalImage(context, 0)
    }

}