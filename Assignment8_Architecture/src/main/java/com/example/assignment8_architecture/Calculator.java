package com.example.assignment8_architecture;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Calculator implements Plugin{

    public String name;
    public String button1_name;
    public String input_message;
    public String output_message;

    public Calculator(String name, String button1_name, String input_message, String output_message) {
        this.name = name;
        this.button1_name = button1_name;
        this.input_message = input_message;
        this.output_message = output_message;
    }

    @Override
    public BorderPane button1_action() {
        Text tNumber1 = new Text(this.input_message);
        Text tResult = new Text(this.output_message);
        TextField tfNumber1 = new TextField();
        TextField tfResult = new TextField();
        tfResult.setEditable(false);

        // Create the bottom section
        Button btAdd = new Button(this.button1_name);

        // Add top UI to HBox containers
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

        // Register event handlers for buttons
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