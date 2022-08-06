package sorting.filemanager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Load {


    public static List<String> load(String fileName, InputStream a)  {
        List<String> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(fileName)) {
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        }

        return list;
    }
}
