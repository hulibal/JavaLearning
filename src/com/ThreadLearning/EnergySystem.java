package com.ThreadLearning;

public class EnergySystem {
	
	//能量盒子，存储能量
	private final double[] energyBoxes;
	
	public EnergySystem(int n,double initialEnergy){
		energyBoxes = new double[n];
		for(int i=0;i<energyBoxes.length;i++){
			energyBoxes[i] = initialEnergy;
		}
	}
	
	/**
	*能量转移
	*@param from 能量源
	*@param to 能量终点
	*@param amount 能量值
	*/
	public void transfer(int from,int to,double amount){
		synchronized(this){//if(energyBoxes[from]<amount)
			//return;
			while(energyBoxes[from]<amount){
				try {
					System.out.println(Thread.currentThread().getName());
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		System.out.println(Thread.currentThread().getName()+":开始工作");
		energyBoxes[from] -= amount;
		System.out.printf(Thread.currentThread().getName()+":从%d转移%10.2f单位能量到%d;%n",from,amount,to);
		energyBoxes[to] += amount;
		System.out.printf(Thread.currentThread().getName()+":能量总和：%10.2f%n",getTotalEnergies());
		System.out.println(Thread.currentThread().getName()+":Over");
		this.notifyAll();
		}
	}	
	/**
	 * 获取能量世界的能量总和
	 */
	public double getTotalEnergies(){
		double sum = 0;
		for(double amount:energyBoxes)
			sum += amount;
		return sum;
	}
	
	/**
	 * 返回能量盒子长度
	 */
	public int getBoxAmount(){
		return energyBoxes.length;
	}
}
