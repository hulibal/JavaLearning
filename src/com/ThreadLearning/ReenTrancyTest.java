package com.ThreadLearning;

import java.util.ArrayList;

public class ReenTrancyTest {
	static public int i = 0;
	public int ii = 0;

	public ReenTrancyTest() {
		super();
	}

	public static void main(String[] args) {
		int totalNumOfThread = 20; // 有20个线程同时执行
		ReenTrancyTest lw = new ReenTrancyTest(); // 每个线程都关联同一个LoggingWidget对象
		ArrayList<outer> o = new ArrayList<outer>();
		for (int s = 0; s < totalNumOfThread; s++) // 为20个线程赋值同一个LoggingWidget对象的引用
		{
			outer t = new outer();
			t.lw = lw;
			o.add(t);
		}
		for (int s = 0; s < totalNumOfThread; s++) {
			((outer) o.get(s)).start(); // 启动20个线程
		}
	}

	public synchronized void doSomething() { // 注意，这里没有给方法synchronized属性
		int sleep = (int) (Math.random() * 500); // 随机产生一个睡眠时间
		try {
			Thread.sleep(sleep); // 睡眠
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ii = i++; // 为每个线程赋予一个ID，ID自增
		try {
			Thread.sleep(sleep); // 继续睡眠
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ii + "线程执行LoggingWidget->doSomething(),睡眠时间："
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
