package com.Basic;

import java.util.Scanner;

public class Viola {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCaseNum = in.nextInt();
		Case[] cases = new Case[testCaseNum];
		in.nextLine();
		for (int i = 0; i < testCaseNum; i++) {
			int N = in.nextInt();
			int M = in.nextInt();
			in.nextLine();
			int[] signals = new int[M];
			for (int j = 0; j < M; j++)
				signals[j] = in.nextInt();
			int[][] mouduls = new int[N][];
			for (int k = 0; k < N; k++) {
				in.nextLine();
				int startsignal = in.nextInt();
				int num = in.nextInt();
				int[] m = new int[num + 1];
				m[0] = startsignal;
				for (int l = 0; l < num; l++) {
					m[l + 1] = in.nextInt();
				}
				mouduls[k] = m;
			}
			cases[i] = new Case(N, M, signals, mouduls);
		}
		in.close();
	}
}

class Case {
	int N, M;
	int[] signals;
	int[][] mouduls;

	public Case() {
	};

	public Case(int N, int M, int[] signals, int[][] mouduls) {
		this.M = M;
		this.N = N;
		this.signals = signals;
		this.mouduls = mouduls;
	}
}