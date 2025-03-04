package org.example;

import java.util.Scanner;

public class ArmStrongNumber {

  //Method to find the number of digits
  public static int numDigits(int n) {
    int digits = 0;
    while (n > 0) {
      n = n / 10;
      digits++;
    }
    return digits;
  }

  public static boolean findArmstrong(int n) {
    // Code to print upto n Armstong numbers
    //      for (int i = 0; i < n; i++) {
    //          int digits = numDigits(i);
    //          int amsValue = 0;
    //          int temp = i;
    //          while (temp > 0) {
    //              int num = temp % 10;
    //              amsValue += (int) Math.pow(num, digits);
    //              temp = temp / 10;
    //          }
    //          if (amsValue == i) {
    //              System.out.print(i + " ");
    //          }
    //      }
    //  }
    // code to check given number is Armstong or not
    int digits = numDigits(n);
    int amsValue = 0;
    int temp = n;
    while (temp > 0) {
      int num = temp % 10;
      amsValue += (int) Math.pow(num, digits);
      temp = temp / 10;
    }
    return amsValue == n;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a number to find whether it is Armstong number or not: ");
    int n = scan.nextInt();
    if (findArmstrong(n)) {
      System.out.println("Given number " + n + " is Armstrong");
    } else {
      System.out.println("Given number " + n + " is not Armstrong");
    }
    scan.close();
  }
}
