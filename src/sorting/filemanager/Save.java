package sorting.filemanager;

import sorting.util.UtilStuff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    public static void save(String filename) throws IOException {

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {



            UtilStuff.ERRORS.forEach(s -> {
                try {
                    br.write(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
