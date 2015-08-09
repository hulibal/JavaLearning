package com.Basic;

public class TestClass {

	public static void main(String[] args){
		try {
			// 测试Class.forName()
			@SuppressWarnings("rawtypes")
			Class testTypeForName = Class.forName("com.Collections.Student");
			System.out.println("testForName--- " + testTypeForName.getName());

			// 测试类名.class
			@SuppressWarnings("rawtypes")
			Class testTypeClass = com.Collections.Student.class;
			System.out.println("testTypeClass--- " + testTypeClass);

			// 测试Object.getClass()
			com.Collections.Student testGetClass = new com.Collections.Student();
			System.out.println("testGetClass--- " + testGetClass.getName());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class TestClassType {

	// 构造函数
	public TestClassType() {
		System.out.println("----构造函数---");
	}

	// 静态的参数初始化
	static {
		System.out.println("---静态的参数初始化---");
	}

	// 非静态的参数初始化
	{
		System.out.println("----非静态的参数初始化---");
	}
}
