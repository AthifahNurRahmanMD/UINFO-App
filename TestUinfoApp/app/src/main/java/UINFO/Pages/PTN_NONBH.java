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

public class PTN_NONBH {
    private Stage stage;
    private Kampus kampus;

    public PTN_NONBH(Stage stage, Kampus kampus) {
        this.stage = stage;
        this.kampus = kampus;
    }

    public void show(){
        Label ptnNonBH = new Label ("PTN-NONBH");
        ptnNonBH.getStyleClass().add("label-ptnstatushl");
    

        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("button-backbutton");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
                PTNSDetail ptnScene = new PTNSDetail(stage, kampus);
                ptnScene.show();
            });
        
        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/newptnStatusbg.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(ptnNonBH, new Insets(20,595,480,20));
        StackPane.setMargin(backButton, new Insets(430, 350, 15, 350));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll(ptnNonBH,backButton);
        Scene scene = new Scene(stackPane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}

