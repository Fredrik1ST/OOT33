/*
 * Throw this guy a LiteratureRegister and he'll take the user through
 * the process of adding entries to it. With windows & other cool stuff.
 */
package ui.gui;

import handling.LiteratureRegister;
import java.util.NoSuchElementException;
import java.util.Optional;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Fredrik
 */
public class AddBox {

    /**
     * Asks what type of literature the user wants to add
     * before creating appropriate forms to fill out.
     *
     * @param litReg LiteratureRegister to be added to
     */
    public static void showChoiceDialog(LiteratureRegister litReg) {
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>();
        choiceDialog.setHeaderText(null);
        choiceDialog.setContentText("Select literature type:");
        choiceDialog.getItems().addAll(
                "Book", "Magazine", "Journal", "Newspaper");
        Optional<String> choice = choiceDialog.showAndWait();

        try {
            switch (choice.get()) {
                case "Book":
                    add("Book", litReg);
                    break;

                case "Magazine":
                    add("Magazine", litReg);
                    break;

                case "Journal":
                    add("Journal", litReg);
                    break;

                case "Newspaper":
                    add("Newspaper", litReg);
                    break;
            }
        } catch (NoSuchElementException nope) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("No such element Exception");
            alert.setContentText("Something went really wrong "
                    + "deep down in the code. You should contact us.");
        }

    }

    /**
     * Chews the user's input and spits it out as a new piece of Literature.
     *
     * @param type Literature type to be added
     * @param litReg LiteratureRegister to be added to
     */
    private static void add(String type, LiteratureRegister litReg) {
        Stage window = new Stage();
        VBox root = new VBox();
        GridPane grid = new GridPane();
        Scene scene = new Scene(root);

        // Create labels
        Label promptLabel = new Label("Enter details: ");
        Label titleLabel = new Label("Title: ");
        Label publisherLabel = new Label("Publisher: ");
        Label genreLabel = new Label("Genre: ");
        Label authorLabel = new Label("Author: ");
        Label releaseNrLabel = new Label("Release #: ");
        Label dateLabel = new Label("Release date: ");

        // Initialize TextFields
        TextField titleField = new TextField();
        TextField publisherField = new TextField();
        TextField genreField = new TextField();
        TextField authorField = new TextField();
        TextField releaseNrField = new TextField();
        TextField dayField = new TextField();
        TextField monthField = new TextField();
        TextField yearField = new TextField();

        // Set up numeric TextFields
        dayField.setPromptText("Day");
        monthField.setPromptText("Month");
        yearField.setPromptText("Year");
        makeNumericTextFields(dayField, monthField, yearField);
        
        Button addBtn = new Button("Add");
        Button cancelBtn = new Button("Cancel");

        switch (type) {
            case "Book":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");
                root.getChildren().addAll(promptLabel, grid);
                break;

            case "Magazine":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");
                break;

            case "Journal":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");
                break;

            case "Newspaper":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");
                break;
        }

    }

    /**
     * WORK IN PROGRESS!
     * Changes TextFields so that they only accept numerical input.
     *
     * @param fields The TextFields to change
     */
    private static void makeNumericTextFields(TextField... fields) {
        for (TextField textField : fields) {
            textField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                        String newValue) {
                    if (!newValue.matches("\\d*")) {
                        textField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        }
    }
    
}
