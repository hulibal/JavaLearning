package com.Algorithm;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0);
		ListNode result = temp;
		int sum;
		while (l1 != null || l2 != null) {
			sum = 0;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (l1!=null||l2!=null||(sum + temp.val) / 10>0)
				temp.next = new ListNode((sum + temp.val) / 10);
			temp.val = (sum + temp.val) % 10;
			temp = temp.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(8);
		ListNode result = addTwoNumbers(l2,l1);
		while(result != null){
			System.out.printf("%d,",result.val);
			result = result.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}