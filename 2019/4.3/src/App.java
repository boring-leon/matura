import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    static ArrayList<Integer> currentSequence;
    static ArrayList<ArrayList<Integer>> sequences;

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        BufferedReader br = new BufferedReader(new FileReader("przyklad.txt"));
        String line;
        while((line = br.readLine()) != null){
            numbers.add(Integer.parseInt(line));
        }
        br.close();

        initializeIntanceLists();
        int counter = 0;

        while(counter + 1 < numbers.toArray().length){
            int a = numbers.get(counter);
            int b = numbers.get(counter + 1);

            if(getCommonDivisor(a,b) > 1) {
                if(currentSequence.toArray().length == 0){
                    currentSequence.add(a);
                }

                if(canPushNumberOnSequence(b)){
                    currentSequence.add(b);
                }
                else{
                    saveCurrentSequence();
                }
            }
            else {
                saveCurrentSequence();
            }
            counter++;
        }

        System.out.println(
                "Pierwsza liczba: " + sequences.get(0).toArray()[0] + "\n" +
                 "Długość ciągu: " +    sequences.get(0).toArray().length +  "\n" +
                "NWD: " + getCommonDivisor(sequences.get(0))

        );
    }

    private static int getCommonDivisor(int a, int b){
        return a == 0 ? b : getCommonDivisor(b % a, a);
    }

    //NWD(a,b,c) = NWD(a, NWD(b, c))
    private static int getCommonDivisor(ArrayList<Integer> numbers){
        int result = numbers.get(0);
        for(int i =0; i<numbers.toArray().length; i++){
            result = getCommonDivisor(result, numbers.get(i));
        }

        return result;
    }


    private static void saveCurrentSequence(){
        if(sequences.get(0).toArray().length <= currentSequence.toArray().length){
            sequences.remove(0);
            sequences.add(currentSequence);
        }
        currentSequence = new ArrayList<Integer>();
    }

    private static boolean canPushNumberOnSequence(int n){
        ArrayList<Integer> testSequence = new ArrayList<Integer>();
        for(Integer item : currentSequence) testSequence.add(item);
        testSequence.add(n);
        return getCommonDivisor(testSequence) > 1;
    }

    private static void initializeIntanceLists(){
        currentSequence = new ArrayList<Integer>();
        sequences = new ArrayList<ArrayList<Integer>>();
        sequences.add(currentSequence);
    }

}
