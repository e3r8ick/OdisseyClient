/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

/**
 *
 * @author erick
 */
public class LoginManager {
    
    private static ControllerLogin controller;
    
    public LoginManager(){
        if(controller == null){
            controller = new ControllerLogin();
        }
    }

    /**
     * @return the controller
     */
    public ControllerLogin getController() {
        return controller;
    }

    /**
     * @param aController the controller to set
     */
    public void setController(ControllerLogin aController) {
        controller = aController;
    }
}
