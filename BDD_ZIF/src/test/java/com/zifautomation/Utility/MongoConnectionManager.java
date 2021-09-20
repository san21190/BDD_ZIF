package com.zifautomation.Utility;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoConnectionManager {
    public final Logger logger = Logger.getLogger(MongoConnectionManager.class.getName());

    String url;
    String user ;
    String password ;
    String databaseName;
    MongoClientURI connectionString=null;
    MongoClient mongoClient=null;
    MongoDatabase mongoDatabase=null;

    public void connect(String url){
        try {
            this.url=url;
            connectionString = new MongoClientURI(url);
            mongoClient = new MongoClient(connectionString);
            System.out.println("Mongo Client Connection Established to" + url);
        }
        catch (Exception ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public MongoCredential connect(String url,String userName,String database,String password){
        MongoCredential credential=null;
        try {
            this.user=userName;this.password=password;
            connectionString = new MongoClientURI(url);
            mongoClient = new MongoClient(connectionString);
            credential = MongoCredential.createCredential(userName, database ,password.toCharArray());

            System.out.println("Mongo DB Connection Established to" + url);
        }
        catch (Exception ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return credential;
    }

    public MongoDatabase connectToDatabase(String url,String databaseName){
        try {
            connect(url);

            mongoDatabase = mongoClient.getDatabase(databaseName);
            System.out.println("Database Connection Established to " + databaseName);
            this.databaseName=databaseName;
         }
        catch (Exception ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return mongoDatabase;

    }


}
