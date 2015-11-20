/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author erick
 */
public class SQLite {
    
    public SQLite(){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Odissey.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql =  "CREATE TABLE IF NOT EXISTS songs (\n" +
                    "ID int(11) PRIMARY KEY NOT NULL, \n" +
                    "NAME varchar(25) UNIQUE DEFAULT NULL,\n" +
                    "ALBUM varchar(25) DEFAULT NULL,\n" +
                    "YEAR int(4) DEFAULT NULL,\n" +
                    "ARTIST varchar(20) DEFAULT NULL,\n" +
                    "GENRE varchar(10) DEFAULT NULL,\n" +
                    "LYRICS varchar(26) DEFAULT NULL,\n" +
                    "SIZE int(11) NOT NULL,\n" +
                    "OWNER int(11) UNIQUE NOT NULL,\n" +
                    "TIMESTAMP datetime NOT NULL)";
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
    }
    
}
