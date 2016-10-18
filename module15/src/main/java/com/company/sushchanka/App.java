package com.company.sushchanka;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.mongodb.client.model.Filters.lt;

public class App 
{
    public static void main( String[] args )
    {
        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mongoClient.getDatabase("module15");
            MongoCollection<Document> tasks = db.getCollection("tasks");
            /** Insert */
            System.out.println("++++++++++++INSERT++++++++++++++++");
            for (int i=0; i<5; i++) {
                Document document = new Document().append("name", "A_"+i).append("category", "x").append("creationDate", "2016-07-02").append("deadLine", "2016-07-05");
                tasks.insertOne(document);
            }

            for (int j = 0; j<5; j++) {
                Document document = new Document().append("name", "B_"+j).append("category", "o").append("creationDate", "2014-07-02").append("deadLine", "2018-07-05");
                tasks.insertOne(document);
            }
            FindIterable<Document> iterable = tasks.find();
            final MongoCursor<Document> iterator = iterable.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }

            System.out.println("Tasks count: "+ tasks.count());

            System.out.println("+++++++++ Update task ++++++++++");
            Document query = new Document("name", "B_2");
            Document newDoc = new Document("name", "JJ");
            Document updateDoc = new Document("$set", newDoc);
            tasks.updateOne(query, updateDoc);

            System.out.println("+++++++++ Display overdue tasks +++++++++++");
            FindIterable<Document> iterable1 = tasks.find(lt("deadLine", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            iterable1.forEach((Block <? super Document>)System.out::println);

            /** Delete. */
            System.out.println("+++++ Delete by name ++++++++");
            Document searchQuery = new Document();
            searchQuery.put("name", "B_4");
            tasks.findOneAndDelete(searchQuery);

            /** Display all task one category. */
            System.out.println("++++++++ Display task one category +++++++++++");
            FindIterable<Document> iterable2 = tasks.find(new Document("category", "o"));
            iterable2.forEach((Block <? super Document>)System.out::println);

            tasks.drop();
            System.out.println("Tasks dropped. Count: " + tasks.count());
        }
    }
}
