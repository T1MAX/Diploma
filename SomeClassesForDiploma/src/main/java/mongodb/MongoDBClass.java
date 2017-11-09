package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.xml.sax.SAXException;
import workWithJSON.MyJSONParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;


public class MongoDBClass {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException, JSONException {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("Test");
        MongoCollection<org.bson.Document> collection = database.getCollection("testCollection");


        MyJSONParser parser = new MyJSONParser("contract.xml");
        JSONArray contracts = parser.getContracts();
        long startTime = System.nanoTime();
        for (int i = 0; i < contracts.length(); i++) {
            collection.insertOne(Document.parse(contracts.getJSONObject(i).toString()));
        }
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println(estimatedTime + " nanoseconds, " + contracts.length() + " inserts");

    }
}
