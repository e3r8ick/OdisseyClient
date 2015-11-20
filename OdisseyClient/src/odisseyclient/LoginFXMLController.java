/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odisseyclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import restclient.OdisseyRestClient;

/**
 *
 * @author erick
 */
public class LoginFXMLController implements Initializable, ControlledScreen{
    
    ScreensController myController;
    
    @FXML
    private void goToUser(ActionEvent event) {
        OdisseyRestClient client = new OdisseyRestClient();
        myController.setScreen(ScreensFramework.USER_SCREEN_FXML);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
}
