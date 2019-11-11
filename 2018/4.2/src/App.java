import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {

        String line;

        int generalLettersNumber, sameLettersNumber, differentLettersNumber;

        int prevDifferentLettersNumber, max = 0;

        String wantedWord = "";

        try (BufferedReader br = new BufferedReader(new FileReader("przyklad.txt"))) {

            while ((line = br.readLine()) != null) {

                generalLettersNumber = 0; sameLettersNumber = 0; differentLettersNumber = 0;

                prevDifferentLettersNumber = differentLettersNumber;

                generalLettersNumber = line.length();

                //checking for the same letters in one word
                for (int i = 0; i < generalLettersNumber; i++) {
                    for (int j = i + 1; j < generalLettersNumber; j++) {
                        if (line.charAt(i) == line.charAt(j))
                            sameLettersNumber++;
                    }
                }
                differentLettersNumber = generalLettersNumber - sameLettersNumber;

                //bubble sorting to find the greatest value
                if (differentLettersNumber > prevDifferentLettersNumber && differentLettersNumber > max) {
                    max = differentLettersNumber;
                    wantedWord = line;
                }
            }
        }
        System.out.println(wantedWord + " " + max);
    }
}
