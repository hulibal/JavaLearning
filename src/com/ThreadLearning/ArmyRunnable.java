package com.ThreadLearning;

public class ArmyRunnable implements Runnable {
	
	//volatile��֤�ܽ����ⲿֵ�������̵߳Ĵ���ֵ��ֹͣ��־
	//happens beforeԭ��
	volatile boolean KeepRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(KeepRunning){
			for(int i=1;i<4;i++){
				System.out.println(Thread.currentThread().getName()+"��["+i+"]�ι���;");
				//�������߳��ܹ���ô�����ʱ��
				Thread.yield();
			}
		}
		System.out.println("\n"+Thread.currentThread().getName()+"������ϣ�");
	}

}
