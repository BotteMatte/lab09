package it.unibo.mvc;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";

    private File currentFile = new File(HOME + File.separator + DEFAULT_FILE);

    /*public Controller() {
        String userHome = System.getProperty("user.home") + File.separator;
        currentFile = new File(userHome, "output.txt");
    }*/


    public void setCurrentFile(File file) {
        final File parent = file.getParentFile();
        if(parent.exists()){
            currentFile = file;
        } else {
            throw new IllegalArgumentException("non puoi salvare su una cartella che non esiste")
        }
    }


    public File getCurrentFile() {
        return currentFile;
    }


    public String getPath(File file) {
        return file.getAbsolutePath();
    }


    public void saveContentToFile(String content) throws IOException {
        if (currentFile == null) {
            throw new IllegalStateException("No current file set.");
        }


        try (PrintStream ps = new PrintStream(currentFile , StandardCharsets.UTF_8)) {
            ps.println(content);
        } catch (IOException e) {
            throw new IOException("Error wring on file: " + currentFile.getAbsolutePath(), e);
        }


    }
}
