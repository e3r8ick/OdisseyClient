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
public class ControllerLogin {
    private static String username;
    private static String password;
    static UsernameText user;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param aUsername the username to set
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }
    
    public ControllerLogin(String pUsername, String pPassword){
        username = pUsername;
        password = pPassword;
        System.out.println(user.getText());
    }
    
    public ControllerLogin(){
        /*username = "";
        password = "";*/
    }
}
