package com.Algorithm;

import java.util.*;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> r = generateTrees(9);
		for (TreeNode E : r) {
			System.out.print("中序:[");
			inorder(E);
			System.out.print("]  前序:[");
			preorder(E);
			System.out.print("]  后序:[");
			postorder(E);
			System.out.println("]");
		}
		System.out.println("\n一共 " + r.size() + " 种.");
		
		int a = 3;float b = 2.0f;
		System.out.println("\n"+a / b + " " + b / a);
		System.out.println((Math.log(9) / Math.log(2)));
		
		int[] num = new int[] { 1, 3, 5, 7, 9, 10, 11, 13 };
		TreeNode root = sortedArrayToBST(num);
		System.out.print("\n中序:[");
		inorder(root);
		System.out.print("]  前序:[");
		preorder(root);
		System.out.print("]  后序:[");
		postorder(root);
		System.out.println("]");
	}

	public static TreeNode sortedArrayToBST(int[] num) {
		return buildBST(num, 0, num.length - 1);
	}

	public static TreeNode buildBST(int[] num, int start, int end) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(num[(start + end) / 2]);
		root.left = buildBST(num, start, (start + end) / 2 - 1);
		root.right = buildBST(num, (start + end) / 2 + 1, end);
		return root;
	}

	public static ArrayList<TreeNode> generateTrees(int n) {
		return buildTree(1, n);
	}

	public static ArrayList<TreeNode> buildTree(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> leftTree = buildTree(start, i - 1);
			ArrayList<TreeNode> rightTree = buildTree(i + 1, end);

			Iterator<TreeNode> leftIter = leftTree.iterator();
			Iterator<TreeNode> rightIter = rightTree.iterator();

			while (leftIter.hasNext()) {
				TreeNode left = leftIter.next();
				while (rightIter.hasNext()) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = rightIter.next();
					result.add(root);
				}
			}
		}
		return result;
	}

	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.printf("%d,", root.val);
		inorder(root.right);
	}

	public static void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.printf("%d,", root.val);
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(TreeNode root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.printf("%d,", root.val);
	}
}
