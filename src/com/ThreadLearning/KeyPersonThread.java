package com.ThreadLearning;

public class KeyPersonThread extends Thread {
	public KeyPersonThread(String name){
		super(name);
	}
	@Override
	public void run(){
		System.out.println("\n"+Thread.currentThread().getName()+"��ʼս��");
		for(int i=0;i<6;i++){
			System.out.println(Thread.currentThread().getName()+"�����о�"+(i+1)+"��;");
		}
		System.out.println(Thread.currentThread().getName()+"����������");
	}
	
}
