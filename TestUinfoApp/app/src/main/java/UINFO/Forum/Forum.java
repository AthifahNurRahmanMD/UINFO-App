package UINFO.Forum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import UINFO.Models.Kampus;
import UINFO.Pages.PTNSDetail;
import UINFO.db.DbManager;

public class Forum {
    static DbManager dbManager;
    private final Stage stage;
    ObservableList<CommentCell> comments = FXCollections.observableArrayList();
    private Kampus kampus;


    public Forum(Stage stage, Kampus kampus) {
        this.stage = stage;
        this.kampus = kampus;
        this.comments = FXCollections.observableArrayList();
        loadComments();
    }

    // public Forum(Kampus kampus){
    //     this.kampus = kampus;
    //     this.comments = FXCollections.observableArrayList();
    //     loadComments();
    // }

    public void showForum() {
        ListView<CommentCell> commentListView = new ListView<>(comments);
        commentListView.setCellFactory(param -> new CustomListCell());
        commentListView.setPrefHeight(200); // Atur ukuran tinggi ListView jika diperlukan

        TextArea commentArea = new TextArea();
        commentArea.setMaxWidth(300);
        commentArea.setPrefHeight(100);
        commentArea.setTranslateX(225);
        commentArea.setTranslateY(120);
        commentArea.setPromptText("Your comment (Max 200 chars)");
        commentArea.setWrapText(true);
        commentArea.getStyleClass().add("area-comment");

        Image kirimPesan = new Image(getClass().getResourceAsStream("/Images/kirimpesan.png"));
        ImageView kirimPesanImageView = new ImageView(kirimPesan);
        kirimPesanImageView.setFitWidth(30);
        kirimPesanImageView.setFitHeight(30);
        // kirimPesanImageView.getStyleClass().add("png-kirimpesan");

        Button kirimPesanButton = new Button();
        kirimPesanButton.setGraphic(kirimPesanImageView);
        kirimPesanButton.setTranslateX(540);
        kirimPesanButton.setTranslateY(70);
        kirimPesanButton.getStyleClass().add("button-kirimpesan");
        kirimPesanButton.setOnAction(e -> {
            if (commentArea.getText().length() <= 200) {
                UserAndPass loginPopup = new UserAndPass(this, commentArea.getText());
                loginPopup.showLogin();
                commentArea.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Comment cannot exceed 200 characters");
                alert.showAndWait();
            }
        });

        Image UserPng = new Image(getClass().getResourceAsStream("/Images/user.png"));
        ImageView userFoto = new ImageView(UserPng);
        userFoto.setFitWidth(30);
        userFoto.setFitHeight(30);
        userFoto.setTranslateX(180);
        userFoto.setTranslateY(-10);

        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setTranslateY(30);
        backButton.setOnAction(e -> {
            if (kampus.getStatus().equals("")) {
                PTNSDetail ptsScene = new PTNSDetail(stage, kampus);
                ptsScene.show();
            } else {
                PTNSDetail ptnScene = new PTNSDetail(stage, kampus);
                ptnScene.show();
            }
        });

        
        VBox vbox = new VBox(2, commentListView, commentArea, kirimPesanButton, backButton,userFoto);
        vbox.setPadding(new Insets(10));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(vbox);

        Scene forumScene = new Scene(stackPane, 800, 500);
        forumScene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());

        stage.setScene(forumScene);
        stage.setTitle("Forum Diskusi");
        stage.show();
    }

    
    public void addComment(String username, String comment) {
        comments.add(new CommentCell(username, comment, 0));
        saveCommentToDatabase(username, comment);
    }

    private void loadComments() {
        DbManager dbManager = new DbManager();
        dbManager.getComments().forEach(comment -> comments.add(new CommentCell(comment.getUsername(), comment.getComment(), comment.getLikes())));
    }

    private void saveCommentToDatabase(String username, String comment) {
        DbManager dbManager = new DbManager();
        dbManager.insertComment(username, comment);
    }

}
