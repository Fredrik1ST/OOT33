/*
 * This class holds the Main function and the main menu of the GUI.
 * Based on the "show literature" page on Mockup.
 */
package ui.gui;

import entries.*;
import handling.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class ApplicationGUI extends Application {

    // Stages are windows
    Stage mainWindow;
    // Scenes hold the contents of a window
    Scene mainScene;
    // Panes arrange the visual layout of nodes
    BorderPane mainLayout;
    HBox bottomLayout;
    VBox topLayout, leftLayout, rightLayout, centerLayout;
    // Menus, like those at the very top of most programs
    MenuBar menuBar;
    Menu fileMenu, editMenu, viewMenu, helpMenu;
    MenuItem aboutItem;
    // List of literature presented to the user
    TableView<Entry> litDisplay;
    // TextField for taking search terms from the user
    TextField searchBar;
    // Labels are just text nodes to be put somewhere
    Label label;
    // Buttons are frickin' buttons
    Button btnAdd, btnRemove, btnViewInfo;
    // ComboBox is a simple scrolldown menu
    ComboBox<String> boxSelectType;

    AboutBox aboutBox = new AboutBox();
    AddBox addBox = new AddBox();
    LiteratureRegister litReg;
    ObservableList<Entry> litList;

// Main should only contain the launch method    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the register to hold all the literature, and the list to show in the table
        litReg = new LiteratureRegister();
        fillRegister();
        litList = FXCollections.observableArrayList(litReg.getAllLiterature());

        // Set up the main stage (mainWindow)
        mainWindow = primaryStage;
        mainWindow.setTitle("Library");

        // Layouts based on the "show literature" mainWindow in MockFlow
        mainLayout = new BorderPane(); // Pane holding everything in the menu
        leftLayout = new VBox();       // The vertical menu on the left
        centerLayout = new VBox();      // Contains the list (maybe not VBox?)
        topLayout = new VBox();        // Holds the search bar & return button
        bottomLayout = new HBox();     // Small runtime messages to the user

        // Set up menus
        fileMenu = new Menu("File");
        editMenu = new Menu("Edit");
        helpMenu = new Menu("Help");
        aboutItem = new MenuItem("About");
        menuBar = new MenuBar();
        helpMenu.getItems().addAll(aboutItem);
        aboutItem.setOnAction(e -> aboutBox.display());
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        // Set up the literature table (for the center layout)
        litDisplay = new TableView<Entry>();
        createTable();
        
        // Set up search bar and combobox used for sorting the table. 
        searchBar = new TextField();
        searchBar.setPromptText("Search for literature");
        searchBar.setMaxWidth(Double.MAX_VALUE);
        boxSelectType = new ComboBox<String>();
        boxSelectType.setPromptText("Select Type");
        boxSelectType.getItems().addAll(
                "All Literature",
                "Books",
                "Magazines",
                "Journals",
                "Newspapers",
                "Series");
        boxSelectType.getSelectionModel().selectFirst();
        enableSearch();

        // Set up the buttons
        btnAdd = new Button("Add literature");
        btnRemove = new Button("Remove literature");
        btnViewInfo = new Button("View info");
        btnAdd.setMaxWidth(Double.MAX_VALUE);
        btnRemove.setMaxWidth(Double.MAX_VALUE);
        btnViewInfo.setMaxWidth(Double.MAX_VALUE);
        boxSelectType.setMaxWidth(Double.MAX_VALUE);

        // Set up Action Events (like button presses)
        btnAdd.setOnAction(e -> {
            addBox.showChoiceDialog(litReg);
            updateObservableList();
            String type = boxSelectType.getValue();
            if (type.equals("All Literature")) {
                boxSelectType.getSelectionModel().selectLast();
            } else {
                boxSelectType.getSelectionModel().selectFirst();
            }
            boxSelectType.getSelectionModel().select(type);
        });
        btnRemove.setOnAction(e -> {
            removeEntry(litDisplay.getSelectionModel().getSelectedIndex());
            updateObservableList();
            String type = boxSelectType.getValue();
            if (type.equals("All Literature")) {
                boxSelectType.getSelectionModel().selectLast();
            } else {
                boxSelectType.getSelectionModel().selectFirst();
            }
            boxSelectType.getSelectionModel().select(type);
        });
        btnViewInfo.setOnAction(e -> {
            createInfoBox(litDisplay.getSelectionModel().getSelectedIndex());
        });

        // Configure the left menu's general scene (layout)
        leftLayout.getChildren().addAll(
                searchBar, boxSelectType, btnAdd, btnRemove, btnViewInfo);
        leftLayout.setSpacing(5);
        leftLayout.setPadding(new Insets(10, 10, 10, 10));
        // rightLayout.getChildren().add();
        topLayout.getChildren().add(menuBar);
        //topLayout.setPadding(new Insets(10,10,10,10));
        // bottomLayout.getChildren().add();
        centerLayout.getChildren().add(litDisplay);
        centerLayout.setPadding(new Insets(10, 10, 0, 0));

        mainLayout.setTop(topLayout);   
        mainLayout.setBottom(bottomLayout);
        mainLayout.setLeft(leftLayout);
        mainLayout.setRight(rightLayout);
        mainLayout.setCenter(centerLayout);

        mainScene = new Scene(mainLayout, 1080, 720);
        mainWindow.setScene(mainScene);
        mainWindow.setTitle("Library v1.0");
        mainWindow.show();
    }

    /**
     * Creates a table that displays the entries in the literature register
     */
    private void createTable() {

        litDisplay.setEditable(false);

        TableColumn litNameCol = new TableColumn("Title");
        litNameCol.setMinWidth(250);
        litNameCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("title"));

        TableColumn litPublCol = new TableColumn("Publisher");
        litPublCol.setMinWidth(150);
        litPublCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("publisher"));

        TableColumn litGenrCol = new TableColumn("Genre");
        litGenrCol.setMinWidth(150);
        litGenrCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("genre"));

        TableColumn litDateCol = new TableColumn("Release Date");
        litDateCol.setMinWidth(150);
        litDateCol.setCellValueFactory(new PropertyValueFactory<Literature, String>("release"));

        updateTable(litList);
        litDisplay.getColumns().addAll(litNameCol, litPublCol, litGenrCol,
                litDateCol);
    }
    
    /**
     * Updates the litDisplay table with the given ObservableList.
     * @param l the ObservableList used to update the table.
     */
    private void updateTable(ObservableList l) {
        litDisplay.setItems(l);
    }

    /**
     * Initialises the search bar and combo box used for sorting the entries on 
     * the table. 
     */
    private void enableSearch() {
        ObservableList<Entry> sortedList = FXCollections.observableArrayList(litList);
        boxSelectType.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String s1, String s2) {
                sortedList.clear();
                for (Entry e : litList) {
                    switch (s2) {
                        case "Books":
                                if (e instanceof Book) {
                                    sortedList.add(e);
                                }
                            break;
                        case "Magazines":

                                if (e instanceof Magazine) {
                                    sortedList.add(e);
                                }
                            break;
                        case "Journals":
                                if (e instanceof Journal) {
                                    sortedList.add(e);
                                }
                            break;
                        case "Newspapers":
                                if (e instanceof Newspaper) {
                                    sortedList.add(e);
                                }
                            break;
                        case "Series":
                                if (e instanceof Series) {
                                    sortedList.add(e);
                                }
                            break;
                        default:
                            sortedList.add(e);
                            break;
                    }
                }
            }
        });

        FilteredList<Entry> filteredList = new FilteredList(sortedList, p -> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(entry -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (entry.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Entry> searchResults = new SortedList<>(filteredList);
        searchResults.comparatorProperty().bind(litDisplay.comparatorProperty());
        updateTable(searchResults);

    }

    /**
     * Removes the selected entry from the literature register.
     *
     * @param selectedIndex index of the selected entry
     */
    private void removeEntry(int selectedIndex) {
        if (selectedIndex >= 0) {
            litReg.removeLiterature(
                    litDisplay.getSelectionModel().getSelectedItem());
            playAudio("rip.mp3");
        } else {
            // Nothing selected.
            showNoEntrySelectedError();
        }
    }

    /**
     * Opens another window that lists the values of the selected item.
     *
     * @param selectedIndex index of the selected item
     */
    private void createInfoBox(int selectedIndex) {
        if (selectedIndex >= 0) {
            InfoBox infoBox = new InfoBox(
                    litDisplay.getSelectionModel().getSelectedItem());
            infoBox.display();
        } else {
            // Nothing selected.
            showNoEntrySelectedError();
        }
    }

    /**
     * Fills register with various types of literature.
     */
    private void fillRegister() {
        litReg.addLiterature(new Book(
                "A book", "some book publisher", "a book genre", 1995, 11, 18, 0, "author", 1));
        litReg.addLiterature(new Magazine(
                "A magazine", "some mag publisher", "a mag genre", 1995, 11, 18, 1));
        litReg.addLiterature(new Magazine(
                "Another magazine", "another mag publisher", "another mag genre", 1995, 11, 18, 2));
        litReg.addLiterature(new Magazine(
                "A third magazine", "a third mag publisher", "a third mag genre", 1995, 11, 18, 3));
        Series series = new MagazineSeries(
                "A magazine series", "some mag series publisher", "a mag series genre", 3);
        series.add(new Magazine(
                "A mag series mag", "some mag series mag publisher", "a mag series mag genre", 1995, 11, 18, 1));
        litReg.addLiterature(series);
    }

    /**
     * Returns the literature register
     *
     * @return the literature register
     */
    protected LiteratureRegister getRegister() {
        return this.litReg;
    }

    /**
     * Updates the list that's displayed in the litDisplay table
     */
    private void updateObservableList() {
        litList.setAll(litReg.getAllLiterature());
    }

    /**
     * Displays an error because no item was selected.
     */
    private void showNoEntrySelectedError() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No entry Selected");
        alert.setContentText("Please select an entry in the table.");

        alert.showAndWait();
    }

    /**
     * Play a sound clip from the media package by entering its filename. Only
     * suitable for short clips!
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
                rip.play(60);
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
