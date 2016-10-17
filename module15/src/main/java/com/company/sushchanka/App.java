package com.company.sushchanka;

import com.company.sushchanka.beans.Task;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.lt;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        Task task = new Task("AAAAAA", "x", LocalDate.parse("2016 07 02", formatter), LocalDate.parse("2016 07 02", formatter));
        System.out.println( task );

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

            System.out.println("+++++++++ Display overdue tasks +++++++++++");
            FindIterable<Document> iterable1 = tasks.find(lt("deadLine", new Date()));
            iterable1.forEach((Block <? super Document>)System.out::println);

            /** Display all task one category. */
            System.out.println("++++++++ Display task one category");
            FindIterable<Document> iterable2 = tasks.find(new Document("category", "x"));
            iterable2.forEach((Block <? super Document>)System.out::println);

            /** Delete */
            System.out.println("+++++ Delete category ++++++++");
            Document searchQuery = new Document();
            searchQuery.put("category", "x");
            tasks.findOneAndDelete(searchQuery);
        }
    }
}
