package workWithJSON;


import org.json.JSONArray;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipReader {

    public static JSONArray readZip(String pathZipFile) throws IOException {
        FileSystem zipFileSystem = createZipFileSystem(pathZipFile);
        Path root = zipFileSystem.getPath("/");
        XmlSearch xmlSearch = new XmlSearch();
        Files.walkFileTree(root, xmlSearch);
        return xmlSearch.getContracts();
    }

    private static FileSystem createZipFileSystem (String path) throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        URI uri = URI.create("jar:file:" + Paths.get(path).toUri().getPath());
        return FileSystems.newFileSystem(uri, env);
    }

}

