package com.dataStructure;

public class BinTreeNode {
	private Object data; // ������
	private BinTreeNode parent; // �����
	private BinTreeNode lChild; // ����
	private BinTreeNode rChild; // �Һ���

	public BinTreeNode() {
		this(null);
	}

	public BinTreeNode(Object e) {
		data = e;
		parent = lChild = rChild = null;
	}

	/****** Node�ӿڷ��� ******/
	public Object getData() {
		return data;
	}

	public void setData(Object obj) {
		data = obj;
	}

	/****** ��������,�жϵ�ǰ���λ����� ******/
	// �ж��Ƿ��и���
	public boolean hasParent() {
		return parent != null;
	}

	// �ж��Ƿ�������
	public boolean hasLChild() {
		return lChild != null;
	}

	// �ж��Ƿ����Һ���
	public boolean hasRChild() {
		return rChild != null;
	}

	// �ж��Ƿ�ΪҶ�ӽ��
	public boolean isLeaf() {
		return !hasLChild() && !hasRChild();
	}

	// �ж��Ƿ�Ϊĳ��������
	public boolean isLChild() {
		return (hasParent() && this == parent.lChild);
	}

	// �ж��Ƿ�Ϊĳ�����Һ���
	public boolean isRChild() {
		return (hasParent() && this == parent.rChild);
	}

	
	/****** ��parent��صķ��� ******/
	// ȡ�����
	public BinTreeNode getParent() {
		return parent;
	}

	// �Ͽ��븸�׵Ĺ�ϵ
	public void sever() {
		if (!hasParent())
			return;
		if (isLChild())
			parent.lChild = null;
		else
			parent.rChild = null;
		parent = null;
	}

	/****** ��lChild��صķ��� ******/
	// ȡ����
	public BinTreeNode getLChild() {
		return lChild;
	}

	// ���õ�ǰ��������,����ԭ����
	public BinTreeNode setLChild(BinTreeNode lc) {
		BinTreeNode oldLC = this.lChild;
		if (hasLChild()) {
			lChild.sever();
		} // �Ͽ���ǰ��������Ĺ�ϵ
		if (lc != null) {
			lc.sever(); // �Ͽ�lc���丸���Ĺ�ϵ
			this.lChild = lc; // ȷ�����ӹ�ϵ
			lc.parent = this;
		}
		return oldLC; // ����ԭ����
	}

	/****** ��rChild��صķ��� ******/
	// ȡ�Һ���
	public BinTreeNode getRChild() {
		return rChild;
	}

	// ���õ�ǰ�����Һ���,����ԭ�Һ���
	public BinTreeNode setRChild(BinTreeNode rc) {
		BinTreeNode oldRC = this.rChild;
		if (hasRChild()) {
			rChild.sever();
		} // �Ͽ���ǰ�Һ�������Ĺ�ϵ
		if (rc != null) {
			rc.sever(); // �Ͽ�lc���丸���Ĺ�ϵ
			this.rChild = rc; // ȷ�����ӹ�ϵ 104
			rc.parent = this;
		}
		return oldRC; // ����ԭ�Һ���
	}
}
