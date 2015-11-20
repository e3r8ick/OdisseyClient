/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odisseyclient;

import database.DataBaseManager;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class UserFXMLController implements Initializable, ControlledScreen {

    ScreensController myController; 
    final FileChooser fileChooser = new FileChooser();
    Stage stage = new Stage();
    DataBaseManager manager = new DataBaseManager();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
   @FXML
    private void fileChosser(ActionEvent event) {
       // myController.setScreen(ScreensFramework.USER_SCREEN_FXML);
        configureFileChooser(fileChooser);
         List<File> list = fileChooser.showOpenMultipleDialog(stage);
                    if (list != null) {
                        for (File file : list) {
                            manager.getBaseLocal().subirMusica(file.toString());
                            manager.getBaseLocal().getCanciones();
                        }
                    }
    }
    
     private static void configureFileChooser(final FileChooser fileChooser){                           
        fileChooser.setTitle("Select Song");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        ); 
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Songs", "*.*"),
                new FileChooser.ExtensionFilter("MP3", "*.mp3"),
                new FileChooser.ExtensionFilter("MPEG", "*.mpeg")
            );
    }
    
}
