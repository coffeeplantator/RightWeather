package ru.coffeeplantator.rightweather;
	
import javafx.application.Application;
import javafx.stage.Stage;

public class RightWeather extends Application {
	@Override
	public void start(Stage primaryStage) {
		new RightWeatherWindow(primaryStage);
		new RightWeatherManager();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
