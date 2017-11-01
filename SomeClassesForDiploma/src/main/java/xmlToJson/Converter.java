package xmlToJson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;


public class Converter {
    private static String testXML;

    static void recieveXML(String filePath) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filePath));
        DOMSource domSource = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(domSource, result);
        testXML = writer.toString();
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        try {
            Converter.recieveXML("D:\\Загрузки\\contract.xml");
            JSONObject xmlJSONObj = XML.toJSONObject(testXML);
            String jsonPrettyPrintString = xmlJSONObj.toString(4);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }
}
