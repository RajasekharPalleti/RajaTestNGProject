package org.example;
import java.util.Scanner;
import java.util.HashMap;

public class CharacterCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();

        str = str.replaceAll(" ", "");

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char ch: str.toCharArray()){
            if (charCount.containsKey(ch)){
                int currentCount = charCount.get(ch);
                charCount.put(ch, currentCount+1);
            }else{
                charCount.put(ch, 1);
            }
        }
        System.out.println("Character   count"+ charCount);
    }
}
