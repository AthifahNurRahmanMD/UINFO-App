package UINFO;

import UINFO.Pages.Home;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Home homie = new Home(primaryStage);
        homie.show();
        
        // Mengatur stage utama
        primaryStage.setTitle("UINFO APP"); 
        primaryStage.setResizable(false);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
