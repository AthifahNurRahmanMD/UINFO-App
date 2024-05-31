package UINFO.Pages;

import UINFO.Utils.SceneInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PtSession implements SceneInterface  {
    private Stage stage;

    //konstruktor PtSession
    public PtSession(Stage stage){
        this.stage = stage;
    }

    // Pendeklarasian Method Show
    public void show(){
        Label ptIdn = new Label("Perguruan Tinggi di Indonesia");
        ptIdn.getStyleClass().add("label-ptIdn");

        Button ptNButton = new Button(" Perguruan Tinggi Negeri");
        ptNButton.getStyleClass().add("button-ptnButton");
        ptNButton.setPrefWidth(225);
        ptNButton.setPrefHeight(50);
        ptNButton.setOnAction(e -> {
            // Logika untuk tombol "Perguruan Tinggi Negri"
            PtnButton ptnButtonScene = new PtnButton(stage);
            ptnButtonScene.show();
        });

        Button ptSButton = new Button(" Perguruan Tinggi Swasta");
        ptSButton.getStyleClass().add("button-ptsButton");
        ptSButton.setPrefWidth(225);
        ptSButton.setPrefHeight(50);
        ptSButton.setOnAction(e -> {
            // Logika untuk tombol "Perguruan Tinggi Swasta"
            PtsButton ptsButtonScene = new PtsButton(stage);
            ptsButtonScene.show();
        });

        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("button-backbutton");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            Home homie =  new Home(stage);
            homie.show();
        });

        VBox vboxA = new VBox(ptIdn);
        vboxA.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(35);
        vbox.getChildren().addAll(ptNButton, ptSButton, backButton);

        VBox root = new VBox(vboxA, vbox);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(80);

        Image image = new Image("Images/newPtSessionbg.png");
        BackgroundImage  backgroundImage =  new BackgroundImage(
            image, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
            new BackgroundSize(1, 1, true, true, false, false));
        root.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}