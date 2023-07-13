package com.application.vegabunk;

import com.application.vegabunk.db.dbParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label res;

    @FXML
    protected void btnLoginClicked() throws SQLException, IOException {
        dbParser db = new dbParser();
        if(! username.getText().isEmpty()) {
            if (password.getText().matches(db.getDob(username.getText()))) {
                String userName = username.getText();
                Stage stage = (Stage) username.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("Dashboard.fxml"));

                DashboardController dcontroll = new DashboardController(userName);

                fxmlLoader.setController(dcontroll);
                Scene scene = new Scene(fxmlLoader.load(), 1396, 723);
                stage.setTitle(userName);
                stage.setScene(scene);
                stage.show();
            } else {
                res.setText("Incorrect Password");
                res.setStyle("-fx-text-fill: #ff0000");
            }
        }
        else {
            res.setText("Enter username");
            res.setStyle("-fx-text-file: #ff0000");
        }
        db.close();
    }
}