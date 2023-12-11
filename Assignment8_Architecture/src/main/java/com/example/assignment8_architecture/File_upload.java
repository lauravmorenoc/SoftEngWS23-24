package com.example.assignment8_architecture;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class File_upload implements Plugin{

    public String name;
    public String button1_name;
    public String button2_name;
    public String input_message;
    public String output_message;

    public File_upload(String name, String button1_name, String button2_name, String input_message, String output_message) {
        this.name = name;
        this.button1_name = button1_name;
        this.input_message = input_message;
        this.output_message = output_message;
        this.button2_name=button2_name;
    }


    @Override
    public BorderPane button1_action() {
        TextField textF_file = new TextField();

        Button button_file1 = new Button(this.button1_name);
        Button button_file2 = new Button(this.button2_name);

        HBox file_box = new HBox(2);
        file_box.setAlignment(Pos.CENTER);
        file_box.setPadding(new Insets(2));
        file_box.getChildren().addAll(textF_file, button_file1, button_file2);

        BorderPane pane3 = new BorderPane();
        pane3.setCenter(file_box);
        button_file1.setOnAction(e -> {
            textF_file.setText("File browsed");
        });
        button_file2.setOnAction(e -> {
            textF_file.setText("File uploaded");
        });
        return pane3;
    }

    @Override
    public String getName(){
        return this.name;
    }

}