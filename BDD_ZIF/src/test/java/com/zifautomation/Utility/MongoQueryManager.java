package com.zifautomation.Utility;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;
import java.util.Map;

public class MongoQueryManager {

    MongoCollection<Document> collection=null;
    MongoDatabase database;
    public MongoQueryManager(String url, String db){
        MongoConnectionManager mongoConnectionManager=new MongoConnectionManager();
        MongoDatabase database =mongoConnectionManager.connectToDatabase(url,db);
        this.database=database;

    }
    public void setCollection(MongoDatabase database, String collectionName){
         collection = database.getCollection(collectionName);
        System.out.println("connected to mongo db" + collection.toString());
    }

    public FindIterable<Document> getAllDocuments(String collectionName){
        setCollection(database,collectionName);
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        System.out.println("All Documents");
        System.out.println();

        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println();
            i++;
        }
        return iterDoc;
    }

    public FindIterable<Document> getDocumentsWithFields(String collectionName, Map<String,String> fields){
        setCollection(database,collectionName);
        BasicDBObject whereQuery = new BasicDBObject();
        for(Map.Entry<String, String> entry : fields.entrySet()) {
            whereQuery.put(entry.getKey(), entry.getValue());
        }
        FindIterable<Document> iterDoc = collection.find(whereQuery);
        int i = 1;
        System.out.println("Documents with Query");
        System.out.println();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }

        return iterDoc;
    }

    public long getCountOfCollection(String collectionName){
        MongoCollection collection = database.getCollection(collectionName);
        return  collection.count();
    }

    public void printDocuments(FindIterable<Document> documents){
        for(Document doc:documents){
            String test=doc.get("dev_model_name").toString();
            System.out.println("\"id\"======>"+doc.get("_id"));

        }
    }

}
