package workWithJSON;


import org.json.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MyJSONParser {
    public static List<JSONArray> parseJSON(String path) throws IOException, JSONException {
        List<JSONArray> listOfContracts = new ArrayList<>();
        long startTime = System.nanoTime();
        try {
            List<Path> xmlFiles = ZipReader.readZip(path);
            for (Path xmlFile: xmlFiles) {
                byte[] bytes = Files.readAllBytes(xmlFile);
                String content = new String(bytes, "utf-8");
                JSONObject json = XML.toJSONObject(content);
                listOfContracts.add(json.getJSONObject("export").getJSONArray("contract"));
            }
            long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long estimatedTime = System.nanoTime() - startTime;
            System.out.printf("Time of parsing: %d.%n, used memory: %d.%n", estimatedTime, usedBytes);
        } catch (Error e) {
            e.printStackTrace();
        } finally {
            long time = System.nanoTime() - startTime;
            System.out.printf("%d xml-files were written, time of parsing: %d.%n", listOfContracts.size(), time);
            return listOfContracts;
        }


    }
}
