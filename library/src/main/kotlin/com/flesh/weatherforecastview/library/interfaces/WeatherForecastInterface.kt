package com.flesh.weatherforecastview.library.interfaces

import com.flesh.weatherforecastview.library.helpers.WeatherHelper


/**
 * Created by afleshner on 2/7/2017.
 * interface that allow you to put anything in that view that conforms to this interface.
 */
interface WeatherForecastInterface {

    fun getWeatherLocation(): String
    fun getCurrentTemperature(): String
    fun getCurrentWeatherForecast(): String
    fun getHeatherHelperList(): MutableList<WeatherHelper>
    fun getTodaysHigh(isNight: Boolean): String
    fun getTodaysLow(isNight: Boolean): String
    fun getTodaysPOP(): String
    fun getCurrentObservationDate(): String

}