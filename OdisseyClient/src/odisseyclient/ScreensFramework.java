/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odisseyclient;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import database.*;

/**
 *
 * @author erick
 */
public class ScreensFramework extends Application { 

     public static final String MAIN_SCREEN = "main"; 
     public static final String MAIN_SCREEN_FXML = "LoginFXML.fxml"; 
     public static final String USER_SCREEN = "user"; 
     public static final String USER_SCREEN_FXML = "UserFXML.fxml"; 
     /*public static final String PLAYER_SCREEN = "player"; 
     public static final String PLAYER_SCREEN_FXML = 
                                          "PlayerFXML.fxml"; */

     @Override 
     public void start(Stage primaryStage) { 

       ScreensController mainContainer = new ScreensController(); 
       mainContainer.loadScreen(ScreensFramework.MAIN_SCREEN,  ScreensFramework.MAIN_SCREEN_FXML); 
       mainContainer.loadScreen(ScreensFramework.USER_SCREEN, ScreensFramework.USER_SCREEN_FXML); 
       //mainContainer.loadScreen(ScreensFramework.PLAYER_SCREEN, ScreensFramework.PLAYER_SCREEN_FXML); 

       mainContainer.setScreen(ScreensFramework.MAIN_SCREEN); 
       mainContainer.addScreen(USER_SCREEN_FXML, mainContainer.getScreen(USER_SCREEN));

       Group root = new Group(); 
       root.getChildren().addAll(mainContainer); 
       Scene scene = new Scene(root); 
       primaryStage.setScene(scene); 
       primaryStage.show(); 
     } 
     
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SQLite sqllite = new SQLite();
        launch(args);
    }
}