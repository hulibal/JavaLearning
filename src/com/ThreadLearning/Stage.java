package com.ThreadLearning;

public class Stage extends Thread {
	
	public Stage(String name){
		super(name);
	}
	public void run(){		
		
		ArmyRunnable ArmyOfA = new ArmyRunnable();
		ArmyRunnable ArmyOfB = new ArmyRunnable();
		
		Thread ArmyTaskOfA = new Thread(ArmyOfA,"ˮ��");
		Thread ArmyTaskOfB = new Thread(ArmyOfB,"���������");
		
		ArmyTaskOfA.start();
		ArmyTaskOfB.start();
				
		//����ֹͣ
		ArmyOfA.KeepRunning = false;
		ArmyOfB.KeepRunning = false;		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArmyTaskOfA.join();		//����ȷʵֹͣ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

		System.out.println("\nMr.������");
		Thread MrChen = new KeyPersonThread ("��ҧ��");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Mr.���ж�
		MrChen.start();
		
		try {
			MrChen.join();//�����̵߳ȴ�MrChen�߳̽���
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"ս������.");		
	}
	public static void main(String[] args) {		
		Thread Stage1 = new Stage("��̨1");		
		Stage1.start();
		try {
			Stage1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n");
		Thread Stage2 = new Stage("��̨2");
		Stage2.start();
	}

}
