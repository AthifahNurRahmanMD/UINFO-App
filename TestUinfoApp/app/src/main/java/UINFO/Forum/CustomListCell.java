package UINFO.Forum;

import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import UINFO.db.DbManager;

public class CustomListCell extends ListCell<CommentCell> {
    @Override
    protected void updateItem(CommentCell item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            ImageView profileImageView = new ImageView(new Image("/Images/user.png"));
            profileImageView.setFitWidth(30);
            profileImageView.setFitHeight(30);

            Text usernameText = new Text(item.getUsername());
            Text commentText = new Text(item.getComment());

            Button likeButton = new Button("Like(" + item.getLikes() + ")");
            likeButton.getStyleClass().add("like-button");

            item.likesProperty().addListener((obs, oldLike, newLike) -> {
                likeButton.setText("Like(" + newLike + ")");
            });

            likeButton.setOnAction(e -> {
                item.incrementLikes();
                DbManager dbManager = new DbManager();
                dbManager.updateLikes(item.getUsername());
            });

            VBox vbox = new VBox(5, usernameText, commentText, likeButton);
            HBox hbox = new HBox(30, profileImageView, vbox);

            // HBox hbox = new HBox(10, profileImageView, usernameText, commentText);
            setGraphic(hbox);
        }
    }
}