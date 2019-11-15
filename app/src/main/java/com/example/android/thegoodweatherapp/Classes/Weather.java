package com.example.android.thegoodweatherapp.Classes;

import android.widget.ImageView;

/**
 * Represents basic weather info such as a short description and an icon that visually represents the current weather.
 * */
public class Weather {

    public final String mDescription;
    public final int mIconResourceID;

    public Weather(String description, int iconResourceID) {
        mDescription = description;
        mIconResourceID = iconResourceID;
    }

}
