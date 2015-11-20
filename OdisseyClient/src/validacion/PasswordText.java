/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

import javafx.scene.control.PasswordField;

/**
 *
 * @author erick
 */
public class PasswordText extends PasswordField{
    
    static ControllerLogin controller;

    public PasswordText() {
        this.setPromptText("password");
        
    }
    
    @Override
    public String getText(int start, int end) {
        //String pass = super.getText();
        //System.out.println("Password: "+pass);
        return super.getText(start, end); //To change body of generated methods, choose Tools | Templates.
    }
    
}
