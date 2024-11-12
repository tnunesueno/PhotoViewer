package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    public void initialize() throws Exception{
        FileImputStream input1 = new FileImputStream("src/astro snoopy 2.png");
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

