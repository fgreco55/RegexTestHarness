import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args){
        Scanner console;
      
        while (true) {
            console = new Scanner(System.in);

            System.out.print("Enter regex: ");
            Pattern ipattern = Pattern.compile(console.nextLine());

            System.out.print("Enter input string to search: ");
            Matcher matcher = ipattern.matcher(console.nextLine());

            boolean found = false;
            while ( matcher.find() ) {
                if (matcher.group() == "")
                    break;
                System.out.printf("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if( !found ) {
                System.out.printf("No match found.%n");
            }
        }
    }
}
