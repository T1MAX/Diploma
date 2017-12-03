import mongodb.*;
import org.json.JSONException;
import org.xml.sax.SAXException;
import postgres.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JSONException, TransformerException, SQLException {
        //MongoDBClass mongo = new MongoDBClass();
        //mongo.insert("contracts.zip");
        //mongo.select();

        PostgresClass postgres = new PostgresClass();
        //postgres.deleteTable("contracts");
        //postgres.createTable("contracts");

        //postgres.insert("contracts.zip");
        postgres.select();

}

}
