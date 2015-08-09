package com.dataStructure;

public class BinTreeNode {
	private Object data; // 数据域
	private BinTreeNode parent; // 父结点
	private BinTreeNode lChild; // 左孩子
	private BinTreeNode rChild; // 右孩子

	public BinTreeNode() {
		this(null);
	}

	public BinTreeNode(Object e) {
		data = e;
		parent = lChild = rChild = null;
	}

	/****** Node接口方法 ******/
	public Object getData() {
		return data;
	}

	public void setData(Object obj) {
		data = obj;
	}

	/****** 辅助方法,判断当前结点位置情况 ******/
	// 判断是否有父亲
	public boolean hasParent() {
		return parent != null;
	}

	// 判断是否有左孩子
	public boolean hasLChild() {
		return lChild != null;
	}

	// 判断是否有右孩子
	public boolean hasRChild() {
		return rChild != null;
	}

	// 判断是否为叶子结点
	public boolean isLeaf() {
		return !hasLChild() && !hasRChild();
	}

	// 判断是否为某结点的左孩子
	public boolean isLChild() {
		return (hasParent() && this == parent.lChild);
	}

	// 判断是否为某结点的右孩子
	public boolean isRChild() {
		return (hasParent() && this == parent.rChild);
	}

	
	/****** 与parent相关的方法 ******/
	// 取父结点
	public BinTreeNode getParent() {
		return parent;
	}

	// 断开与父亲的关系
	public void sever() {
		if (!hasParent())
			return;
		if (isLChild())
			parent.lChild = null;
		else
			parent.rChild = null;
		parent = null;
	}

	/****** 与lChild相关的方法 ******/
	// 取左孩子
	public BinTreeNode getLChild() {
		return lChild;
	}

	// 设置当前结点的左孩子,返回原左孩子
	public BinTreeNode setLChild(BinTreeNode lc) {
		BinTreeNode oldLC = this.lChild;
		if (hasLChild()) {
			lChild.sever();
		} // 断开当前左孩子与结点的关系
		if (lc != null) {
			lc.sever(); // 断开lc与其父结点的关系
			this.lChild = lc; // 确定父子关系
			lc.parent = this;
		}
		return oldLC; // 返回原左孩子
	}

	/****** 与rChild相关的方法 ******/
	// 取右孩子
	public BinTreeNode getRChild() {
		return rChild;
	}

	// 设置当前结点的右孩子,返回原右孩子
	public BinTreeNode setRChild(BinTreeNode rc) {
		BinTreeNode oldRC = this.rChild;
		if (hasRChild()) {
			rChild.sever();
		} // 断开当前右孩子与结点的关系
		if (rc != null) {
			rc.sever(); // 断开lc与其父结点的关系
			this.rChild = rc; // 确定父子关系 104
			rc.parent = this;
		}
		return oldRC; // 返回原右孩子
	}
}
