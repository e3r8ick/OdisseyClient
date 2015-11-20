/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odisseyclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import restclient.OdysseyRestClient;
import validacion.*;

/**
 *
 * @author erick
 */
public class LoginFXMLController implements Initializable, ControlledScreen{
    
    ScreensController myController;
    @FXML private PasswordText passwordText;
    @FXML private UsernameText usernameText;
    
    private StringProperty textProperty = new SimpleStringProperty();
    
    @FXML
    private void goToUser(ActionEvent event) throws IOException {
        OdysseyRestClient client = new OdysseyRestClient();
        //System.out.println(passwordText.getText());
        //System.out.println(usernameText.getText());
        myController.setScreen(ScreensFramework.USER_SCREEN_FXML);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert usernameText != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'TestView.fxml'.";
           usernameText.textProperty().bind(textProperty);
    }

    public ReadOnlyStringProperty textProperty(){
          return textProperty;
    }   */

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
}
