package UINFO.Pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home {
    private Stage primaryStage;
    
    // konstruktor Home dengan menerima primaryStage sebagai parameter
    public Home(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    public void show() {

        Button lookButton = new Button("LOOK");
        lookButton.setLayoutX(100);  
        lookButton.setLayoutY(410); 
        lookButton.setOnAction(e -> {
            PtSession ptSession =  new PtSession(primaryStage);
            ptSession.show();
        });
        // lookButton.setStyle("-fx-background-color: transparent;");


        Pane root = new Pane();
        root.getChildren().addAll(lookButton); 
        root.setPrefSize(800, 540);

        VBox rootVBox = new VBox();
        rootVBox.getChildren().add(root);

        Scene scene = new Scene(rootVBox, 800, 540);

        Image image = new Image("Images/homepage.png");
        BackgroundImage  backgroundImage =  new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1, 1, true, true, false, false));
        root.setBackground(new Background(backgroundImage));

        // button.setOnAction(event -> new Look().showLoginDialog());
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
