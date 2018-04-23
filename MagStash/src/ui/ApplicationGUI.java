/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class ApplicationGUI extends Application {
//JavaFX applicatoin still use the main method.
//It should only ever contain the call to the launch method
public static void main(String[] args) {
launch(args);
}
//starting point for the application
//this is where we put the code for the user interface
@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Library v1.0");
    
    GridPane grid = new GridPane();
    //grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
    //grid.setGridLinesVisible(true);
    
    Text sceneTitle = new Text("Library (v1.0)");
    sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(sceneTitle, 0, 0, 2, 1); //add(itemName, column, row, columnspan, rowspan)
    Text sceneMessage = new Text("  Choose an action:");
    grid.add(sceneMessage, 1, 0);
    Button btnViewLit = new Button("View literature");
    HBox HbtnViewLit = new HBox(10);
    HbtnViewLit.setAlignment(Pos.CENTER);
    HbtnViewLit.getChildren().add(btnViewLit);
    grid.add(HbtnViewLit, 1, 0);
    Button btnAddLit = new Button("Add literature");
    HBox HbtnAddLit = new HBox(10);
    HbtnAddLit.setAlignment(Pos.CENTER_RIGHT); //????????????????
    HbtnAddLit.getChildren().add(btnAddLit);
    grid.add(btnAddLit, 1, 0);
    
    Line headerLine = new Line(0, 0, 1280, 0); //Line(startX, startY, endX, endY)
    grid.add(headerLine,0,1,2,1); //add(itemName, column, row, columnspan, rowspan)
    Line columnLine = new Line(0, 0, 0, 720);
    grid.add(columnLine,1,1,1,5); //add(itemName, column, row, columnspan, rowspan)
    
    Label text3 = new Label("Choose an action:");
    grid.add(text3, 0, 2);
    TextField userTextField = new TextField();
    grid.add(userTextField, 1, 2);
    Label pw = new Label("text");
    grid.add(pw, 0, 4);
    PasswordField pwBox = new PasswordField();
    grid.add(pwBox, 1, 3);
    
    Button btnAction1 = new Button("Action1");
    HBox btn1 = new HBox(10);
    btn1.setAlignment(Pos.CENTER);
    btn1.getChildren().add(btnAction1);
    grid.add(btn1, 0, 3);
    


    Scene scene = new Scene(grid, 1280, 720);
    primaryStage.setScene(scene);
    
    primaryStage.show();
    }
}
