package com.ThreadLearning;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();

		for (int i = 0; i < 3; i++) {
			new Thread("RThread-"+i) {
				public void run() {
					while (true) {
						q3.get();
					}
				}
			}.start();

			new Thread("WThread-"+i) {
				public void run() {
					while (true) {
						// ����һ��dataֵ
						q3.put(new Random().nextInt(10000));
					}
				}
			}.start();
		}
	}
}

class Queue3 {

	private Object data = null;// ���픵����ֻ����һ���߳���д�����ݣ����ж���߳��ܶ�������
	private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

	public void get() {
		rw1.readLock().lock();
		try {
			System.out.println("[" + Thread.currentThread().getName()
					+ "]������!");
			Thread.sleep((long) (Math.random() * 1000));
			System.out.println("["+Thread.currentThread().getName()
					+ "]��ȡ����: " + data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rw1.readLock().unlock();
		}
	}

	public void put(Object data) {
		rw1.writeLock().lock();
		try {
			System.out.println("[" + Thread.currentThread().getName()
					+ "]д����!");
			Thread.sleep((long) (Math.random() * 1000));
			this.data = data;
			System.out.println("["+Thread.currentThread().getName()
					+ "]д������: " + data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rw1.writeLock().unlock();
		}
	}
}
