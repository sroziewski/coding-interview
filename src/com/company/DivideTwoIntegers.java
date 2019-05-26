package com.company;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {

        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        else if(dividend==Integer.MIN_VALUE && divisor==1){
            return Integer.MIN_VALUE;
        }

        int quotient = 0;
        int unsignedDivisor= divisor, unsignedDividend=dividend;
        int add = 0;
        if(dividend==Integer.MIN_VALUE){
            unsignedDividend = Integer.MAX_VALUE;
            add++;
        }
        else if(dividend<0){
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
        if(unsignedDivisor>unsignedDividend) {
            return 0;
        }
        while (unsignedDividend>=unsignedDivisor){
            unsignedDividend -= unsignedDivisor;
            quotient++;
        }
        quotient+=add;
        return sign < 0 ? -quotient : quotient;
    }
}

