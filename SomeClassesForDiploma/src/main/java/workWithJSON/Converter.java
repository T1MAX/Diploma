package workWithJSON;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;


public class Converter {
    private static String testXML;

    private static void recieveXML(String filePath) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filePath));
        DOMSource domSource = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(domSource, result);
        testXML = writer.toString();
    }

    public static JSONObject convert(String filePath) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        try {
            Converter.recieveXML(filePath);
            return XML.toJSONObject(testXML);
        } catch (JSONException je) {
            System.out.println(je.toString());
            return new JSONObject();
        }
    }

    // тут я пытался написать метод, разбивающий xml на части
//    public sfd() throws FileNotFoundException, XMLStreamException, TransformerException {
//        XMLInputFactory xif = XMLInputFactory.newInstance();
//        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("input.xml"));
//        xsr.nextTag(); // Advance to statements element
//
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer t = tf.newTransformer();
//        while(xsr.nextTag() == XMLStreamConstants.START_ELEMENT) {
//            File file = new File("out/" + xsr.getAttributeValue(null, "account") + ".xml");
//            t.transform(new StAXSource(xsr), new StreamResult(file));
//        }
//    }
}
