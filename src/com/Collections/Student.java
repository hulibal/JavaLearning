package com.Collections;

import java.util.Objects;

public class Student implements Comparable<Student> {
	private String name;
	private int age;

	// ���캯��
	public Student() {
		System.out.println("----���캯��---");
	}

	// ��̬�Ĳ�����ʼ��
	static {
		System.out.println("---��̬�Ĳ�����ʼ��---");
	}

	// �Ǿ�̬�Ĳ�����ʼ��
	{
		System.out.println("----�Ǿ�̬�Ĳ�����ʼ��---");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int hashCode() {
		return Objects.hash(this.name, this.age);
	}

	public String toString() {
		return "\nname:" + this.name + "; age:" + this.age;
	}

	public boolean equals(Student other) {
		return (this.name.equals(other.name)) && (this.age == other.age);
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
}
