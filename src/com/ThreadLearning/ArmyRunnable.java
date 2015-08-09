package com.ThreadLearning;

public class ArmyRunnable implements Runnable {
	
	//volatile保证能接收外部值，其他线程的传入值，停止标志
	//happens before原则
	volatile boolean KeepRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(KeepRunning){
			for(int i=1;i<4;i++){
				System.out.println(Thread.currentThread().getName()+"第["+i+"]次攻击;");
				//让其他线程能够获得处理器时间
				Thread.yield();
			}
		}
		System.out.println("\n"+Thread.currentThread().getName()+"攻击完毕！");
	}

}
