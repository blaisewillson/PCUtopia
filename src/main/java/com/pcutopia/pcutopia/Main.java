package com.pcutopia.pcutopia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        stage.setTitle("PC Utopia");
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(278);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        System.out.println("Welcome to PC Utopia");
        System.out.println("--------------------\n");

        User tempUser = new User("John",  "johndoe123@email.com", "johnDoe123");

        User tempUser2 = new User("Mary",  "marysmith237@email.com", "marySmith573");


//        FileWriter fileWriter = new FileWriter("data/Users.txt", true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        PrintWriter printWriter = new PrintWriter(bufferedWriter);
//        printWriter.println(tempUser.toString());
//        printWriter.print(tempUser2.toString());
//        printWriter.close();

        PartDatabase partDatabase = new PartDatabase();
        PCBuild pcBuild1 = new PCBuild(tempUser, partDatabase);
//        pcBuild1.addComponent("psu", 2);
//        pcBuild1.addComponent("gpu", 0);
//        pcBuild1.writeList();
//
//        pcBuild1.addComponent("psu", 0);
//        pcBuild1.addComponent("cpu", 0);
//        pcBuild1.addComponent("case", 0);
//        pcBuild1.addComponent("mobo", 0);
//        pcBuild1.removeComponent("mobo");
//        pcBuild1.addComponent("mobo", 1);
//        pcBuild1.addComponent("gpu", 2);
//        pcBuild1.writeList();
////
        PCBuild pcBuild2 = new PCBuild(tempUser2, partDatabase);
//        pcBuild2.addComponent("psu", 0);
//        pcBuild2.addComponent("cpu", 2);
//        pcBuild2.removeComponent("psu");
//        pcBuild2.removeComponent("cpu");
//        pcBuild2.writeList();

        pcBuild2.addComponent("psu", 0);
        pcBuild2.addComponent("cpu", 2);
        pcBuild2.writeList();

        pcBuild2.addComponent("case", 0);
        pcBuild2.addComponent("mobo", 1);
        pcBuild2.addComponent("gpu", 1);
        pcBuild2.writeList();
    }
}