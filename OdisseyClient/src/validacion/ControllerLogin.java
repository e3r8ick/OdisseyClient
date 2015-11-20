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
public final class ControllerLogin {
    private String username;
    private String password;
    private UsernameText usernameText;

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
    
    public ControllerLogin(){
        username = "";
        password = "";
        System.out.println("USer statico"+ usernameText);
    }
    
    public ControllerLogin(String pUsername, String pPassword){
        username = pUsername;
        password = pPassword;
    }

    /**
     * @return the usernmaeText
     */
    public UsernameText getUsernameText() {
        return usernameText;
    }

    /**
     * @param usernmaeText the usernmaeText to set
     */
    public void setUsernameText(UsernameText usernmaeText) {
        this.usernameText = usernmaeText;
    }
}
