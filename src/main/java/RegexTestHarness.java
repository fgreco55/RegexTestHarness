import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 Simple app to test Regex in Java.
    adapted from Oracle example.  I used Scanner and extended to read files. -fgreco
 */
public class RegexTestHarness {

    public static void main(String[] args){
        Scanner console;
        String target;
      
        while (true) {
            console = new Scanner(System.in);

            System.out.print("Enter regex: ");
            Pattern ipattern = Pattern.compile(console.nextLine());

            System.out.print("(F)ile or (S)tring: ");

            if (console.nextLine().equalsIgnoreCase("F"))  {
                System.out.print("Enter filename to search: ");             // File
                                                                            // note current dir is RegexTestHarness
                FileString fs = new FileString(console.nextLine());
                target = fs.getFileAsString();
            } else {                                                        // any other char -> ask for a string
                System.out.print("Enter input string to search: ");         // String
                target = console.nextLine();
            }

            Matcher matcher = ipattern.matcher(target);

            boolean found = false;
            while ( matcher.find() ) {

                if (matcher.group().equals(""))
                    break;

                System.out.printf("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
                    matcher.group(), matcher.start(), matcher.end());
                found = true;
            }

            if( !found ) {
                System.out.printf("No match found.%n");
            }
        }
    }
}
