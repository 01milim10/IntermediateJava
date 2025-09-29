package com.milanbud.weather;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {

    static void main(String[] args) throws IOException {
        WeatherAPI api = new WeatherAPI();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the city name: ");
        String city = scanner.nextLine();

        String forecastString = api.getForecast(city);

        WeatherResponseParser parser = new WeatherResponseParser();
        parser.parseAndPrint(forecastString);
    }

}
