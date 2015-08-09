package com.Algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for (int i = 0; i < T; i++) {
			String num = in.nextLine();
			char[] nums = num.toCharArray();
			LinkedList<Character> stack = new LinkedList<Character>();
			stack.push(nums[0]);

			boolean greedyflag = false;
			boolean rollBack = false;
			int counter = 1;
			int cur, pre;

			while (counter < nums.length) {
				if (!greedyflag) {
					cur = nums[counter] - '0';
					pre = stack.peek() - '0';
				}else if(rollBack){
					cur = stack.pop() - 1 - '0';
					if(stack.isEmpty()){
						stack.push((char)(cur+48));
						counter++;
						rollBack = false;
						continue;
					}
					pre = stack.peek()-'0';
				}else{
					cur = 9;
					pre = stack.peek()-'0';
				}

				boolean find = false;
				for (; cur >= 0; cur--) {
					if (Judge(pre, cur)) {
						stack.push((char)(cur+'0'));
						find = true;
						break;
					}
				}
				if (find) {
					counter++;
					rollBack = false;
					continue;
				}
				greedyflag = true;
				rollBack = true;
				counter--;
			}

			StringBuilder sum = new StringBuilder();
			while (!stack.isEmpty())
				sum.append(stack.pollLast());
			System.out.println(sum.toString());
		}
		in.close();
	}

	public static boolean Judge(int pre, int cur) {
		if (pre == 0) {
			if (cur == 0)
				return true;
			else
				return false;
		}
		if (cur == 0) {
			if (pre % 3 > 0)
				return true;
			else
				return false;
		}
		if ((cur - 1) / 3 >= (pre - 1) / 3 && (cur - 1) % 3 >= (pre - 1) % 3)
			return true;
		return false;
	}
}
