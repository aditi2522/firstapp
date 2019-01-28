package com.adi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
         VBox rootNode = loader.load();
         MenuBar menuBar=createmenu();
         rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode, 289, 375);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Control tool");
        primaryStage.setResizable(true);
        primaryStage.show();


    }
    private MenuBar createmenu()
    {
        Menu filemenu=new Menu("File");
        MenuItem newfilemenu=new MenuItem("new");
        newfilemenu.setOnAction(event -> System.out.println("neww file"));
        MenuItem openfilemenu=new MenuItem("open");
        filemenu.getItems().addAll(newfilemenu,openfilemenu);
        Menu helpmenu=new Menu("help");
        MenuItem about=new MenuItem("about");
        helpmenu.getItems().addAll(about);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(filemenu,helpmenu);
        return menuBar;
    }
}
