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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PTN_BH {
    private Stage stage;
    private Kampus kampus;

    public PTN_BH(Stage stage, Kampus kampus) {
        this.stage = stage;
        this.kampus = kampus;
    }

    public void show(){
        Label ptnBh = new Label("PTN-BH");
        ptnBh.getStyleClass().add("text-aboutptnbh1");
        Text text = new Text("PTN-BH");
        text.getStyleClass().add("PTN-BH");
        Text text2 =  new Text("Perguruan Tinggi Berbadan Hukum");
        text2.getStyleClass().add("text-aboutptnbh2");

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
        StackPane.setMargin(ptnBh, new Insets(20,595,480,20));
        StackPane.setMargin(text, new Insets(50,90,100,200));
        StackPane.setMargin(text2, new Insets(80,170,50,30));
        StackPane.setMargin(backButton, new Insets(430, 350, 15, 350));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll(ptnBh,text,text2,backButton);
        Scene scene = new Scene(stackPane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
