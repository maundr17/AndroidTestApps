package com.maundr17.tempconverter;


public class Converter
{
    public static double toCelsius(double temp)
    {
        double celsius = (temp - 32) * (5.0 / 9.0);
        return celsius;
    }

    public static double toFahrenheit(double temp)
    {
        double fahr = temp * (9.0 / 5.0) + 32;
        return fahr;
    }
}
