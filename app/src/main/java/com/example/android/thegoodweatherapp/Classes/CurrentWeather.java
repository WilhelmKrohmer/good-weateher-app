package com.example.android.thegoodweatherapp.Classes;

public class CurrentWeather {
    Coordinates coord;
    BasicInfo basicInfo;

    private class Coordinates {
        Float longitude;
        Float latitude;
    }

    private class BasicInfo {
        int weatherID;
        String main;
        String description;
        String iconID;
    }
}
