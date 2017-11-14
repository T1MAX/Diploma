package workWithJSON;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class XmlSearch extends SimpleFileVisitor<Path> {
    ArrayList<Path> xmlFiles = new ArrayList<>();

    // ищем файлы, имя которых заканчивается на .xml, и добавляем их в список
    @Override
    public FileVisitResult visitFile (Path path, BasicFileAttributes attributes) {
        if(path.toString().endsWith(".xml"))
            xmlFiles.add(path);
        return FileVisitResult.CONTINUE;
    }
}