package com.Algorithm;

//≤ªŒ»∂®
public class œ£∂˚≈≈–Ú {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 13, 78, 34, 12, 64, 1 };
		System.out.println("≈≈–Ú÷Æ«∞£∫");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// œ£∂˚≈≈–Ú
		int d = a.length;
		while (d >= 1) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("≈≈–Ú÷Æ∫Û£∫");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
