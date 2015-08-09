package com.Basic;

import java.util.Scanner;

public class Main {
	
	public static int find(int[] tree,int u,int v){
		while (u!=1||v!=1) {
			if (u != 1) {
				int tmp = tree[u];
				if(tmp == 0) break;
				tree[u] = 0;
				u = tmp;
			}
			if (v != 1) {
				int tmp = tree[v];
				if(tmp == 0) break;
				tree[v] = 0;
				v = tmp;
			}
		}
		return u>v?u:v;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextShort();

		for (int casei = 1; casei <= T; casei++) {
			int n = sc.nextInt();
			int[] tree = new int[n + 1];
			for (int i = 1; i < n + 1; i++)
				tree[i] = sc.nextInt();
			int q = sc.nextInt();

			for (int i = 0; i < q; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();	
				int[] faketree = new int[n + 1];
				for (int j = 1; j < n + 1; j++)
					faketree[j] = tree[j];
				System.out.println(find(faketree,u,v));
			}
		}

		sc.close();
	}
}

// import java.util.HashMap;

// public class Main {
//
// public static Node buildTreeByPreAndIn(int[] pre,int ps,int pe,int[] in,int
// is,int ie){
// if(ps > pe) return null;
// Node root = new Node(pre[ps]);
// int position = is;
// for(;position<=ie&&in[position]!=pre[ps];position++);
// root.left = buildTreeByPreAndIn(pre,ps+1,ps+position-is,in,is,position-1);
// root.right = buildTreeByPreAndIn(pre,pe-ie+position+1,pe,in,position+1,ie);
// return root;
// }
//
// public static int depth(Node root,HashMap<Node,Integer> de){
// if(root == null) return 0;
// if(!de.containsKey(root)){
// de.put(root,Math.max(depth(root.left,de), depth(root.right,de))+1);
// }
// return de.get(root);
// }
//
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int T = sc.nextShort();
//
// for (int casei = 1; casei <= T; casei++) {
// int n = sc.nextInt();
// int[] pre = new int[n];
// int[] in = new int[n];
// for(int i =0;i<n;i++){
// pre[i] = sc.nextInt();
// }
// for(int i =0;i<n;i++){
// in[i] = sc.nextInt();
// }
// HashMap<Node,Integer> de = new HashMap<Node,Integer>();
// System.out.println(depth(buildTreeByPreAndIn(pre,0,n-1,in,0,n-1),de));
// }
//
// sc.close();
// }
// }
//
// class Node{
// int val;
// Node left;
// Node right;
//
// Node(int x){
// val = x;
// }
// }
