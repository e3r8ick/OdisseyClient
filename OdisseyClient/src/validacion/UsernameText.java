/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

import javafx.scene.control.TextField;

/**
 *
 * @author erick
 */

public class UsernameText extends TextField{
    
    public UsernameText(){
        this.setPromptText("username");
    }

    @Override
    public String getText(int start, int end) {
        System.out.println("Username: "+super.getText());
        return super.getText(start, end); //To change body of generated methods, choose Tools | Templates.
    }
    
}
