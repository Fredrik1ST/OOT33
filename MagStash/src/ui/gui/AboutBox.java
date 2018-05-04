/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Fredrik
 */
public class AboutBox {
    
    public void display() {
        
        String copyright = "Sound effects © SoundJay.com"
        + "\nIcons © flaticon on freepik.com";
        
        // Import graphic
        ImageView readerIconView = null;
        try {
            readerIconView = new ImageView(
                    new Image(getClass().getResourceAsStream("/media/reader.png")));
        } catch (NullPointerException npe) {
            System.out.println("You screwed up the icon in the AboutBox!");
        }
        
        // Set up and display the information box
        Alert aboutBox = new Alert(AlertType.INFORMATION);
        aboutBox.setGraphic(readerIconView);
        aboutBox.setTitle("About");
        aboutBox.setHeaderText("A program by OOP team 33");
        aboutBox.setContentText(copyright);
        aboutBox.show();
    }
}
