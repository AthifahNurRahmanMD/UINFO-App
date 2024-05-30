package UINFO.Pages;

import UINFO.Models.Kampus;
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

public class PtnButton {
    //Encapsulation stage
    private Stage stage;

    //Membuat Constructor
    public PtnButton(Stage stage) {
        this.stage = stage;
    }
    public void show() {
        //headline PTN
        Label hlPtn =  new Label("Perguruan Tinggi Negeri");
        hlPtn.getStyleClass().add("label-hlptn");

        Button btnUnhas =  new Button(" UNIVERSITAS \nHASANUDDIN ");
        btnUnhas.getStyleClass().add("button-buttonTriuniv");
        btnUnhas.setOnAction(e -> {
            Kampus uhKampus = new Kampus(0, "Universitas Hasanuddin", "Jl.Perintis Kemerdekaan KM10\nMakassar,90245,Sulawesi Selatan, Indonesia.","PTN-BH");
            PTNSDetail ptnDetailUNHAS = new PTNSDetail(stage, uhKampus);
            ptnDetailUNHAS.show();
        });


        Button btnUnm =  new Button("     UNIVERSITAS\nNEGERI MAKASSAR");
        btnUnm.getStyleClass().add("button-buttonTriuniv");
        btnUnm.setOnAction(e -> {
            Kampus unmKampus = new Kampus(0, "Universitas Negeri Makassar", "Jl. A.P. Pettarani Makassar,902222\nSulawesi Selatan, Indonesia.","PTN-NONBH");
            PTNSDetail ptnDetailUNM = new PTNSDetail(stage,unmKampus);
            ptnDetailUNM.show();
       });

        Button btnUgm =  new Button("  UNIVERSITAS\n GADJAH  MADA");
        btnUgm.getStyleClass().add("button-buttonTriuniv");
        btnUgm.setOnAction(e -> {
            Kampus ugmKampus = new Kampus(0, "Universitas Gadjah Mada", "Bulaksumur, Caturtunggal, Kapanewon Depok\nKab.Sleman Daerah Istimewa Yogyakarta, 55281","PTN-BH");
            PTNSDetail ptnDetailUGM = new PTNSDetail(stage, ugmKampus);
            ptnDetailUGM.show();
       });

        Button backButton = new Button("Kembali");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            PtSession ptsession =  new PtSession(stage);
            ptsession.show();
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/newptndesain.png"));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(hlPtn,new Insets(20, 15, 395, 10));
        StackPane.setMargin(btnUnhas, new Insets(50,380,203,20) );
        StackPane.setMargin(btnUnm, new Insets(50,160,203,153) );
        StackPane.setMargin(btnUgm, new Insets(50,0,203,350) );       
        StackPane.setMargin(backButton, new Insets(400, 550, 15, 0));
        stackPane.getChildren().addAll( hlPtn, btnUnhas, btnUnm, btnUgm, backButton);

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