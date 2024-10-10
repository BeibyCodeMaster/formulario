package helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUploadHelper {
   
    private static final String UPLOAD_DIR_PATH = "uploads"; 
    private static final String MAIN_DIR_PATH = System.getProperty("user.dir") + "/src/main/webapp/";
    public static final String DIR_PATH = MAIN_DIR_PATH + UPLOAD_DIR_PATH;
    	
    public static void createDirectoryIfNotExists() {
            File directory = new File(DIR_PATH);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            System.out.println("fue creado: " + created);
            if (created) {
                System.out.println("Directorio creado: " + DIR_PATH);
            } else {
                System.err.println("No se pudo crear el directorio: " + DIR_PATH);
            }
        }
    }

    public static void saveImageFromDatabase(byte[] imageData, String filePath) throws IOException {
        Files.write(new File(filePath).toPath(), imageData);
    }
}
