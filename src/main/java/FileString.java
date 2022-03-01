import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileString {
    private String filename;
    private String asString;

    FileString(String fname) {
        this.filename = fname;
    }

    public String getFileAsString() {
        asString = "";            // initialize to empty string

        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                asString += sc.nextLine();
            }
        } catch (IOException iox) {
            System.err.println("Cannot open file.  [" + iox.getMessage() + "]");
        }
        return asString;
    }

    public String getFilename() {
        return this.filename;
    }

    /*
     Test this class
     */
    public static void main(String[] args) {
        FileString fs = new FileString("src/main/java/FileString.java");
        System.out.println(fs.getFileAsString());
    }
}
