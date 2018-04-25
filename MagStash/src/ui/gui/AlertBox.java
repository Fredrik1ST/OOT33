/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Fredrik
 */
public class AlertBox extends Application{
    
    Stage window1, window2;
    Scene scene1, scene2;
    Label label1, label2;
    Button button1, button2;
    
    public static void display(String title, String message) {
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL); // Prevents the user from interacting with other windows while active.
    window.setTitle(title); // Title of the window
    window.setHeight(100);
    window.setWidth(250);
    
    Label label = new Label(message); // Error message displayed
    Button closeButton = new Button("OH NO!!!");
    closeButton.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, closeButton);
    layout.setAlignment(Pos.CENTER); // Centers the window
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
    
    
}

    @Override
    public void start(Stage primaryStage) throws Exception {
        window1 = primaryStage;
        
        button1 = new Button("Cool button");
        button1.setOnAction(e -> System.out.println("Cool, eh?")); // A cool lambda

       StackPane layout1 = new StackPane();
       layout1.getChildren().addAll(button1);
       
       Scene scene1 = new Scene(layout1, 400, 400);
       
    }
}
