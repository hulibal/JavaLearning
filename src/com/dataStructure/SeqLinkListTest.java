package com.dataStructure;

import java.util.Scanner;

public class SeqLinkListTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int tmp;
			// 1.链表初始化
			SeqLinkList temp = new SeqLinkList();
			Node s = temp.getHead();
			while ((tmp = sc.nextInt()) != -1) {
				// 2.把tmp加入到链表中
				Node p = new Node();
				p.val = tmp;
				s.next = p;
				s = p;
			}

			s = temp.getHead().next;
			int Max = s.val, Min = s.val, Sum = s.val;
			// 3.求出最大值、最小值、和，并输出
			while (s.next != null) {
				Max = Max > s.next.val ? Max : s.next.val;
				Min = Min > s.next.val ? s.next.val : Min;
				Sum += s.next.val;
				s = s.next;
			}
			// 输出方式
			System.out.println(Max + " " + Min + " " + Sum);
		}
		sc.close();
	}
}

class Node {
	int val;
	Node next;
}

class SeqLinkList {
	private Node head = new Node();

	public Node getHead() {
		return head;
	}

	public SeqLinkList() {
		head.val = 0;
		head.next = null;
	}
}