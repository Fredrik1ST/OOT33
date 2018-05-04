package ui.gui;

import entries.*;
import handling.LiteratureRegister;
import java.io.File;
import java.net.URL;
import java.time.DateTimeException;
import java.util.NoSuchElementException;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Starts by letting the user choose a Literature type to add
 * through a choice dialog, then opens an appropriate form to fill out.
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
    public void showChoiceDialog(LiteratureRegister litReg) {
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>();
        choiceDialog.setHeaderText(null);
        choiceDialog.setContentText("Select literature type:");
        choiceDialog.getItems().addAll(
                "Book", "Magazine", "Journal", "Newspaper",
                "Book Series", "Magazine Series",
                "Journal Series", "Newspaper Series");
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

                case "Book Series":
                    add("Book Series", litReg);
                    break;

                case "Magazine Series":
                    add("Magazine Series", litReg);
                    break;

                case "Journal Series":
                    add("Journal Series", litReg);
                    break;

                case "Newspaper Series":
                    add("Newspaper Series", litReg);
                    break;
            }
        } catch (NoSuchElementException nope) {
            System.out.println("showChoiceDialog in AddBox is broken.");
        }

    }

    /**
     * Creates a form to accept input from the user.
     * Converts the user's input into a new piece of Literature.
     *
     * @param type Literature type to be added
     * @param litReg LiteratureRegister to be added to
     */
    private void add(String type, LiteratureRegister litReg) {

        // Initialize the window & layout
        Stage window = new Stage();
        VBox root = new VBox(10);
        VBox headerBox = new VBox(5);
        GridPane grid = new GridPane();
        HBox dateBox = new HBox(5);
        HBox btnBox = new HBox(30);
        Scene scene = new Scene(root);

        // Initialize labels
        Label promptLabel = new Label("Enter details: ");
        Label titleLabel = new Label("Title: ");
        Label publisherLabel = new Label("Publisher: ");
        Label genreLabel = new Label("Genre: ");
        Label authorLabel = new Label("Author: ");
        Label releaseNrLabel = new Label("Release #: ");
        Label dateLabel = new Label("Release date: ");
        Label editionLabel = new Label("Edition: ");
        Label releasesPerYearLabel = new Label("Releases per year: ");

        // Initialize TextFields (String)
        TextField titleField = new TextField();
        TextField publisherField = new TextField();
        TextField genreField = new TextField();
        TextField authorField = new TextField();
        TextField editionField = new TextField();
        // Initialzie TextFields (Int)
        TextField releaseNrField = new TextField();
        TextField dayField = new TextField();
        TextField monthField = new TextField();
        TextField yearField = new TextField();
        TextField releasesPerYearField = new TextField();

        // Initialize buttons
        Button addBtn = new Button("Add");
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(e -> window.close());

        // Set up TextFields
        titleField.setPromptText("Enter title");
        publisherField.setPromptText("Enter publisher");
        genreField.setPromptText("Enter genre");
        authorField.setPromptText("Enter author");
        editionField.setPromptText("Enter edition number");
        releaseNrField.setPromptText("Enter release number");
        dayField.setPromptText("Day");
        monthField.setPromptText("Month");
        yearField.setPromptText("Year");
        makeNumericTextFields(releaseNrField, editionField,
                dayField, monthField, yearField, releasesPerYearField);

        // Import graphics
        ImageView readerIconView = null;
        try {
            readerIconView = new ImageView(
                    new Image(getClass().getResourceAsStream("/media/reader.png")));
        } catch (NullPointerException npe) {
            System.out.println("You screwed up the icon!"
                    + "\nChange the ImageView-directory in AddBox.");
        }
        if (readerIconView != null) {
            promptLabel.setGraphic(readerIconView);
        }
        promptLabel.setFont(new Font("Arial", 50));
        promptLabel.setTextFill(Color.web("#383838"));

        // Set up common layout
        root.getChildren().addAll(headerBox, grid, btnBox);
        root.setPadding(new Insets(10, 10, 10, 10));
        headerBox.getChildren().addAll(promptLabel);
        headerBox.setAlignment(Pos.CENTER);
        dateBox.getChildren().addAll(dayField, monthField, yearField);
        btnBox.getChildren().addAll(addBtn, cancelBtn);
        btnBox.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        switch (type) {
            case "Book":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(authorLabel, 0, 3);
                GridPane.setConstraints(releaseNrLabel, 0, 4);
                GridPane.setConstraints(editionLabel, 0, 5);
                GridPane.setConstraints(dateLabel, 0, 6);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(authorField, 1, 3);
                GridPane.setConstraints(releaseNrField, 1, 4);
                GridPane.setConstraints(editionField, 1, 5);
                GridPane.setConstraints(dateBox, 1, 6);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releaseNrLabel, editionLabel, authorLabel,
                        dateLabel, titleField, publisherField, genreField,
                        authorField, releaseNrField, editionField, dateBox);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    boolean wasAdded = false;

                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final String author = authorField.getText();
                    final int releaseNr = Integer.parseInt(releaseNrField.getText());
                    final int day = Integer.parseInt(dayField.getText());
                    final int month = Integer.parseInt(monthField.getText());
                    final int year = Integer.parseInt(yearField.getText());
                    final int edition = Integer.parseInt(editionField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new Book(title, publisher, genre,
                            year, month, day, releaseNr, author, edition))) {
                        playAudio("pageflip.mp3");
                        wasAdded = true;

                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    if (wasAdded) {
                        window.close();
                    }
                });

                window.setScene(scene);
                window.showAndWait();
                break;

            case "Magazine":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(releaseNrLabel, 0, 3);
                GridPane.setConstraints(dateLabel, 0, 4);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(releaseNrField, 1, 3);
                GridPane.setConstraints(dateBox, 1, 4);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releaseNrLabel, dateLabel, titleField,
                        publisherField, genreField, releaseNrField, dateBox);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final int releaseNr = Integer.parseInt(releaseNrField.getText());
                    final int day = Integer.parseInt(dayField.getText());
                    final int month = Integer.parseInt(monthField.getText());
                    final int year = Integer.parseInt(yearField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new Magazine(title, publisher, genre,
                            year, month, day, releaseNr))) {
                        playAudio("pageflip.mp3");
                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    window.close();
                });

                window.setScene(scene);
                window.showAndWait();
                break;

            case "Journal":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(releaseNrLabel, 0, 3);
                GridPane.setConstraints(dateLabel, 0, 4);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(releaseNrField, 1, 3);
                GridPane.setConstraints(dateBox, 1, 4);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releaseNrLabel, dateLabel, titleField,
                        publisherField, genreField, releaseNrField, dateBox);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final int releaseNr = Integer.parseInt(releaseNrField.getText());
                    final int day = Integer.parseInt(dayField.getText());
                    final int month = Integer.parseInt(monthField.getText());
                    final int year = Integer.parseInt(yearField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new Journal(title, publisher, genre,
                            year, month, day, releaseNr))) {
                        playAudio("pageflip.mp3");
                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    window.close();
                });

                window.setScene(scene);
                window.showAndWait();
                break;

            case "Newspaper":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(releaseNrLabel, 0, 3);
                GridPane.setConstraints(dateLabel, 0, 4);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(releaseNrField, 1, 3);
                GridPane.setConstraints(dateBox, 1, 4);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releaseNrLabel, dateLabel, titleField,
                        publisherField, genreField, releaseNrField, dateBox);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final int releaseNr = Integer.parseInt(releaseNrField.getText());
                    final int day = Integer.parseInt(dayField.getText());
                    final int month = Integer.parseInt(monthField.getText());
                    final int year = Integer.parseInt(yearField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new Newspaper(title, publisher,
                            genre, year, month, day, releaseNr))) {
                        playAudio("pageflip.mp3");
                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    window.close();
                });

                window.setScene(scene);
                window.showAndWait();
                break;

            case "Book Series":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(releasesPerYearLabel, 0, 3);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(releasesPerYearField, 1, 3);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releasesPerYearLabel, titleField,
                        publisherField, genreField, releasesPerYearField);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final int releasesPerYear = Integer.parseInt(releasesPerYearField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new BookSeries(title, publisher,
                            genre, releasesPerYear))) {
                        playAudio("pageflip.mp3");
                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    window.close();
                });

                window.setScene(scene);
                window.showAndWait();
                break;
                
                case "Magazine Series":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(releasesPerYearLabel, 0, 3);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(releasesPerYearField, 1, 3);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releasesPerYearLabel, titleField,
                        publisherField, genreField, releasesPerYearField);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final int releasesPerYear = Integer.parseInt(releasesPerYearField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new MagazineSeries(title, publisher,
                            genre, releasesPerYear))) {
                        playAudio("pageflip.mp3");
                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    window.close();
                });

                window.setScene(scene);
                window.showAndWait();
                break;
                
                case "Journal Series":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(releasesPerYearLabel, 0, 3);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(releasesPerYearField, 1, 3);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releasesPerYearLabel, titleField,
                        publisherField, genreField, releasesPerYearField);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final int releasesPerYear = Integer.parseInt(releasesPerYearField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new JournalSeries(title, publisher,
                            genre, releasesPerYear))) {
                        playAudio("pageflip.mp3");
                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    window.close();
                });

                window.setScene(scene);
                window.showAndWait();
                break;
                
                case "Newspaper Series":
                System.out.println(type.toUpperCase() + "-MAKING TIME!");

                // Left side of window (text)
                GridPane.setConstraints(titleLabel, 0, 0);
                GridPane.setConstraints(publisherLabel, 0, 1);
                GridPane.setConstraints(genreLabel, 0, 2);
                GridPane.setConstraints(releasesPerYearLabel, 0, 3);

                // Right side of window (input fields)
                GridPane.setConstraints(titleField, 1, 0);
                GridPane.setConstraints(publisherField, 1, 1);
                GridPane.setConstraints(genreField, 1, 2);
                GridPane.setConstraints(releasesPerYearField, 1, 3);

                // Add to grid
                grid.getChildren().addAll(titleLabel, publisherLabel,
                        genreLabel, releasesPerYearLabel, titleField,
                        publisherField, genreField, releasesPerYearField);

                // Make the button crunch the numbers
                addBtn.setOnAction(e -> {
                    final String title = titleField.getText();
                    final String publisher = publisherField.getText();
                    final String genre = genreField.getText();
                    final int releasesPerYear = Integer.parseInt(releasesPerYearField.getText());

                    // Add the literature (or don't) and give some feedback
                    if (litReg.addLiterature(new NewspaperSeries(title, publisher,
                            genre, releasesPerYear))) {
                        playAudio("pageflip.mp3");
                    } else {
                        playAudio("bulbhorn.mp3");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Duplicate Error");
                        alert.setContentText(title + " already exists.");
                        alert.showAndWait();
                    }
                    window.close();
                });

                window.setScene(scene);
                window.showAndWait();
                break;
        }

    }

    /**
     * Changes TextFields so that they only accept numerical input.
     *
     * @param fields The TextFields to change
     */
    private void makeNumericTextFields(TextField... fields) {
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

    /**
     * Play a sound clip from the media package by entering its filename.
     * Only suitable for short clips!
     *
     * @param soundName audio file to play
     */
    private void playAudio(String audioClip) {
        switch (audioClip) {
            case "pageflip.mp3":
                AudioClip pageflip = new AudioClip(this.getClass().getResource(
                        "/media/" + audioClip).toString());
                pageflip.play();
                break;

            case "rip.mp3":
                AudioClip rip = new AudioClip(this.getClass().getResource(
                        "/media/" + audioClip).toString());
                rip.play();
                break;

            case "bulbhorn.mp3":
                AudioClip bulbhorn = new AudioClip(this.getClass().getResource(
                        "/media/" + audioClip).toString());
                bulbhorn.play();
                break;
            default:
                break;
        }
    }

}
