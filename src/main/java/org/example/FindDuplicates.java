package org.example;

import java.util.HashSet;

public class FindDuplicates {
  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 3, 5, 6, 7, 8, 2, 4, 6, 8};

    HashSet<Integer> uniques = new HashSet<>();
    HashSet<Integer> duplicates = new HashSet<>();

    for (int num : arr) {
      if (uniques.contains(num)) {
        duplicates.add(num);
      } else {
        uniques.add(num);
      }
    }
    if (duplicates.isEmpty()) {
      System.out.println("No Duplicates Found");
    } else {
      System.out.println("Duplicates found: " + duplicates);
    }
  }
}
