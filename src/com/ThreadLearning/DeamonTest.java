package com.ThreadLearning;

public class DeamonTest {

	public static void main(String[] args) {
		Thread t1 = new MyCommon("普通线程");
		Thread t2 = new Thread(new MyDaemon(),"守护进程");
		t2.setDaemon(true); // 设置为守护线程

		t2.start();
		t1.start();
	}
}

class MyCommon extends Thread {
	public MyCommon(String name){
		super(name);
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("["+Thread.currentThread().getName()+"]第" + i + "次执行！");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyDaemon implements Runnable {
	public void run() {
		for (long i = 0; i < 9999999L; i++) {
			System.out.println("["+Thread.currentThread().getName()+"]第" + i + "次执行！");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}