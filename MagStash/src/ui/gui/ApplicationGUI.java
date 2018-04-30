/*
 * This class holds the Main function and the main menu of the GUI.
 * Based on the "show literature" page on Mockup.
 */
package ui.gui;

import entries.*;
import handling.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApplicationGUI extends Application {

    // Stages are windows
    Stage mainWindow;
    // Scenes hold the contents of a window
    Scene mainScene;
    // Panes arrange the visual layout of nodes
    BorderPane mainLayout;
    HBox topLayout, bottomLayout;
    VBox leftLayout, rightLayout, centerLayout;
    // List of literature presented to the user
    TableView<Entry> litDisplay;
    // TextField for taking search terms from the user
    TextField searchBar;
    // Labels are just text nodes to be put somewhere
    Label label;
    // Buttons are frickin' buttons
    Button btnAdd, btnRemove, btnTest;
    // ComboBox is a simple scrolldown menu
    ComboBox<String> boxSelectType;
    // Toolbars are (usually) just rows of buttons
    ToolBar leftToolBar;

// Main should only contain the launch method    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set up the main stage (mainWindow)
        mainWindow = primaryStage;
        mainWindow.setTitle("Library");

        // Layouts based on the "show literature" mainWindow in MockFlow
        mainLayout = new BorderPane(); // Pane holding everything in the menu
        leftLayout = new VBox();       // The vertical menu on the left
        centerLayout = new VBox();      // Contains the list (maybe not VBox?)
        topLayout = new HBox();        // Holds the search bar & return button
        bottomLayout = new HBox();     // Small runtime messages to the user

        // Set up search bar and return(?) button (for the top layout)
        searchBar = new TextField();
        searchBar.setPromptText("Search for literature");

        // Set up the literature table (for the center layout)
        litDisplay = new TableView<Entry>();
        createTable();

        // Set up buttons and toolbar (for the left layout)
        btnAdd = new Button("Add");
        btnRemove = new Button("Remove");
        btnTest = new Button("ｆｒｅｅ　ｃａｎｄｙ");
        boxSelectType = new ComboBox<String>();
        leftToolBar = new ToolBar(boxSelectType, btnAdd, btnRemove, btnTest);
        leftToolBar.setOrientation(Orientation.VERTICAL);
        btnAdd.setOnAction(e -> System.out.println(
                "UNFINISHED. SHOULD ADD LITERATURE."));
        btnRemove.setOnAction(e -> System.out.println(
                "UNFINISHED. SHOULD REMOVE LITERATURE"));
        btnTest.setOnAction(
                e -> ui.gui.AlertBox.display("HAHA!", "GOTCHA!!"));
        boxSelectType.setPromptText("Select Type");
        boxSelectType.getItems().addAll(
                "All Literature",
                "Books",
                "Magazines",
                "Journals",
                "Newspapers");

        // Configure the menu's general scene (layout)
        leftLayout.getChildren().addAll(
                boxSelectType, btnAdd, btnRemove, btnTest);
        leftLayout.setSpacing(5);
        leftLayout.setPadding(new Insets(0,10,10,10));
        // rightLayout.getChildren().add();
        topLayout.getChildren().add(searchBar);
        topLayout.setPadding(new Insets(10,10,10,10));
        // bottomLayout.getChildren().add();
        centerLayout.getChildren().add(litDisplay);
        centerLayout.setPadding(new Insets(0,10,0,0));

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
    
    private void createTable() {
        
        litDisplay.setEditable(false);
        
        TableColumn litNameCol = new TableColumn("Literature Name");
        litNameCol.setMinWidth(250);
        litNameCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("title"));
        
        TableColumn litPublCol = new TableColumn("Publisher");
        litPublCol.setMinWidth(150);
        litPublCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("publisher"));
        
        TableColumn litGenrCol = new TableColumn("Genre"); 
        litGenrCol.setMinWidth(100);
        litGenrCol.setCellValueFactory(new PropertyValueFactory<Entry, String> ("genre")); 
        
        TableColumn litDateCol = new TableColumn("Release Date");
        litDateCol.setMinWidth(100);
        //litDateCol.setCellValueFactory(new PropertyValueFactory<Literature, >("litDate"));
        
        //litDisplay.setItems(litRegister); TODO: legg til literaturregister i klassen og ordne med det
        litDisplay.getColumns().addAll(litNameCol, litPublCol, litGenrCol, 
                litDateCol);
    }
}
