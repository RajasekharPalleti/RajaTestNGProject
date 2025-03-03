package org.example;

public class MissingNumber {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,8,9};
        int n = arr.length;
        int totalSum = (n+1) * (n+2) / 2;
        int sum = 0;
        for (int num:arr){
            sum = sum+num;
        }
        int missingNum = totalSum-sum;
        System.out.println("Missing number is : "+missingNum);
    }
}
