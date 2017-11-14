import mongodb.*;
import org.json.JSONException;
import org.xml.sax.SAXException;
import postgres.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JSONException, TransformerException {
        MongoDBClass mongo = new MongoDBClass();
        mongo.insert("contracts.zip");

        mongo.select();
    }

}
