package com.example.assignment8_architecture;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Ping implements Plugin{

    public String name;
    public String button1_name;
    public String input_message;
    public String output_message;

    public Ping (String name, String button1_name, String input_message, String output_message) {
        this.name = name;
        this.button1_name = button1_name;
        this.input_message = input_message;
        this.output_message = output_message;
    }

    @Override
    public BorderPane button1_action() {
        Random rand = new Random();
        TextField textF_ping = new TextField();
        Button button_ping = new Button(this.button1_name);

        HBox ping = new HBox(1);
        ping.setAlignment(Pos.CENTER);
        ping.setPadding(new Insets(1));
        ping.getChildren().addAll(textF_ping, button_ping);

        BorderPane pane2 = new BorderPane();
        pane2.setCenter(ping);

        button_ping.setOnAction(e -> {
            textF_ping.setText(rand.nextInt(500) + 1 + "ms");
        });
        return pane2;
    }
    @Override
        public String getName(){
        return this.name;
    }
}