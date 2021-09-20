package com.zifautomation.Utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresQueryManager {
    public final static Logger logger = Logger.getLogger(PostgresQueryManager.class.getName());

    public static ResultSet executeSelectQuery(Connection con,String query){
        ResultSet rs=null;

        try{
            Statement st = con.createStatement();
            st.setQueryTimeout(8000);
            rs = st.executeQuery(query) ;

        }
        catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return rs;
    }


}
