package org.example;

import java.util.Arrays;
import java.util.List;

public class EvenUsingStreams{
    public static void main(String[] args){
        Integer[] arrayOfNums = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> number = Arrays.asList(arrayOfNums);
        number.stream().filter(n -> n%2 == 0).forEach(n -> System.out.print(n + " "));

    }
}