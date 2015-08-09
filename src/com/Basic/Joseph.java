package com.Basic;

public class Joseph {
	
	public Node buildCircleLink(int n){//��ѭ��������
		if(n<=0) return null;
		Node head = new Node(1);
		Node cur = head;
		for(int i =2;i<=n;i++){
			Node tmp = new Node(i);
			cur.next = tmp;
			cur = cur.next;
		}
		cur.next = head;
		return head;
	}
	
	public void count(int n,int a,int x){
		if(a>n) return;
		Node cur = buildCircleLink(n);
		if(a==1&&n==1){
			System.out.println(cur.val);
			return;
		}
		//�ҵ�Ҫ��ʼ��a����ǰ��
		Node pre = cur;
		if(a==1) a=n+1;//1ʱ��תһȦ������ǰ��
		for(int i = 1;i<a;i++){
			pre = cur;
			cur = cur.next;
		}
		
		while(cur.next != cur){
			for(int i = 1;i<x;i++){
				pre = cur;
				cur = cur.next;
			}
			System.out.printf("%d,",cur.val);
			pre.next = cur.next;//ɾ����ǰ�����ڵ�
			cur = cur.next;
		}
		System.out.printf("%d",cur.val);		
	}

	public static void main(String[] args) {
		Joseph solve = new Joseph();
		solve.count(9, 7, 2);
	}

}

class Node{
	int val;
	Node next;
	Node(int x){
		val = x;
	}
}