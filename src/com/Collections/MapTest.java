package com.Collections;

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class MapTest
{
   public static void main(String[] args)
   {
      Map<String, Employee> staff = new HashMap<>();
      staff.put("144-25-5464", new Employee("Amy Lee"));
      staff.put("567-24-2546", new Employee("Harry Hacker"));
      staff.put("157-62-7935", new Employee("Gary Cooper"));
      staff.put("456-62-5527", new Employee("Francesca Cruz"));

      // print all entries

      System.out.println(staff);

      // remove an entry

      staff.remove("567-24-2546");

      // replace an entry

      staff.put("456-62-5527", new Employee("Francesca Miller"));

      // look up a value

      System.out.println(staff.get("456-62-5527"));

      // iterate through all entries
      
      System.out.println("Öµ¼¯ºÏ");
	  Collection<Employee> values = staff.values();
	  for(Employee E : values){
		  System.out.println(E);
	  }
	  System.out.println();
	  System.out.println(staff.get("456-62-5527"));
      
      Set<Map.Entry<String, Employee>> entrySet = staff.entrySet();
      Iterator<Map.Entry<String, Employee>> iter = entrySet.iterator();
      while(iter.hasNext()){
    	  Map.Entry<String,Employee> temp = iter.next();
    	  String key = temp.getKey();    	  
          Employee value = temp.getValue();
          if(key.equals("144-25-5464"))
        	  iter.remove();
          System.out.println("key=" + key + ", value=" + value);
      }
      System.out.println();

      for (Map.Entry<String, Employee> entry : entrySet)
      {
         String key = entry.getKey();
         Employee value = entry.getValue();
         System.out.println("key=" + key + ", value=" + value);
      }
   }
}

