package com.Collections;

import java.util.*;

/**
 * This program demonstrates operations on linked lists.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class LinkedListTest
{
   public static void main(String[] args)
   {
      List<String> a = new LinkedList<>();
      a.add("A");
      a.add("B");
      //a.add("C");

      List<String> b = new LinkedList<>();
      b.add("D");
      b.add("E");
      b.add("O");
      b.add("G");
      b.set(2, "F");

      System.out.println(b);
      // merge the words from b into a

      ListIterator<String> aIter = a.listIterator();
      Iterator<String> bIter = b.iterator();

      while (bIter.hasNext())
      {
         if (aIter.hasNext()) 
        	 aIter.next();
         else
        	 aIter.previous();
         System.out.println(aIter.nextIndex());
         aIter.add(bIter.next());
      }

      System.out.println(a);

      // remove every second word from b

      bIter = b.iterator();
      while (bIter.hasNext())
      {
         bIter.next(); // skip one element
         if (bIter.hasNext())
         {
            bIter.next(); // skip next element
            bIter.remove(); // remove that element
         }
      }

      System.out.println(b);

      // bulk operation: remove all words in b from a

      a.removeAll(b);

      System.out.println(a);
   }
}
