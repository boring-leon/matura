import java.io.*;

public class App {

    private final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static int KEY = 107;
    private final static int DISTANCE = KEY % alphabet.length();

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("dane_6_1.txt"))) {

            FileWriter fileWriter = new FileWriter(new File("wyniki_6_1.txt"));
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String line;
            while ((line = br.readLine()) != null) {

                StringBuilder encryptedWord = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    encryptedWord.append(getCharAfterMoving(line.charAt(i)));
                }

                printWriter.println(encryptedWord.toString());

            }
            printWriter.close();
        }
    }

    private static char getCharAfterMoving(char baseChar){

        int newCharIndex = alphabet.indexOf(baseChar) + DISTANCE;

        if(newCharIndex>=alphabet.length()){
            newCharIndex -= alphabet.length();
        }
        return alphabet.charAt(newCharIndex);
    }

}