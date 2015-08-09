package com.ThreadLearning;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.*;

public class LinkedBlockedDeque {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedBlockingQueue<File> source = new LinkedBlockingQueue<File>(); 
		LinkedBlockingQueue<File> factory = new LinkedBlockingQueue<File>();
		File Flag = new File("sFlag");
		System.out.println("Ҫ������Ŀ¼��:");
		int N = in.nextInt();
		in.nextLine();
		for(int i = 1;i<=N;i++){
			System.out.println("�����"+i+"��Ŀ¼:");
			String tmp = in.nextLine();
			source.add(new File(tmp));
		}
		source.offer(Flag);
		System.out.println("Ҫ�����Ĺؼ�����:");
		int M = in.nextInt();in.nextLine();
		String[] keys = new String[M];
		for(int i = 1;i<=M;i++){
			System.out.println("�����"+i+"���ؼ���:");
			keys[i-1] = in.nextLine();
		}
		in.close();
		System.out.println("�������");
		for(int i=1;i<=2;i++){
			new Thread(new searchFiles(factory,source,Flag),"������"+i+"��").start();
		}
		for(int i=0;i<5;i++){
			new Thread(new searchKey(factory,Flag,keys),"������"+(i+1)+"��").start();
		}
	}

}

// ������
class searchFiles implements Runnable {
	private LinkedBlockingQueue<File> factory = null;
	private LinkedBlockingQueue<File> source = null;
	private File flag = null;

	public searchFiles(LinkedBlockingQueue<File> factory,
			LinkedBlockingQueue<File> source, File flag) {
		this.factory = factory;
		this.source = source;
		this.flag = flag;
	}

	@Override
	public void run() {
		try {
			for (File workFile = source.take(); workFile != flag; workFile = source.take()) {
				listFiles(workFile);
			}
			source.put(flag);
			factory.put(flag);
			System.out.println("��"+Thread.currentThread().getName()+"���������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void listFiles(File workFile) throws InterruptedException {
		if (workFile.isFile()) {
			System.out.println("��"+Thread.currentThread().getName()+"������ļ�:");
			System.out.println(workFile.getPath());
			factory.put(workFile);
			return;
		}
		File[] files = workFile.listFiles();
		for (File f : files)
			listFiles(f);
	}
}

// ������
class searchKey implements Runnable {
	private LinkedBlockingQueue<File> factory;
	private File flag = null;
	private String[] keys = null;

	public searchKey(LinkedBlockingQueue<File> factory, File flag, String[] keys) {
		this.factory = factory;
		this.flag = flag;
		this.keys = keys;
	}

	@Override
	public void run() {
		try {
			for (File workFile = factory.take(); workFile != flag; workFile = factory.take()){
				seach(workFile);
			}
			factory.put(flag);
			System.out.println("��"+Thread.currentThread().getName()+"���������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void seach(File workFile) {
		try {
			Scanner in = new Scanner(workFile);
			int count = 0;
			while (in.hasNextLine()) {
				count++;
				String tmp = in.nextLine();
				for(String key:keys){
					if (tmp.contains(key)) {
						System.out.println("��" + Thread.currentThread().getName()+ "��" + workFile.getPath());
						System.out.println("key:"+key+"  ��" + count + "��:" + tmp);
					}
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
