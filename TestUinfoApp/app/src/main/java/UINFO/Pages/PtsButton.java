package UINFO.Pages;

import UINFO.Models.Kampus;
import UINFO.Utils.SceneInterface;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PtsButton implements SceneInterface{
    //Encapsulation stage
    private Stage stage;

    //Membuat Constructor
    public PtsButton(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        //headline PTN
        Label hlpts =  new Label("Perguruan Tinggi Swasta");
        hlpts.getStyleClass().add("label-hlpts");

        Button btnUmi =  new Button("       UNIVERSITAS\nMUSLIM INDONESIA ");
        btnUmi.getStyleClass().add("button-buttonTwouniv");
        btnUmi.setOnAction(e -> {
            Kampus umiKampus = new Kampus(0, "Universitas Muslim Indonesia", "Jl. Urip Sumuharjo KM.5\nMakassar, Sulawesi Selatan 90231. ","Swasta");
            PTNSDetail ptsDetailUMI = new PTNSDetail(stage, umiKampus);
            ptsDetailUMI.show();
        });


        Button btnUNIBOS =  new Button("UNIVERSITAS BOSOWA");
        btnUNIBOS.getStyleClass().add("button-buttonTwouniv");
        btnUNIBOS.setOnAction(e -> {
            Kampus unibosKampus = new Kampus(0, "Universitas Bosowa ", "Jl. Urip Sumoharjo KM.4\nMakassar, Sulawesi Selatan, 90231","Swasta");
            PTNSDetail ptsDetailUNIBOS = new PTNSDetail(stage,unibosKampus);
            ptsDetailUNIBOS.show();
       });

        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("button-backbutton");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            PtSession ptsession =  new PtSession(stage);
            ptsession.show();
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/newptsdesain.png"));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(hlpts,new Insets(20, 15, 400, 0));
        StackPane.setMargin(btnUmi, new Insets(50,305,203,20) );
        StackPane.setMargin(btnUNIBOS, new Insets(50,20,203,310) );      
        StackPane.setMargin(backButton, new Insets(400, 550, 15, 0));
        stackPane.getChildren().addAll( hlpts, btnUmi, btnUNIBOS, backButton);

        // Membuat objek BackgroundImage untuk latar belakang
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.setBackground(new Background(backgroundImg));


        Scene scene = new Scene(stackPane, 800, 500);      
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}