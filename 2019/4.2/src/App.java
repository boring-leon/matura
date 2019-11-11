import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader( new FileReader("liczby.txt"))){
            String line;
            while((line = br.readLine()) != null){
                int number = Integer.parseInt(line);
                if(getFactorialsSum(line) == number) System.out.println(number);
            }
        }
    }

    private static int getFactorial(int n){
        int factorial = n;
        for(int i=1; i<n; i++) factorial *= i;
        return factorial;
    }

    private static int getFactorialsSum(String s){
        int factorialsSum = 0;
        for(int i=0; i<s.length(); i++){
            factorialsSum+= getFactorial(Character.getNumericValue(s.charAt(i)));
        }
        return factorialsSum;
    }
}
