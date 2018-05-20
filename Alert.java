package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Alert {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setResizable(false);

        //Label label = new Label();
        //label.setText(message);
        Button closeButton = new Button(message);
        closeButton.setMinSize(350, 100);
        closeButton.setStyle("-fx-font-size: 24");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(25);
        layout.getChildren().addAll(closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}