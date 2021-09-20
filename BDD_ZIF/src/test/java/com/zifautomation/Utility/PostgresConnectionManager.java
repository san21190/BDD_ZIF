package com.zifautomation.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresConnectionManager {
   public final Logger logger = Logger.getLogger(PostgresConnectionManager.class.getName());

    String url;
    String user ;
    String password ;
    Connection con;

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Connection getCon() {
        return con;
    }

    public PostgresConnectionManager(String url, String user, String password){
        try {

            this.url=url;
            this.user=user;
            this.password=password;
           // while (con!=null)
                con = DriverManager.getConnection(url, user, password);
             System.out.println("connection established");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void closeConnection(){
        try {
            con.close();

        } catch (SQLException throwables) {
            logger.log(Level.SEVERE, throwables.getMessage(), throwables);
        }
    }

    public PostgresConnectionManager(){
        try {

            this.url="jdbc:postgresql://172.31.28.8:5432/zif";
            this.user="zif";
            this.password="ZIF@@123";
            // while (con!=null)
            System.out.println("before connection established");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connection established");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static void main(String[] args){
        new PostgresConnectionManager();
    }

}
