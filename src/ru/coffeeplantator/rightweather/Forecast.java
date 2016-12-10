package ru.coffeeplantator.rightweather;

import java.util.Calendar;

// Назначение класса: хранение прогноза погоды на сутки.

public class Forecast {
	
	private String source;
	private Calendar date; // Или Date?
	private String descriptionNight;
	private String temperatureNight;
	private String descriptionDay;
	private String temperatureDay;
	
	private enum Nychtemeron {
		DAY, NIGHT
	}
	
	// Конструкторы
	public Forecast() {
		this.source = null;
		this.date = null;
		this.descriptionNight = null;
		this.temperatureNight = null;
		this.descriptionDay = null;
		this.temperatureDay = null;
	}
	public Forecast(String source, Calendar date, String descriptionNight, String temperatureNight, String descriptionDay, String temperatureDay) {
		this.source = source;
		this.date = date;
		this.descriptionNight = descriptionNight;
		this.temperatureNight = temperatureNight;
		this.descriptionDay = descriptionDay;
		this.temperatureDay = temperatureDay;
	}
	public Forecast(Calendar date, String descriptionNight, String temperatureNight, String descriptionDay, String temperatureDay) {
		this.source = null;
		this.date = date;
		this.descriptionNight = descriptionNight;
		this.temperatureNight = temperatureNight;
		this.descriptionDay = descriptionDay;
		this.temperatureDay = temperatureDay;
	}
	public Forecast(Calendar date, String description, String temperature, Nychtemeron nychtemeron) {
		this.source = null;
		this.date = date;
		if (nychtemeron == Nychtemeron.NIGHT) {
			this.descriptionNight = description;
			this.temperatureNight = temperature;
			this.descriptionDay = null;
			this.temperatureDay = null;
		}
		else {
			this.descriptionNight = null;
			this.temperatureNight = null;
			this.descriptionDay = description;
			this.temperatureDay = temperature;
		}
	}
	
	// Сеттеры
	public void setSource(String source) {
		this.source = source;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public void setDescriptionNight(String descriptionNight) {
		this.descriptionNight = descriptionNight;
	}
	public void setTemperatureNight(String temperatureNight) {
		this.temperatureNight = temperatureNight;
	}
	public void setDescriptionDay(String descriptionDay) {
		this.descriptionDay = descriptionDay;
	}
	public void setTemperatureDay(String temperatureDay) {
		this.temperatureDay = temperatureDay;
	}
	
	// Геттеры
	public String getSource() {
		return this.source;
	}
	public Calendar getDate() {
		return this.date;
	}
	public String getDescriptionNight() {
		return this.descriptionNight;
	}
	public String getTemperatureNight() {
		return this.temperatureNight;
	}
	public String getDescriptionDay() {
		return this.descriptionDay;
	}
	public String getTemperatureDay() {
		return this.temperatureDay;
	}

}
