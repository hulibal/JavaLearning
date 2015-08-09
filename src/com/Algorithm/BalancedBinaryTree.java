package com.Algorithm;

import java.util.*;

public class BalancedBinaryTree {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		HashMap<TreeNode, Integer> nodeDepth = new HashMap<TreeNode, Integer>();
		if (!isBalanced(root.left) || !isBalanced(root.right))
			return false;
		return Math.abs(depthofTree(root.left, nodeDepth)
				- depthofTree(root.right, nodeDepth)) <= 1;
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		int lMin = 0, rMin = 0;
		if (root.left != null)
			lMin = minDepth(root.left);
		if (root.right != null)
			rMin = minDepth(root.right);

		return Math.min(lMin, rMin) + 1;
	}

	public int depthofTree(TreeNode root, HashMap<TreeNode, Integer> nodeDepth) {
		if (root == null)
			return 0;
		if (nodeDepth.containsKey(root))
			return nodeDepth.get(root);
		int result = Math.max(depthofTree(root.left, nodeDepth),
				depthofTree(root.right, nodeDepth)) + 1;
		nodeDepth.put(root, result);
		return result;
	}
}
