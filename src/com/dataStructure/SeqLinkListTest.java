package com.dataStructure;

import java.util.Scanner;

public class SeqLinkListTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int tmp;
			// 1.�����ʼ��
			SeqLinkList temp = new SeqLinkList();
			Node s = temp.getHead();
			while ((tmp = sc.nextInt()) != -1) {
				// 2.��tmp���뵽������
				Node p = new Node();
				p.val = tmp;
				s.next = p;
				s = p;
			}

			s = temp.getHead().next;
			int Max = s.val, Min = s.val, Sum = s.val;
			// 3.������ֵ����Сֵ���ͣ������
			while (s.next != null) {
				Max = Max > s.next.val ? Max : s.next.val;
				Min = Min > s.next.val ? s.next.val : Min;
				Sum += s.next.val;
				s = s.next;
			}
			// �����ʽ
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