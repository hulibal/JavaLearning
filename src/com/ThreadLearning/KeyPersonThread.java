package com.ThreadLearning;

public class KeyPersonThread extends Thread {
	public KeyPersonThread(String name){
		super(name);
	}
	@Override
	public void run(){
		System.out.println("\n"+Thread.currentThread().getName()+"开始战斗");
		for(int i=0;i<6;i++){
			System.out.println(Thread.currentThread().getName()+"攻击敌军"+(i+1)+"次;");
		}
		System.out.println(Thread.currentThread().getName()+"结束攻击。");
	}
	
}
