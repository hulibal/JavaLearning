package com.ThreadLearning;

public class Stage extends Thread {
	
	public Stage(String name){
		super(name);
	}
	public void run(){		
		
		ArmyRunnable ArmyOfA = new ArmyRunnable();
		ArmyRunnable ArmyOfB = new ArmyRunnable();
		
		Thread ArmyTaskOfA = new Thread(ArmyOfA,"水军");
		Thread ArmyTaskOfB = new Thread(ArmyOfB,"二逼青年军");
		
		ArmyTaskOfA.start();
		ArmyTaskOfB.start();
				
		//军队停止
		ArmyOfA.KeepRunning = false;
		ArmyOfB.KeepRunning = false;		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArmyTaskOfA.join();		//军队确实停止
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

		System.out.println("\nMr.陈来了");
		Thread MrChen = new KeyPersonThread ("陈咬金");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Mr.陈行动
		MrChen.start();
		
		try {
			MrChen.join();//其他线程等待MrChen线程结束
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"战争结束.");		
	}
	public static void main(String[] args) {		
		Thread Stage1 = new Stage("舞台1");		
		Stage1.start();
		try {
			Stage1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n");
		Thread Stage2 = new Stage("舞台2");
		Stage2.start();
	}

}
