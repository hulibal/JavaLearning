package com.ThreadLearning;

import java.util.ArrayList;

public class ReenTrancyTest {
	static public int i = 0;
	public int ii = 0;

	public ReenTrancyTest() {
		super();
	}

	public static void main(String[] args) {
		int totalNumOfThread = 20; // ��20���߳�ͬʱִ��
		ReenTrancyTest lw = new ReenTrancyTest(); // ÿ���̶߳�����ͬһ��LoggingWidget����
		ArrayList<outer> o = new ArrayList<outer>();
		for (int s = 0; s < totalNumOfThread; s++) // Ϊ20���̸߳�ֵͬһ��LoggingWidget���������
		{
			outer t = new outer();
			t.lw = lw;
			o.add(t);
		}
		for (int s = 0; s < totalNumOfThread; s++) {
			((outer) o.get(s)).start(); // ����20���߳�
		}
	}

	public synchronized void doSomething() { // ע�⣬����û�и�����synchronized����
		int sleep = (int) (Math.random() * 500); // �������һ��˯��ʱ��
		try {
			Thread.sleep(sleep); // ˯��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ii = i++; // Ϊÿ���̸߳���һ��ID��ID����
		try {
			Thread.sleep(sleep); // ����˯��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ii + "�߳�ִ��LoggingWidget->doSomething(),˯��ʱ�䣺"
				+ sleep);
	}
}

class outer extends Thread {
	public ReenTrancyTest lw;

	public outer() {
		super();
	}

	@Override
	public void run() {
		lw.doSomething();
		super.run();
	}
}
