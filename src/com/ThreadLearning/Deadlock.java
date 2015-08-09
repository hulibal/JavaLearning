package com.ThreadLearning;

public class Deadlock {
	private String objID;

	public Deadlock(String id) {
		objID = id;
	}

	public synchronized void checkOther(Deadlock other) {
		print("["+Thread.currentThread().getName()+"]:进入 checkOther()");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException x) {
//		}
		print("["+Thread.currentThread().getName()+"]:在checkOther()中激活other.action()");

		// 调用other对象的action方法，由于该方法是同步方法，因此会试图获取other对象的对象锁
		other.action();
		print("["+Thread.currentThread().getName()+"]:离开checkOther()");
	}

	public synchronized void action() {
		print("["+Thread.currentThread().getName()+"]:进入action()");
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException x) {
//		}
		print("["+Thread.currentThread().getName()+"]:离开action()");
	}

	public void print(String msg) {
		threadPrint("objID=" + objID + " - " + msg);
	}

	public static void threadPrint(String msg) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + msg);
	}

	public static void main(String[] args) {
		final Deadlock obj1 = new Deadlock("obj1");
		final Deadlock obj2 = new Deadlock("obj2");

		Runnable runA = new Runnable() {
			public void run() {
				obj1.checkOther(obj2);
			}
		};

		Runnable runB = new Runnable() {
			public void run() {
				obj2.checkOther(obj1);
			}
		};
		
		Thread threadA = new Thread(runA, "threadA");
		threadA.start();

//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException x) {
//		}


		Thread threadB = new Thread(runB, "threadB");
		threadB.start();

//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException x) {
//		}

		threadPrint("finished sleeping");

		threadPrint("about to interrupt() threadA");
		threadA.interrupt();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException x) {
		}

		threadPrint("about to interrupt() threadB");
		threadB.interrupt();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException x) {
		}

		threadPrint("did that break the deadlock?");
	}
}
