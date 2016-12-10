package ru.coffeeplantator.rightweather;

import java.util.ArrayList;

// Назначение класса: логика приложения.

public class RightWeatherManager {
	public ArrayList<Forecast> forecastsByDays = new ArrayList<Forecast>();
	public RightWeatherManager() {
		Thread thread1 = new Thread(() -> {
			HTTPHandler meteo5 = new HTTPHandler("http://www.meteovesti.ru/pogoda_5/27612", "windows-1251");
//			HTTPHandler meteo5 = new HTTPHandler("http://www.solyagoda.ru/", "utf-8");
			String meteo5HTML = meteo5.makeRequest().toString();
			System.out.println(meteo5HTML);
		});
		thread1.start();
		Thread thread2 = new Thread(() -> {
			HTTPHandler meteo10 = new HTTPHandler("http://www.meteovesti.ru/pogoda_10/27612", "windows-1251");
//			HTTPHandler meteo10 = new HTTPHandler("http://www.solyagoda.ru/about.html", "utf-8");
			String meteo10HTML = meteo10.makeRequest().toString();
			System.out.println(meteo10HTML);
		});
		thread2.start();
//		try {
//			thread1.join();
//			thread2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
