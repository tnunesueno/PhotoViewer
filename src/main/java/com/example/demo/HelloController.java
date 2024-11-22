package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.Pagination;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


import java.io.FileInputStream;
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
    // ADD CHOOOSE BUTTON


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

        ArrayList<Image> imageArray = new ArrayList<Image>();
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
                Double sliderValue = slider.getValue();
                    if (sliderValue.intValue() <= 20) {
                        pagination.setCurrentPageIndex(0);
                    }
                    if (sliderValue.intValue() >= 20 && sliderValue.intValue() <= 40) {
                        pagination.setCurrentPageIndex(1);
                    }
                    if (sliderValue.intValue() >= 40 && sliderValue.intValue() <= 60) {
                        pagination.setCurrentPageIndex(2);
                    }
                    if (sliderValue.intValue() >= 60 && sliderValue.intValue() <= 80) {
                        pagination.setCurrentPageIndex(3);
                    }
                    if (sliderValue.intValue() >= 80 && sliderValue.intValue() <= 100) {
                        pagination.setCurrentPageIndex(4);
                }
            });


            imageView.setImage(imageArray.get(imageNum));
         //   System.out.println("Hi Twyla " + pageIndex);
            return imageView;
        });


    }

}

