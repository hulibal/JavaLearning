package com.Basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arryTest {
 public static void main(String args []){
	 
	 int[][] arry  = new int[3][];
	 arry[0]=new int []{2,4};
	 arry[1]=new int [1];
	 arry[1][0]= 3;
	 arry[2]=new int []{5,7,9};	
	 for(int[] a : arry){
		 for(int b : a){
			 System.out.print(b+" ");
		 }
		 System.out.print("\n");
	 }
	 
	 List<String> l = new ArrayList<String>();
	 l.add("aa");
	 l.add("bb");
	 l.add("cc");
	 for (Iterator<String> iter = l.iterator(); iter.hasNext();) {
	  String str = (String)iter.next();
	  
	  System.out.println(str);
	 }
	 
	 for(String str:l){
		 System.out.println(str);
	 }
	 //迭代器用于while循环
	 Iterator<String> iter = l.iterator();
	 while(iter.hasNext()){
	  String str = (String) iter.next();
	  System.out.println(str);
	 }
 }
}
