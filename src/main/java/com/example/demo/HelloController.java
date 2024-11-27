package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HelloController {
    public ImageView imageView;
    public Pagination pagination;
    public SplitMenuButton splitMenuButton;
    public MenuItem button1;
    public MenuItem button2;
    public MenuItem button3;
    public MenuItem button4;
    public MenuItem button5;
    public Slider slider;
    public TextField textFieldTop;
    public Text textTop;
    public Text textBottom;
    public Button chooseButton;
    public TextField textFieldBottom;
    ArrayList<Image> imageArray = new ArrayList<Image>();

    int imageNum =1;
    @FXML

    public void initialize() throws Exception{
        FileInputStream input1 = new FileInputStream("src/snoopy.png");
        FileInputStream input2 = new FileInputStream("src/astro snoopy 2.png");
        FileInputStream input3 = new FileInputStream("src/astro snoopy.jpeg");
        FileInputStream input4 = new FileInputStream("src/Woodstock.png");
        FileInputStream input5 = new FileInputStream("src/eli.png");
        Image image1 = new Image(input1);
        Image image2 = new Image(input2);
        Image image3 = new Image(input3);
        Image image4 = new Image(input4);
        Image image5 = new Image(input5);

        imageArray.add(image1);
        imageArray.add(image2);
        imageArray.add(image3);
        imageArray.add(image4);
        imageArray.add(image5);

        pagination.setPageFactory((pageIndex) -> {
            imageNum = pageIndex;
            //splitmenu
            button1.setOnAction((event)-> {
                pagination.setCurrentPageIndex(0);
            });
            button2.setOnAction((event)-> {
                pagination.setCurrentPageIndex(1);
            });
            button3.setOnAction((event)-> {
                pagination.setCurrentPageIndex(2);
            });
            button4.setOnAction((event)-> {
                pagination.setCurrentPageIndex(3);
            });
            button5.setOnAction((event)-> {
                pagination.setCurrentPageIndex(4);
            });
            //slider
          slider.setOnDragDetected(mouseEvent -> {
              Double sliderMax = slider.getMax();
              Double sliderValue = slider.getValue();
                int incrementSize = sliderMax.intValue()/imageArray.size();
                int sliderChunk = sliderValue.intValue()/incrementSize;
                  pagination.setCurrentPageIndex(sliderChunk);
                  System.out.println("slider drag: sliderValue=" + sliderValue +  "incSize=" + incrementSize + " sliderChunk=" +  sliderChunk + " pageIndex=" + pagination.getCurrentPageIndex());
              });

            imageView.setImage(imageArray.get(imageNum));
            return imageView;
        });

    }

    public void chooseButtonPressed() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(pagination.getScene().getWindow());
        FileInputStream input6 = new FileInputStream(selectedFile);
        Image chosenImage = new Image(input6);
        imageArray.add(chosenImage);

        pagination.setPageCount(6);
        pagination.setCurrentPageIndex(6);

        MenuItem newImage = new MenuItem("Your Image");
        splitMenuButton.getItems().add(newImage);
        newImage.setOnAction(event -> {
            pagination.setCurrentPageIndex(6);
        });

        if(pagination.getCurrentPageIndex()==6){
        imageView.setImage(imageArray.get(5));
        }
    }
    public void addTextTop() throws Exception{
        String userText = textFieldTop.getText();
    System.out.println(userText);
    textTop.resize(0,50);
  //  text.setFont(arial sans);
    textTop.setText(userText);
    }
    public void addTextBottom() throws Exception{
        String userText = textFieldBottom.getText();
        System.out.println(userText);
        textBottom.resize(0,50);
        //  text.setFont(arial sans);
        textBottom.setText(userText);
    }

}

