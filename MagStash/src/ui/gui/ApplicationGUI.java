/*
 * This class holds the Main function and the main menu of the GUI.
 * Based on the "show literature" page on Mockup.
 */
package ui.gui;

import entries.*;
import handling.*;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
    HBox bottomLayout;
    VBox topLayout, leftLayout, rightLayout, centerLayout;
    // Menus, like those at the very top of most programs
    MenuBar menuBar;
    Menu fileMenu, editMenu, viewMenu, helpMenu;
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
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        
        // Set up search bar and return(?) button (for the top layout)
        searchBar = new TextField();
        searchBar.setPromptText("Search for literature");
        searchBar.setMaxWidth(Double.MAX_VALUE);

        // Set up the literature table (for the center layout)
        litDisplay = new TableView<Entry>();
        createTable();

        // Set up the buttons
        btnAdd = new Button("Add literature");
        btnRemove = new Button("Remove literature");
        btnTest = new Button("ｆｒｅｅ　ｃａｎｄｙ");
        boxSelectType = new ComboBox<String>();
        leftToolBar = new ToolBar(boxSelectType, btnAdd, btnRemove, btnTest);
        leftToolBar.setOrientation(Orientation.VERTICAL);
        btnAdd.setOnAction(e -> ui.gui.AddBox.showChoiceDialog(litReg));
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                removeEntry(litDisplay.getSelectionModel().getSelectedIndex());
            }
        });
        btnTest.setOnAction(
                e -> ui.gui.AlertBox.display("HAHA!", "GOTCHA!!"));
        boxSelectType.setPromptText("Select Type");
        boxSelectType.getItems().addAll(
                "All Literature",
                "Books",
                "Magazines",
                "Journals",
                "Newspapers");
        btnAdd.setMaxWidth(Double.MAX_VALUE);
        btnRemove.setMaxWidth(Double.MAX_VALUE);
        btnTest.setMaxWidth(Double.MAX_VALUE);
        boxSelectType.setMaxWidth(Double.MAX_VALUE);
        
        // Configure the left menu's general scene (layout)
        leftLayout.getChildren().addAll(
                searchBar, boxSelectType, btnAdd, btnRemove, btnTest);
        leftLayout.setSpacing(5);
        leftLayout.setPadding(new Insets(10,10,10,10));
        // rightLayout.getChildren().add();
        topLayout.getChildren().add(menuBar);
        //topLayout.setPadding(new Insets(10,10,10,10));
        // bottomLayout.getChildren().add();
        centerLayout.getChildren().add(litDisplay);
        centerLayout.setPadding(new Insets(10,10,0,0));

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
        
        litDisplay.setItems(litList);
        litDisplay.getColumns().addAll(litNameCol, litPublCol, litGenrCol, 
                litDateCol);
    }
    
    private void removeEntry(int selectedIndex) {
        if (selectedIndex >= 0) {
            litReg.removeLiterature(litDisplay.getSelectionModel().getSelectedItem());
            litDisplay.getItems().remove(selectedIndex);
        }
        else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No entry Selected");
            alert.setContentText("Please select an entry in the table.");

            alert.showAndWait();
        }
            
    }
    
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
    
    protected LiteratureRegister getRegister() {
        return this.litReg;
    }
}
