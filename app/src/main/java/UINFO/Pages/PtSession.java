package UINFO.Pages;

import UINFO.Utils.SceneInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
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
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(50);
        vbox.setLayoutX(301);
        vbox.setLayoutY(250);

        Button ptNButton = createTransparentButton(" Perguruan Tinggi Negri");
        ptNButton.setStyle("-fx-text-fill: black;");
        ptNButton.setPrefWidth(200);
        ptNButton.setPrefHeight(50);
        ptNButton.setOnAction(e -> {
            // Logika untuk tombol "Perguruan Tinggi Negri"
            PtnButton ptnButtonScene = new PtnButton(null);
            ptnButtonScene.show();
        });
        
        Button ptSButton = createTransparentButton(" Perguruan Tinggi Negri");
        ptSButton.setStyle("-fx-text-fill: black;");
        ptSButton.setPrefWidth(200);
        ptSButton.setPrefHeight(50);
        ptSButton.setOnAction(e -> {
            // Logika untuk tombol "Perguruan Tinggi Negri"
            PtsButton ptsButtonScene = new PtsButton(stage);
            ptsButtonScene.show();
        });
        
        Button backButton = new Button("back");
        backButton.setOnAction(e -> {
            Home homie =  new Home(stage);
            homie.show();
        });


        vbox.getChildren().addAll(ptNButton,ptSButton, backButton);
       
        Pane root = new Pane();
        root.getChildren().addAll(vbox);
        root.setPrefSize(800, 600);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }


    private Button createTransparentButton(String buttonText) {
        Button button = new Button(buttonText);
        // button.setStyle("-fx-background-color: transparent;");
        return button;
    }
}
