package myParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class XmlSearch extends SimpleFileVisitor<Path> {
    private List<JSONArray> contracts = new ArrayList<>();

    @Override
    public FileVisitResult visitFile (Path path, BasicFileAttributes attributes) throws IOException {
        if(path.toString().endsWith(".xml")) {
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes, "utf-8");
            JSONObject json;
            try {
                json = XML.toJSONObject(content);
                if (json.has("export") && json.getJSONObject("export").has("contract"))
                    contracts.add(json.getJSONObject("export").getJSONArray("contract"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public List<JSONArray> getContracts() {
        return contracts;
    }
}