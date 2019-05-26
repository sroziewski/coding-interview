package com.company;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String xString = String.valueOf(x);
        int size = xString.length()/2;
        for (int i = 0; i < size; i++) {
            if(xString.charAt(i)!=xString.charAt(xString.length()-(i+1)))
                return false;
        }
        return true;
    }
}

