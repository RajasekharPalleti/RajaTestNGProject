package org.example;

import java.util.*;

public class CheckPrime {
  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    } else {
      for (int i = 2; i <= n / 2; i++) {
        if (n % i == 0) {
          return false;
        }
      }
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (isPrime(n)) {
      System.out.println("is Prime");
    } else {
      System.out.println("is not Prime");
    }
  }
}
