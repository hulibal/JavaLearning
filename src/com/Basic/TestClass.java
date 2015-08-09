package com.Basic;

public class TestClass {

	public static void main(String[] args){
		try {
			// ����Class.forName()
			@SuppressWarnings("rawtypes")
			Class testTypeForName = Class.forName("com.Collections.Student");
			System.out.println("testForName--- " + testTypeForName.getName());

			// ��������.class
			@SuppressWarnings("rawtypes")
			Class testTypeClass = com.Collections.Student.class;
			System.out.println("testTypeClass--- " + testTypeClass);

			// ����Object.getClass()
			com.Collections.Student testGetClass = new com.Collections.Student();
			System.out.println("testGetClass--- " + testGetClass.getName());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class TestClassType {

	// ���캯��
	public TestClassType() {
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
}
