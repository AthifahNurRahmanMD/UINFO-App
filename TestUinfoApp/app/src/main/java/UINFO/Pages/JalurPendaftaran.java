package UINFO.Pages;

import UINFO.Models.Kampus;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JalurPendaftaran {
    private Stage stage;
    private Kampus kampus;
    public JalurPendaftaran(Stage stage, Kampus kampus) {
        this.stage = stage;
        this.kampus = kampus;
    }

    public void show() {
        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            if (kampus.getStatus().equals("")){
                PTNSDetail ptsScene =  new PTNSDetail(stage, kampus);
                ptsScene.show();
            } else{
                PTNSDetail ptnScene =  new PTNSDetail(stage, kampus);
                ptnScene.show();
            }
        });


        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/detailcampusbg.png"));

        // Membuat objek BackgroundImage untuk latar belakang
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(backButton, new Insets(400, 550, 15, 0));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll(backButton);

        Scene scene = new Scene( stackPane, 800, 500);      
        scene.getStylesheets().add(getClass().getResource("/CssStyle/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}