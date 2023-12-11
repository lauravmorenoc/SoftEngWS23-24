package com.example.assignment8_architecture;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Calculator implements Plugin{

    // The attributes of the class are defined here
    private String name;
    private String button1_name;
    private String input_message;
    private String output_message;


    public Calculator(String name, String button1_name, String input_message, String output_message) {
        this.name = name;
        this.button1_name = button1_name;
        this.input_message = input_message;
        this.output_message = output_message;
    }

    //Here the parameters and the logical connection when the button is pressed are defined.

    @Override
    public BorderPane action() {

        // Creation of button names and field texts
        Text tNumber1 = new Text(this.input_message);
        Text tResult = new Text(this.output_message);
        TextField tfNumber1 = new TextField();
        TextField tfResult = new TextField();
        tfResult.setEditable(false);

        // Create the bottom section
        Button btAdd = new Button(this.button1_name);

        // Spatial organization of the panel's elements
        HBox calcTop = new HBox(3);
        calcTop.setAlignment(Pos.CENTER);
        calcTop.setPadding(new Insets(3));
        calcTop.getChildren().addAll(tNumber1, tfNumber1, tResult, tfResult);

        HBox calcBottom = new HBox(3);
        calcBottom.setAlignment(Pos.CENTER);
        calcBottom.setPadding(new Insets(3));
        calcBottom.getChildren().addAll(btAdd);

        // Add HBox containers to a BorderPane
        BorderPane pane = new BorderPane();
        pane.setCenter(calcTop);
        pane.setBottom(calcBottom);

        // Logic to be executed when the button is pressed
        btAdd.setOnAction(e -> {
             String input = tfNumber1.getText();
             input="Operation "+input+ " made.";
             tfResult.setText(input);
        });
        return pane;
    }

    @Override
    public String getName(){
        return this.name;
    }
}