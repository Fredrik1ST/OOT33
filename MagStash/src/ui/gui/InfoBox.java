/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import entries.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author HC Finnson
 */
public class InfoBox {

    Entry selectedEntry;

    public InfoBox(Entry selectedEntry) {
        this.selectedEntry = selectedEntry;
    }

    /**
     * Creates a new window that display the information of the given entry
     */
    public void display() {
        int n = 0;

        Stage infoWindow = new Stage();
        infoWindow.setTitle(selectedEntry.getTitle());

        GridPane infoLayout = new GridPane();
        infoLayout.setAlignment(Pos.CENTER);
        infoLayout.setHgap(10);
        infoLayout.setVgap(10);

        infoLayout.add(new Text("Type: "), 0, n);
        if (selectedEntry instanceof Book) {
            infoLayout.add(new Text("Book"), 1, n);
        } else if (selectedEntry instanceof Magazine) {
            infoLayout.add(new Text("Magazine"), 1, n);
        } else if (selectedEntry instanceof Newspaper) {
            infoLayout.add(new Text("Newspaper"), 1, n);
        } else if (selectedEntry instanceof Journal) {
            infoLayout.add(new Text("Journal"), 1, n);
        } else if (selectedEntry instanceof BookSeries) {
            infoLayout.add(new Text("Book series"), 1, n);
        } else if (selectedEntry instanceof MagazineSeries) {
            infoLayout.add(new Text("Magazine series"), 1, n);
        } else if (selectedEntry instanceof NewspaperSeries) {
            infoLayout.add(new Text("Newspaper series"), 1, n);
        } else if (selectedEntry instanceof JournalSeries) {
            infoLayout.add(new Text("Journal series"), 1, n);
        } else {
            infoLayout.add(new Text("Error, no recognized type"), 1, n);
        }
        n++;

        infoLayout.add(new Text("Title: "), 0, n);
        infoLayout.add(new Text(selectedEntry.getTitle()), 1, n);
        n++;

        if (selectedEntry instanceof Literature) {
            infoLayout.add(new Text("Number: "), 0, n);
            infoLayout.add(new Text(
                    ("" + ((Literature) selectedEntry).getReleaseNr())), 1, n);
            n++;
        }
        
        //if (selectedEntry instanceof Book) {
        //    infoLayout.add(new Text("Author: "), 0, n);
        //    infoLayout.add(new Text(selectedEntry.getAuthor()), 1, n);
        //}

        infoLayout.add(new Text("Publisher: "), 0, n);
        infoLayout.add(new Text(selectedEntry.getPublisher()), 1, n);
        n++;

        infoLayout.add(new Text("Genre: "), 0, n);
        infoLayout.add(new Text(selectedEntry.getGenre()), 1, n);
        n++;

        if (selectedEntry instanceof Literature) {
            infoLayout.add(new Text("Release date: "), 0, n);
            infoLayout.add(new Text(((Literature) selectedEntry).getYear()
                    + "/" + ((Literature) selectedEntry).getMonth()
                    + "/" + ((Literature) selectedEntry).getDay()), 1, n);
            n++;
        }

        if (selectedEntry instanceof Series) {
            infoLayout.add(new Text("Releases per year: "), 0, n);
            infoLayout.add(new Text(
                    "" + ((Series) selectedEntry).getReleasesPerYear()), 1, n);
            n++;
            
            infoLayout.add(new Text("Total releases: "), 0, n);
            infoLayout.add(new Text("" + ((Series) selectedEntry).getSize()), 1, n);
            n++;
        }
        
        if (selectedEntry instanceof Series) {
            ObservableList litList = FXCollections.observableArrayList(
                    ((Series) selectedEntry).getMap().values());
            TableView seriesTable = new TableView();
            seriesTable.setEditable(false);
            
            TableColumn litNameCol = new TableColumn("Title");
            litNameCol.setMinWidth(120);
            litNameCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("title"));
            
            TableColumn litPublCol = new TableColumn("Publisher");
            litPublCol.setMinWidth(120);
            litPublCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("publisher"));

            TableColumn litGenrCol = new TableColumn("Genre"); 
            litGenrCol.setMinWidth(120);
            litGenrCol.setCellValueFactory(new PropertyValueFactory<Entry, String> ("genre"));
            
            seriesTable.setItems(litList);
            seriesTable.getColumns().addAll(litNameCol, litPublCol, litGenrCol);
            infoLayout.add((seriesTable),0,n,2,1);
            n++;
        }

        Scene infoScene = new Scene(infoLayout, 480, 360);
        infoWindow.setScene(infoScene);
        infoWindow.showAndWait();
    }
}
