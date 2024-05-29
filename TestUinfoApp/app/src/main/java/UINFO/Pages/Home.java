package UINFO.Pages;

import javafx.geometry.Insets;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home {
    private Stage primaryStage;

    // konstruktor Home dengan menerima primaryStage sebagai parameter
    public Home(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    public void show() {
        Text uinfoText = new Text("UINFO APP");
        uinfoText.getStyleClass().add("text-uinfo");

        Label welcome = new Label("Selamat Datang");
        welcome.getStyleClass().add("label-welcome");

        Label welcome2 = new Label("Di Laman UINFO");
        welcome2.getStyleClass().add("label-welcome2");

        Button startButton = new Button("Masuk");
        startButton.getStyleClass().add("button-startButton");
        startButton.setPrefWidth(178);
        startButton.setOnAction(e -> {
            PtSession ptSession =  new PtSession(primaryStage);
            ptSession.show();
        });

        VBox selamatDatang = new VBox(welcome, welcome2);
        selamatDatang.setAlignment(Pos.TOP_RIGHT);

        VBox rootVBox = new VBox(selamatDatang, startButton);
        rootVBox.setSpacing(30);
        rootVBox.setAlignment(Pos.CENTER_RIGHT);

        VBox.setMargin(welcome, new Insets(0, 70, 10, 0));
        VBox.setMargin(welcome2, new Insets(0, 105, 10, 0));
        VBox.setMargin(startButton, new Insets(10, 70, 0, 0));

        Image image = new Image("Images/homebg.png");
        BackgroundImage  backgroundImage =  new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1, 1, true, true, true, false));
        rootVBox.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(rootVBox, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/CssStyle/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}