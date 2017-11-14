package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONException;
import org.xml.sax.SAXException;
import workWithJSON.MyJSONParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MongoDBClass {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDBClass() {
        client = new MongoClient("localhost", 27017);
        database = client.getDatabase("zakupki");
        collection = database.getCollection("contracts");
    }

    public void insert(String path) throws ParserConfigurationException, TransformerException, SAXException, IOException, JSONException {
        long startTime = System.nanoTime();
        for (JSONArray contracts: MyJSONParser.parseJSON(path)) {
            for (int i = 0; i < contracts.length(); i++) {
                collection.insertOne(Document.parse(contracts.getJSONObject(i).toString()));
            }
        }
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println(estimatedTime + " nanoseconds, " + collection.count() + " inserts");
    }

    public void select() {
        long startTime = System.nanoTime();
        Bson filter = Filters.lt("oos:price", 100000);
        List<Document> all = collection.find(filter).into(new ArrayList<>());
        long estimatedTime = System.nanoTime() - startTime;
        System.out.printf("%d contracts with price less than 100000 RUB, time for select: %d.%n", all.size(), estimatedTime);
    }
}
