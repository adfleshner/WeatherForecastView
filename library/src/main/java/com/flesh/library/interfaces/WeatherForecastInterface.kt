package com.flesh.weatherforcast.interfaces

import com.flesh.weatherforcast.helper.WeatherHelper

/**
 * Created by afleshner on 2/7/2017.
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