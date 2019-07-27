package main.db;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class DB {
  public DB() {

    MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://ithsUser:<ithsPassword>@iths-ygc8w.mongodb.net/test?retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("iths");

    for (String collectionName : database.listCollectionNames()) {
      System.out.println(collectionName);
    }

  }


//  public static void populateContactBook() {
//    /*
//        mongodb+srv://ithsUser:<ithsPassword>@iths-ygc8w.mongodb.net/test?retryWrites=true&w=majority
//     */
//  }
//
//
//
//  static MongoClient mongoClient = new MongoClient();
//  //connect to test database
//  static MongoDatabase database;
//  static {
//    // Make the logger a little more quiet
//    Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
//    mongoLogger.setLevel(Level.SEVERE);
//
//    // Create and get the database 'test001'
//    System.out.println("===================================");
//    System.out.println("Get the database 'test001'...");
//    database = mongoClient.getDatabase("test001");
//  }
//
//  // This method lists all databases
//  static void listDatabases() {
//    System.out.println("===================================");
//    System.out.println("names of all databases:");
//    //show databases:
//    mongoClient.getDatabaseNames().forEach(System.out::println);
//  }
//
//  // This method lists all collection names in the current database:
//  static void listCollectionNames() {
//    for(String collectionName : database.listCollectionNames()) {
//      System.out.println(collectionName);
//    }
//  }
//
//  // Create collection named 'customers'
//  static void createCustomers() {
//    MongoCollection<Document> collection = database.getCollection("customers");
//    collection.insertOne(new Document());
//  }
//
//  static void dropCustomers() {
//    MongoCollection<Document> collection = database.getCollection("customers");
//    collection.drop();
//    collection = database.getCollection("customers");
//  }
//
//  static void hr() {
//    System.out.println("===================================");
//  }
//
//  static void createAndInsertCustomers() {
//    MongoCollection<Document> collection = database.getCollection("customers");
//    List<Document> document = asList(
//            new Document ("name", "Eva")
//                    .append("email", "eva@email.com")
//                    .append("customerId", 100),
//
//            new Document("name", "Patrik")
//                    .append("email","patrik@email.com")
//                    .append("customerId", 101));
//    collection.insertMany(document);
//  }
//
//  static void printCustomers() {
//    MongoCollection<Document> collection = database.getCollection("customers");
//    List<Document>result = collection.find().into(new ArrayList<>());
//    result.stream().map(Document::toJson).forEach(System.out::println);
//    /* OLD Style Java:
//    for (Document doc : result) {
//      System.out.println(doc.toJson());
//    }
//    */
//  }
//
//  static void findAndPrintEva() {
//    MongoCollection<Document> collection = database.getCollection("customers");
//    List<Document> result = collection.find(new Document("name", "Eva")).into(new ArrayList<>());
//    System.out.println(result);
//  }
//
//  static void updateEva() {
//    MongoCollection<Document> collection = database.getCollection("customers");
//    BasicDBObject newDocument = new BasicDBObject();
//    newDocument.append("$set", new BasicDBObject().append("email", "eva@mail.org"));
//    BasicDBObject query = new BasicDBObject().append("name","Eva");
//    collection.updateOne(query, newDocument);
//  }
//
//  static void updatePatrik() {
//    MongoCollection<Document> collection = database.getCollection("customers");
//    BasicDBObject updateQuery = new BasicDBObject();
//    updateQuery.append("$inc", new BasicDBObject().append("customerId", 10));
//    BasicDBObject searchQuery = new BasicDBObject().append("name","Patrik");
//    collection.updateOne(searchQuery, updateQuery);
//  }

  /* Main method
   *
   */
  public static void main(String[] args) {

//        listDatabases();
//        hr(); // write a horizontal ruler
//        System.out.println("All collections:");
//        listCollectionNames();
//        hr();
//        System.out.println("Create new collection, 'custemers'.");
//        createCustomers();
//        System.out.println("All collections:");
//        listCollectionNames();
//        hr();
//        System.out.println("Drop collection customers");
//        dropCustomers();
//        hr();
//        System.out.println("All collections:");
//        listCollectionNames();
//        hr();
//        System.out.println("Create customers, and insert some documents");
//        hr();
//        createAndInsertCustomers();
//        hr();
//        System.out.println("Print documents in customers");
//        printCustomers();
//        hr();
//        System.out.println("Update the email of 'Eva' to 'eva@mail.org'");
//        updateEva();
//        hr();
//        System.out.println("Print documents in customers");
//        printCustomers();
//        hr();
//        System.out.println("Update Patrik, increment customer id with 10");
//        updatePatrik();
//        hr();
//        printCustomers();
//        hr();
//        listDatabases();
//        hr();
//        findAndPrintEva();
//        hr();

    DB db = new DB();
  }
}
