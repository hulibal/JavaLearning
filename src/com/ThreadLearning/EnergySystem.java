package com.ThreadLearning;

public class EnergySystem {
	
	//�������ӣ��洢����
	private final double[] energyBoxes;
	
	public EnergySystem(int n,double initialEnergy){
		energyBoxes = new double[n];
		for(int i=0;i<energyBoxes.length;i++){
			energyBoxes[i] = initialEnergy;
		}
	}
	
	/**
	*����ת��
	*@param from ����Դ
	*@param to �����յ�
	*@param amount ����ֵ
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
		System.out.println(Thread.currentThread().getName()+":��ʼ����");
		energyBoxes[from] -= amount;
		System.out.printf(Thread.currentThread().getName()+":��%dת��%10.2f��λ������%d;%n",from,amount,to);
		energyBoxes[to] += amount;
		System.out.printf(Thread.currentThread().getName()+":�����ܺͣ�%10.2f%n",getTotalEnergies());
		System.out.println(Thread.currentThread().getName()+":Over");
		this.notifyAll();
		}
	}	
	/**
	 * ��ȡ��������������ܺ�
	 */
	public double getTotalEnergies(){
		double sum = 0;
		for(double amount:energyBoxes)
			sum += amount;
		return sum;
	}
	
	/**
	 * �����������ӳ���
	 */
	public int getBoxAmount(){
		return energyBoxes.length;
	}
}
