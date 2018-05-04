package ui.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * The best box ever.
 * An easter egg to test media playing.
 */
public class FunBox {

    Stage window;
    Scene scene;
    Label msgLabel, gifLabel;
    Button closeButton;

    public void display(String title, String message) {
        window = new Stage();
        window.setTitle(title); // Title of the window


        Media media = new Media(FunBox.class.getResource("/media/trumpet.mp3").toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();

        // Import graphic
        ImageView dootGif = null;
        try {
            dootGif = new ImageView(
                    new Image(getClass().getResourceAsStream("/media/doot.gif")));
            gifLabel.setGraphic(dootGif);
        } catch (NullPointerException npe) {
            System.out.println("You dun goofd!");
        }
        

        msgLabel = new Label(message); // Error message displayed
        closeButton = new Button("Thank You Mr Skeltal!!!");
        closeButton.setOnAction(e -> {
            player.stop();
            window.close();
                });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(msgLabel, dootGif, closeButton);
        layout.setAlignment(Pos.CENTER); // Centers the window

        scene = new Scene(layout);
        window.setOnCloseRequest(e -> player.stop());
        window.setScene(scene);
        window.showAndWait();

    }
}
