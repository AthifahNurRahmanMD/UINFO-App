package UINFO.Forum;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import UINFO.db.DbManager;

public class UserAndPass {
    private final Forum forum;
    private final String comment;

    public UserAndPass(Forum forum, String comment) {
        this.forum = forum;
        this.comment = comment;
    }

    public void showLogin() {
        Stage loginStage = new Stage();
        loginStage.initModality(Modality.APPLICATION_MODAL);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign Up");

        loginButton.setOnAction(e -> {
            System.out.println("Button Login clicked!");
            String username = usernameField.getText();
            String password = passwordField.getText();
            DbManager dbManager = new DbManager();
            if (dbManager.validateUser(username, password)) {
                forum.addComment(username, comment);
                loginStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password");
                alert.showAndWait();
            }

        });

        signUpButton.setOnAction(e -> {
            showSignUp();
            loginStage.close();
        });

        VBox vbox = new VBox(10, usernameField, passwordField, loginButton, signUpButton);
        Scene scene = new Scene(vbox, 300, 200);
        loginStage.setScene(scene);
        loginStage.setTitle("Login");
        loginStage.show();
    }

    public void showSignUp() {
        Stage signUpStage = new Stage();
        signUpStage.initModality(Modality.APPLICATION_MODAL);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button signUpButton = new Button("Sign Up");

        signUpButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            DbManager dbManager = new DbManager();
            if (dbManager.registerUser(username, password)) {
                showLogin();
                signUpStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Username already exists");
                alert.showAndWait();
            }
        });

        VBox vbox = new VBox(10, usernameField, passwordField, signUpButton);
        Scene scene = new Scene(vbox, 300, 200);
        signUpStage.setScene(scene);
        signUpStage.setTitle("Sign Up");
        signUpStage.show();
    }
}