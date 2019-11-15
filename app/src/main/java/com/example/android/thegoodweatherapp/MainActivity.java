package com.example.android.thegoodweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.thegoodweatherapp.Classes.CurrentWeather;
import com.example.android.thegoodweatherapp.Classes.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView currentWeathertextView = findViewById(R.id.current_weather_text_view);
        final ImageView currentWeatherImageView = findViewById(R.id.current_weather_image_view);

        fetchJSON();

        //Weather currentWeather = new Weather("Cloudy", R.drawable.ic_launcher_foreground);

        //currentWeathertextView.setText(currentWeather.mDescription);
        //currentWeatherImageView.setImageResource(currentWeather.mIconResourceID);

    }

    /**
     * Fetches JSON data from openweather.com API
     * */
    public void fetchJSON() {

        String URL = "https://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=49d4ef5a4a7bc42537eebbf7fcd816dc";

        Request request = new Request.Builder().url(URL).build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(getApplicationContext(), "Failed to execute request", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String body = Objects.requireNonNull(response.body()).string();
                Log.i("response", body);

                Gson gson = new GsonBuilder().create();
                CurrentWeather currentWeather = gson.fromJson(body, CurrentWeather.class);

                //Gson gson = new Gson();
                //CurrentWeather currentWeather = gson.fromJson(body, CurrentWeather.class);

            }
        });

    }

}
