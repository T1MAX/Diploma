package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.xml.sax.SAXException;
import xmlToJson.Converter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;


public class MongoDBClass {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("newTest");
        MongoCollection<org.bson.Document> collection = database.getCollection("testCollection");


        String json = Converter.convert("D:\\Загрузки\\contract.xml");
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            collection.insertOne(Document.parse(json));
        }
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println(estimatedTime + " nanoseconds");

    }
}
