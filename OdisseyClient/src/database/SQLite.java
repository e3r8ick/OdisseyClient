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
      c = DriverManager.getConnection("jdbc:sqlite:Odyssey.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql =  "CREATE TABLE IF NOT EXISTS songs (\n" +
                    "ID INTEGER PRIMARY KEY NOT NULL, \n" +
                    "NAME varchar(25) UNIQUE DEFAULT NULL,\n" +
                    "ALBUM varchar(25) DEFAULT NULL,\n" +
                    "YEAR int(4) DEFAULT NULL,\n" +
                    "ARTIST varchar(20) DEFAULT NULL,\n" +
                    "GENRE varchar(10) DEFAULT NULL,\n" +
                    "LYRICS varchar(26) DEFAULT NULL,\n" +
                    "SIZE int(11) NOT NULL,\n" +
                    "OWNER int(11) NOT NULL,\n" +
                    "TIMESTAMP datetime NOT NULL," + 
                    "PATH varchar(100) NOT NULL)";
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
    }
    
    public void subirMusica(String path){
        String[] nombre = path.split("/");
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Odyssey.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO songs (SIZE,TIMESTAMP,OWNER,PATH) " +
                         "VALUES (200,datetime('now','localtime'),"+2+",\'"+nombre[nombre.length-1]+"\'" +");"; ///ese 1  es el owner que hace falta
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
      }
    
    public void getCanciones(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Odyssey.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM songs;" );
            while ( rs.next() ) {
            int id = rs.getInt("ID");
            String  name = rs.getString("NAME");
            String  album = rs.getString("ALBUM");
            int year = rs.getInt("YEAR");
            String  artist = rs.getString("ARTIST");
            String  genre = rs.getString("GENRE");
            String  lyrics = rs.getString("LYRICS");
            int size = rs.getInt("SIZE");
            int owner = rs.getInt("OWNER");
            String  path = rs.getString("PATH");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "ALBUM = " + album );
            System.out.println( "YEAR = " + year );
            System.out.println( "ARTIST = " + artist );
            System.out.println( "GENRE = " + genre );
            System.out.println( "LYRICS = " + lyrics );
            System.out.println( "SIZE = " + size );
            System.out.println( "OWNER = " + owner );
            System.out.println( "PATH = " + path );
            System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        }    
}