package com.Algorithm;

//�ȶ�
public class ð������ {
	public static void main(String[] args) {
		int[] a = { 3,4,1,2,5,6,7,8,9 };
		System.out.println("����֮ǰ��");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// ð������
		int lastChange = a.length - 1;
		int thisChange = 0; 
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < lastChange; j++) {
				// ����-i��Ҫ��ÿ����һ�ζ�������i�������������ȥ�ˣ�û�б�Ҫ���滻��
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					thisChange = j;
				}
			}
			if(thisChange == lastChange||thisChange == 0) break;
			lastChange = thisChange;
		}
		System.out.println();
		System.out.println("����֮��");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
