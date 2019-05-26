package com.company;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {

        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        else if(dividend==Integer.MIN_VALUE && divisor==1){
            return Integer.MIN_VALUE;
        }

        int acc = 0, quotient = 0;
        int unsignedDivisor= divisor, unsignedDividend=dividend;
        if(dividend<0){
            unsignedDividend = -dividend;
        }
        if(divisor<0){
            unsignedDivisor = -divisor;
        }

        int sign = 1;
        if(dividend<0 && divisor <0){
            sign = 1;
        }
        else if(dividend<0||divisor<0){
            sign = -1;
        }

        while (true){
            if(unsignedDivisor>unsignedDividend) {
                return 0;
            }
            acc += unsignedDivisor;
            if(acc>=unsignedDividend) {
                if (acc == unsignedDividend) {
                    quotient++;
                }
                return sign < 0 ? -quotient : quotient;
            }
            quotient++;
        }
    }
}

