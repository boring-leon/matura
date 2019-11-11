package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("liczby.txt"))) {
            String line;
            int counter = 0;

            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                if(isPowerOfThree(number)) counter++;
            }
            System.out.println(counter);
        }
    }

    private static boolean isPowerOfThree(int n){
        boolean isPower = true;
        do{
            if(n % 3 == 0) n/= 3;
            else{
                isPower = false;
                break;
            }
        }while(n > 3);

        return isPower;
    }
}
