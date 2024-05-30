package UINFO.Pages;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import UINFO.Utils.SceneInterface;

public abstract class BaseScene implements SceneInterface {
    protected Stage stage;

    public BaseScene(Stage stage) {
        this.stage = stage;
    }

    protected void setBackground(Pane pane, String imagePath) {
        Image image = new Image(imagePath);
        BackgroundImage backgroundImage = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        pane.setBackground(new Background(backgroundImage));
    }

    protected void setStylesheet(Scene scene, String stylesheetPath) {
        scene.getStylesheets().add(getClass().getResource(stylesheetPath).toExternalForm());
    }

    protected void showScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}
