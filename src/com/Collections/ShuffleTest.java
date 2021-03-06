package com.Collections;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class ShuffleTest
{
   public static void main(String[] args)
   {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= 49; i++)
         numbers.add(i);
      System.out.println(numbers);
      Collections.shuffle(numbers);
      System.out.println(numbers);
      List<Integer> winningCombination = numbers.subList(0, 6);
      Collections.sort(winningCombination);
      System.out.println(winningCombination);
      Collections.reverse(winningCombination);
      System.out.println(winningCombination);
   }
}
