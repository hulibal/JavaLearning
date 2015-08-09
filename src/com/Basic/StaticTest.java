package com.Basic;

public class StaticTest {
	static int a;
	static void test(){
		System.out.println("test static method!");
	}
	static{
		System.out.println("test static code");
		System.out.println(a);test();
	}
	public static void main(String args[]){
		System.out.println(a);
		StaticTest.test();
		int a = 10;
		Integer b = new Integer(20);
		Integer c = Integer.valueOf(a);
		System.out.println(++a);
		System.out.println(b.intValue());
		System.out.println(c.intValue());
		
	}
}
