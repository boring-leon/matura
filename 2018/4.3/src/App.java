import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    //constat alphabet. Static because I want to be able to call it from static method getDistance
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws IOException {
        String line;
        boolean isFine; /* While firstly set's it to true, to give every line a chance to shine.
        * If it has some problem (getDistance > 10 for any  two characters of a line, than it sets it to false
        * It's later used to decide whether to print line */

        try (BufferedReader br = new BufferedReader(new FileReader("przyklad.txt"))) {

            while ((line = br.readLine()) != null){
                isFine = true;

                /* Standard loop which gives access to every two following characters in particular line.
                * If distance between them isn't greater or less than 10 (or in another words if distance
                * is greater than 10), than we have a problem
                */
                for (int i = 0; i < line.length(); i++){
                    for (int j = i + 1; j < line.length(); j++) {
                        if (getDistance(line.charAt(i), line.charAt(j)) > 10) isFine = false;
                    }
                }
                if(isFine)
                    System.out.println(line);
            }
        }
    }

    /* We need to get indexes of both passed characters in alphabet array
    * Than we use absolute value to get good distance no matter the order of characters  */
    private static int getDistance(char first, char second) {
        int firstKey = alphabet.indexOf(first);
        int secondKey = alphabet.indexOf(second);
        return Math.abs(firstKey - secondKey);
    }
}


