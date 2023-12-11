package com.example.assignment8_architecture;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {
    static Scanner input = new Scanner(System.in);
    static int aux;

    @Override
    public void start(Stage primaryStage) {

        Calculator calc=new Calculator("My Great Calculator", "Calculate", "Input", "Result");
        Ping ping = new Ping("Ping","ping","","");
        File_upload fileUpload = new File_upload("File Upload", "Browse", "Upload","","");
        BorderPane pane=new BorderPane();
        String name="";
        switch (aux){
            case 1:
                pane=calc.button1_action();
                name=calc.getName();
                break;
            case 2:
                pane = ping.button1_action();
                name=ping.getName();
                break;
            case 3:
                pane = fileUpload.button1_action();
                name = fileUpload.getName();
                break;
            default:
                break;
        }

        Scene scene = new Scene(pane,350,100);
        primaryStage.setTitle(name);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private static double getDoubleFromTextField(TextField t) {
        return Double.parseDouble(t.getText());
    }

    public static void main(String[] args) {

        System.out.println("Calculator :1");
        System.out.println("Ping :2");
        System.out.println("File Uploader :3");
        aux = input.nextInt();
        launch(args);
    }
}
