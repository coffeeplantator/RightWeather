package ru.coffeeplantator.rightweather;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Назначение класса: создание графического интерфейса.

public class RightWeatherWindow {
	
	public RightWeatherWindow(Stage primaryStage) {
		try {
			primaryStage.setMinWidth(900);
			primaryStage.setMinHeight(280);
//			primaryStage.initStyle(StageStyle.TRANSPARENT);
			StackPane rootNode = new StackPane();
			Scene scene = new Scene(rootNode,1000,300);
			
			GridPane gridNode = new GridPane();
//			gridNode.setGridLinesVisible(true);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    gridNode.setHgap(0);
		    gridNode.setVgap(0);
//		    gridNode.setPadding(new Insets(10, 10, 10, 10));
		    gridNode.setStyle("-fx-background-color: #ffffff;");
		    
		    Pane paneService = new Pane();
		    paneService.setStyle("-fx-background-color: #3f4349;");
		    Pane paneDate = new Pane();
		    paneDate.setStyle("-fx-background-color: #d4d2d1;");
		    Pane paneNight = new Pane();
		    paneNight.setStyle("-fx-background-color: #f6f6f5;");
		    Pane paneDay = new Pane();
		    paneDay.setStyle("-fx-background-color: #ffffff;");
		    gridNode.add(paneService, 0, 0, 11, 1);
		    gridNode.add(paneDate, 0, 1, 11, 1);
		    gridNode.add(paneNight, 0, 2, 11, 1);
		    gridNode.add(paneDay, 0, 3, 11, 1);
			
			ColumnConstraints[] columns = new ColumnConstraints[11];
			for (int i = 0; i < columns.length; i++) {
				columns[i] = new ColumnConstraints();
				columns[i].setPercentWidth(10);
				gridNode.getColumnConstraints().add(columns[i]);
			}
			
			RowConstraints row1 = new RowConstraints();
			row1.setPercentHeight(15);
			RowConstraints row2 = new RowConstraints();
			row2.setPercentHeight(15);
			RowConstraints row3 = new RowConstraints();
			row3.setPercentHeight(35);
			RowConstraints row4 = new RowConstraints();
			row4.setPercentHeight(35);
			gridNode.getRowConstraints().addAll(row1, row2, row3, row4);

			Text serviceName = new Text("Фобос — Метеовести");
		    serviceName.setFill(Color.web("#dc9a52"));
		    GridPane.setMargin(serviceName, new Insets(10, 10, 10, 10));
//		    GridPane.setConstraints(serviceName, 1, 1, 1, 2,HPos.LEFT, VPos.CENTER);
		    serviceName.setFont(Font.font(serviceName.getFont().getName(), FontWeight.BOLD, (serviceName.getFont().getSize() * 1.5)));
			gridNode.add(serviceName, 1, 0, 10, 1);

			gridNode.add(new Text("01.12"), 1, 1);
		    gridNode.add(new Text("02.12"), 2, 1);
		    gridNode.add(new Text("03.12"), 3, 1);
		    gridNode.add(new Text("04.12"), 4, 1);
		    gridNode.add(new Text("05.12"), 5, 1);
		    gridNode.add(new Text("06.12"), 6, 1);
		    gridNode.add(new Text("07.12"), 7, 1);
		    gridNode.add(new Text("08.12"), 8, 1);
		    gridNode.add(new Text("09.12"), 9, 1);
		    gridNode.add(new Text("10.12"), 10, 1);
		    
		    Text night = new Text("Ночь:");
		    Text day = new Text("День:");
		    GridPane.setConstraints(night, 0, 2, 1, 1, HPos.CENTER, VPos.CENTER);
		    GridPane.setConstraints(day, 0, 3, 1, 1, HPos.CENTER, VPos.CENTER);
		    night.setFont(Font.font(night.getFont().getName(), FontWeight.BOLD, (night.getFont().getSize() * 1)));
		    day.setFont(Font.font(day.getFont().getName(), FontWeight.BOLD, (day.getFont().getSize() * 1)));
		    gridNode.add(night, 0, 2);
		    gridNode.add(day, 0, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 1, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 1, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 2, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 2, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 3, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 3, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 4, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 4, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 5, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 5, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 6, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 6, 3);
		    
		    gridNode.add(new Text("\nЯсно\n\n\n-3°"), 7, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 7, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 8, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 8, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nс\nпросветами\n\n-3°"), 9, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 9, 3);
		    
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-3°"), 10, 2);
		    gridNode.add(new Text("Пасмурно,\nнебольшой\nснег\n\n-4°"), 10, 3);
		    
		    AnchorPane anchorNode = new AnchorPane();
		    Label updateInfo = new Label("Обновлено: 00:12 02.12.2016");
		    updateInfo.setFont(Font.font(updateInfo.getFont().getName(), FontWeight.NORMAL, (updateInfo.getFont().getSize() * 0.8)));
		    updateInfo.setTextFill(Color.web("#dc9a52"));
		    updateInfo.setPadding(new Insets(8, 0, 0, 0));
		    Button updateButton = new Button("Обновить");
//		    Button settingsButton = new Button("Настройки");
		    HBox hbox = new HBox();
		    hbox.setSpacing(10);
		    hbox.getChildren().addAll(updateInfo, updateButton);
		    anchorNode.getChildren().addAll(hbox);
		    AnchorPane.setTopAnchor(hbox, 10.0);
		    AnchorPane.setRightAnchor(hbox, 10.0);
		    
//			rootNode.setCenter(gridNode);
		    rootNode.getChildren().addAll(gridNode, anchorNode);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			System.err.println("Ошибка создания интерфейса.\n");
			e.printStackTrace();
		}
	}

}
