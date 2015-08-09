package com.Algorithm;

import java.util.*;

public class BinaryTreeZigzag {

	public static void main(String[] args) {
		//TreeNode root = new TreeNode(1);
		//ArrayList<ArrayList<Integer>> r = zigzagLevelOrder(root);
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();
		ArrayList<Integer> row;
		boolean flag = false;

		if (root == null)
			return result;
		que.add(root);
		que.add(null);

		while (!que.isEmpty()) {
			row = new ArrayList<Integer>();
			ListIterator<TreeNode> iter = que.listIterator();
			if (flag) {
				while (iter.hasNext()) {
					TreeNode T = iter.next();
					if (T == null) {
						iter.remove();
						que.add(null);
						break;
					}
					if (T.left != null)
						que.add(T.left);
					if (T.right != null)
						que.add(T.right);
				}
				while (iter.hasPrevious()) {
					TreeNode T = iter.previous();
					row.add(T.val);
					iter.remove();
				}
				result.add(row);
			} else {
				while (iter.hasNext()) {
					TreeNode T = iter.next();
					if (T == null) {
						iter.remove();
						que.add(null);
						break;
					}
					if (T.left != null)
						que.add(T.left);
					if (T.right != null)
						que.add(T.right);
					row.add(T.val);
					iter.remove();
				}
				result.add(row);
			}

		}

		return result;
	}
}
