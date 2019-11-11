import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("przyklad.txt"))) {
            String line;
            int wordNumber =0;

            while ((line = br.readLine()) != null) {
                wordNumber++;
                if(wordNumber==40){
                    sb.append(line.charAt(9));
                    wordNumber=0;
                }
            }
        }

    System.out.println(sb.toString());
    }
}
