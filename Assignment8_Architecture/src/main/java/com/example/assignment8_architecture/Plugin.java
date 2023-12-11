package com.example.assignment8_architecture;
import javafx.scene.layout.BorderPane;
public interface Plugin {
    // We define the two methods to be executed in the applications of the classes
    public BorderPane action();
    public String getName();
}

