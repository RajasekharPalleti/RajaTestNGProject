package org.example;

import java.util.*;

public class ReverseStringSB{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        StringBuilder sb = new StringBuilder(inputString);
        String outputString = sb.reverse().toString();
        System.out.println(outputString);
    }

}
