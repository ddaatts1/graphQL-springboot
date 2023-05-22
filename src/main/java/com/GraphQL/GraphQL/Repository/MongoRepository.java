package com.GraphQL.GraphQL.Repository;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MongoRepository {


    @Value("${spring.data.mongodb.database}")
    String db;

    @Autowired
    MongoClient mongoClient;

    public List<Document> getAllAddress(){
        MongoDatabase database= mongoClient.getDatabase(db);
        MongoCollection<Document> collection = database.getCollection("addresses");
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.cursor();

        List<Document> list = new ArrayList<>();
        while (cursor.hasNext()){
            System.out.println("===>");
            list.add(cursor.next());
        }

        return list;
    }

}
