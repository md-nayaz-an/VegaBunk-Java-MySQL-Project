package com.application.vegabunk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.application.vegabunk.db.init;
import java.io.IOException;

public class LoginPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new init().connectDB();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("LoginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1396, 723);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}