package com.Collections;

import java.util.*;

public class myTreeSetTest {
	public static void main(String[] args) {
		TreeSet<Student> test = new TreeSet<Student>();
		test.add(new Student("tom", 20));
		test.add(new Student("amy", 29));
		test.add(new Student("runy", 25));
		test.add(new Student("Toaster", 1234));
		test.add(new Student("henrry", 22));
		test.add(new Student("sheldon", 27));
		test.add(new Student("Widget", 4562));
		test.add(new Student("hulibal", 26));
		test.add(new Student("Modem", 9912));
		System.out.println("*********年龄正序*********\n"+test);
		

		TreeSet<Student> test2 = new TreeSet<Student>(Collections.reverseOrder());
		test2.add(new Student("tom", 20));
		test2.add(new Student("amy", 29));
		test2.add(new Student("runy", 25));
		test2.add(new Student("Toaster", 1234));
		test2.add(new Student("henrry", 22));
		test2.add(new Student("sheldon", 27));
		test2.add(new Student("Widget", 4562));
		test2.add(new Student("hulibal", 26));
		test2.add(new Student("Modem", 9912));
		System.out.println("*********年龄逆序*********\n"+test2);

		TreeSet<Student> test1 = new TreeSet<Student>(
				new Comparator<Student>() {
					public int compare(Student a, Student b) {
						return a.getName().compareTo(b.getName());
					}
				});
		test1.add(new Student("tom", 20));
		test1.add(new Student("amy", 29));
		test1.add(new Student("runy", 25));
		test1.add(new Student("Toaster", 1234));
		test1.add(new Student("henrry", 22));
		test1.add(new Student("sheldon", 27));
		test1.add(new Student("Widget", 4562));
		test1.add(new Student("hulibal", 26));
		test1.add(new Student("Modem", 9912));
		System.out.println("*********姓名正序*********\n"+test1);
		
		TreeSet<Student> test3 = new TreeSet<Student>(Collections.reverseOrder(new Comparator<Student>() {
			public int compare(Student a, Student b) {
				return a.getName().compareTo(b.getName());
			}
		}));
		test3.add(new Student("tom", 20));
		test3.add(new Student("amy", 29));
		test3.add(new Student("runy", 25));
		test3.add(new Student("Toaster", 1234));
		test3.add(new Student("henrry", 22));
		test3.add(new Student("sheldon", 27));
		test3.add(new Student("Widget", 4562));
		test3.add(new Student("hulibal", 26));
		test3.add(new Student("Modem", 9912));
		System.out.println("*********姓名逆序*********\n"+test3);
		System.out.println(test.ceiling(new Student("hulib",23)));
		System.out.println(test1.ceiling(new Student("hulib",23)));
		//test.addAll(test1);
		//System.out.println(test);
		System.out.println("*******************优先级队列****************");
		PriorityQueue<Student> testPQueue = new PriorityQueue<Student>(
				1, new Comparator<Student>() {
					public int compare(Student a, Student b) {
						return a.getName().compareTo(b.getName());
					}
				});
		testPQueue.offer(new Student("tom", 24));
		testPQueue.add(new Student("amy", 29));
		testPQueue.offer(new Student("runy", 25));
		testPQueue.add(new Student("Toaster", 1234));
		testPQueue.offer(new Student("henrry", 22));
		testPQueue.add(new Student("sheldon", 27));
		testPQueue.offer(new Student("Widget", 4562));
		testPQueue.add(new Student("hulibal", 26));
		testPQueue.offer(new Student("Modem", 9912));
		System.out.println(testPQueue);
		for(Student e : testPQueue){
			System.out.println("name"+e.getName()+"; age:"+e.getAge());
		}
		
		while(!testPQueue.isEmpty()){
			System.out.println(testPQueue.poll());
		}
	}
}
