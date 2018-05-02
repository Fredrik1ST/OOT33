/*
 * Throw this guy a LiteratureRegister and he'll take the user through
 * the process of adding entries to it. With windows & other cool stuff.
 */
package ui.gui;

import handling.LiteratureRegister;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Fredrik
 */
public class AddBox extends Application {

    public static void showChoiceDialog(LiteratureRegister litReg) {
        Stage window = new Stage();
        
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>();
        choiceDialog.setHeaderText("Add literature");
        choiceDialog.setContentText("Select literature type:");
        choiceDialog.getItems().addAll(
                "Book", "Magazine", "Journal", "Newspaper");
        choiceDialog.show();

        window.initModality(Modality.APPLICATION_MODAL); // Prevents the user from interacting with other windows while active.
        window.setTitle("Add literature"); // Title of the window
        window.setHeight(100);
        window.setWidth(250);

        Label label = new Label("Enter details:"); // Error message displayed
        Button closeButton = new Button("Add");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER); // Centers the window

        Scene scene = new Scene(layout);
        window.setScene(scene);
        //window.showAndWait();

    }
    
    private void addBook(LiteratureRegister litReg) {
        
    }
    
    private void addMagazine(LiteratureRegister litReg) {
        
    }
    
    private void addJournal(LiteratureRegister litReg) {
        
    }
    
    private void addNewspaper(LiteratureRegister litReg) {
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
}
