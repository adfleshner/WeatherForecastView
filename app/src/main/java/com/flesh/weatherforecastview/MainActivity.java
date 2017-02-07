package com.flesh.weatherforecastview;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flesh.weatherforcast.ForecastView;

public class MainActivity extends AppCompatActivity {

    private ForecastView forecastView;
    private WeatherGetter wg = new WeatherGetter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forecastView = (ForecastView) findViewById(R.id.fullForecast);
        forecastView.setForecastData(wg.getWeather());
        forecastView.setResfreshListener(new ForecastView.RefreshForCastListener() {
            @Override
            public void onRefresh() {
                forecastView.showLoading();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        forecastView.hideLoading();
                        forecastView.setForecastData(wg.getWeather());
                    }
                }, 2000);
            }
        });
    }
}
