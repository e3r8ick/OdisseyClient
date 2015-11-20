/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author erick
 */
public class DataBaseManager {
    
    private static SQLite baseLocal;

    /**
     * @return the baseLocal
     */
    public SQLite getBaseLocal() {
        return baseLocal;
    }

    /**
     * @param aBaseLocal the baseLocal to set
     */
    public void setBaseLocal(SQLite aBaseLocal) {
        baseLocal = aBaseLocal;
    }
    
    public DataBaseManager(){
        if(baseLocal == null){
            baseLocal = new SQLite();
        }
    }
}
