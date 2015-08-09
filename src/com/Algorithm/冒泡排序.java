package com.Algorithm;

//稳定
public class 冒泡排序 {
	public static void main(String[] args) {
		int[] a = { 3,4,1,2,5,6,7,8,9 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 冒泡排序
		int lastChange = a.length - 1;
		int thisChange = 0; 
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < lastChange; j++) {
				// 这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
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
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
