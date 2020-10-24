package com.company;

import java.io.*;




class FizzBuzz {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        for(int i=1; i<=n; i++){
            System.out.println(fizzBuzzHelper(i));
        }
    }

    public static String fizzBuzzHelper(int n) {
        boolean fizz = false;
        boolean buzz = false;
        boolean fizzBuzz = false;

        if(n<3){
            return String.valueOf(n);
        }

        if(n % 3 == 0){
            fizz = true;
        }
        if(n % 5 == 0){
            buzz = true;
        }
        fizzBuzz = fizz && buzz;
        if(fizzBuzz){
            return("FizzBuzz");

        }
        if(fizz){
            return("Fizz");

        }
        if(buzz){
            return ("Buzz");

        }
        return(String.valueOf(n));
    }


}

