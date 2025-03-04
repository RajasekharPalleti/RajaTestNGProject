package org.example;

import java.util.*;

public class FactorialRec {
  public static int factRec(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else {
      int fact = 1;
      fact = n * factRec(n - 1);
      return fact;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(factRec(n));
  }
}
