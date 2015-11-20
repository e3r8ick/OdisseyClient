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

    public PasswordText() {
        this.setPromptText("password");
    }
    
    @Override
    public String getText(int start, int end) {
        System.out.println("Password: "+super.getText());
        return super.getText(start, end); //To change body of generated methods, choose Tools | Templates.
    }
    
}
