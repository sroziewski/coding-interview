package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        List<Integer> split1 = Arrays.stream(version1.split("\\.")).map(getStringIntegerFunction()).collect(Collectors.toList());
        List<Integer> split2 = Arrays.stream(version2.split("\\.")).map(getStringIntegerFunction()).collect(Collectors.toList());

        int minSize = Math.min(split1.size(), split2.size());

        for(int i=0; i<minSize; i++){
            if(split1.get(i)<split2.get(i))
                return -1;
            if(split1.get(i)>split2.get(i))
                return 1;
        }

        if(split1.size() < split2.size() ){
            Optional<Integer> sum = split2.subList(split1.size(), split2.size()).stream().reduce(Integer::sum);
            if(sum.get()==0){
                return 0;
            }
            return -1;
        }
        else if(split1.size() > split2.size() ){
            Optional<Integer> sum = split1.subList(split2.size(), split1.size()).stream().reduce(Integer::sum);
            if(sum.get()==0){
                return 0;
            }
            return 1;
        }
        return 0;
    }

    private static Function<String, Integer> getStringIntegerFunction() {
        return w -> {
            if (w.matches("[0]+")) {
                return 0;
            }
            return Integer.valueOf(w.replaceAll("^[0]", ""));
        };
    }

    public static void main(String[] args) {
        int i = compareVersion("1.0010.1", "1");
    }

}
