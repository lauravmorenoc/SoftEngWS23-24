/*  Presented by:
    Jorge Elías Aponte Trejos - 108023117942
    Laura Valentina Moreno Castro - 108023117955
    Daniel Santiago Robayo Rico - 108023117968
    Tutorial time slot: Thursdays 8:15AM  */

package com.example.assignment8_architecture;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {

    //  Definition of attributes
    static Scanner input = new Scanner(System.in);
    static int aux;

    @Override
    public void start(Stage primaryStage) {

        // Creation of each of the objects representing each application
        Calculator calc=new Calculator("My Great Calculator", "Calculate", "Input", "Result");
        Ping ping = new Ping("Ping","ping");
        File_upload fileUpload = new File_upload("File Upload", "Browse", "Upload");

        BorderPane pane=new BorderPane();
        String name="";

        // This part allows the user to select which application to activate
        switch (aux){
            case 1:
                pane=calc.action();
                name=calc.getName();
                break;
            case 2:
                pane = ping.action();
                name=ping.getName();
                break;
            case 3:
                pane = fileUpload.action();
                name = fileUpload.getName();
                break;
            default:
                break;
        }

        // Panel parameters are defined
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
        System.out.println("Select the application to run \n 1: Calculator. \n 2: Ping. \n 3: File Uploader.");
        aux = input.nextInt();
        launch(args);
    }
}