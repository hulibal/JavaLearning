package com.ThreadLearning;

public class Actor extends Thread{
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"��һ����Ա");
		int count = 0;
		while(count++<30){
			System.out.println(Thread.currentThread().getName()+count+"�ε�̨�ݳ�");
			if(count%10==0){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"лĻ.");
	}
	
	public static void main(String[] args){
		Thread MrActor = new Actor();
		MrActor.setName("Mr.Thread");		
		Thread MrActress = new Thread(new Actress(),"Ms.Runnable");
		MrActor.start();
		MrActress.start();
	}
}


class Actress implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"��һ����Ա");
		int count = 0;
		while(count++<30){
			System.out.println(Thread.currentThread().getName()+count+"�ε�̨�ݳ�");
			if(count%10==0){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"лĻ.");
	}
	
}