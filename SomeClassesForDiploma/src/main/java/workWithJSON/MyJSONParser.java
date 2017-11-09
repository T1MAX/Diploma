package workWithJSON;


import org.json.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class MyJSONParser {
    private JSONObject json;
    private JSONArray contracts;

    public MyJSONParser(String pathToXML) throws ParserConfigurationException, TransformerException, SAXException, IOException, JSONException {
        this.json = Converter.convert(pathToXML);
        this.contracts = new JSONArray();
        System.out.println(json.toString(1));
    }

    MyJSONParser(String pathToJSON, int i) throws JSONException {
        this.json = new JSONObject(pathToJSON);
        this.contracts = new JSONArray();
    }

    public JSONArray getContracts() throws JSONException {
        this.contracts = json.getJSONArray("contract");
        return contracts;
    }

}
