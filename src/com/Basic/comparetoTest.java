package com.Basic;

public class comparetoTest {
	public static void main(String [] args){
		String s1 = "Mary"; 
		String s2 = "had"; 
		String s3 = "a"; 
		String s4 = "little"; 
		String s5 = "lamb"; 
		System.out.println( s1.compareTo(s2) );  
		System.out.println( s1.compareTo(s3) ); 
		System.out.println( s1.compareTo(s4) ); 
		System.out.println( s1.compareTo(s5) ); 
		System.out.println("s2");
		System.out.println( s2.compareTo(s3) ); 
		System.out.println( s2.compareTo(s4) ); 
		System.out.println( s2.compareTo(s5) ); 
		System.out.println("s3");
		System.out.println( s3.compareTo(s4) ); 
		System.out.println( s3.compareTo(s5) ); 
		System.out.println("s4");
		System.out.println( s4.compareTo(s5) );		
    }  
}
