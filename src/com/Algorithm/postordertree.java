package com.Algorithm;

import java.util.*;

public class postordertree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		ArrayList<Integer> r = postorderTraversal(root);
		for(Integer e : r){
			System.out.printf("%d,",e);
		}
		System.out.println(isValidBST(new TreeNode(0)));
	}	
	public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode T = root;
        long pre = -3000000000l;
        while(!stack.isEmpty()||T!=null){
            if(T != null){
                stack.push(T);
                T = T.left;
            }else{
                T = stack.pop();
                if(pre >= T.val) return false;
                pre = T.val;
                T = T.right;
            }
        }
        return true;
    }
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) return result;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		TreeNode visited = root,cur = null; 
		while(!stack.isEmpty()){
			cur = stack.peek();
			if((cur.left == null&&cur.right == null)||(cur.left == visited||cur.right == visited)){
				result.add(cur.val);
				stack.pop();
				visited = cur;
			}else{
				if(cur.right != null)
					stack.push(cur.right);
				if(cur.left != null)
					stack.push(cur.left);
			}
		}
		
		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}