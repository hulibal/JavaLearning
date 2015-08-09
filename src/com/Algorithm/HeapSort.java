package com.Algorithm;

public class HeapSort {	

	// 在刚挑出顶的大根堆中调整使其成为大根堆
	public static void siftMax(int[] arr, int rootPosition, int lastLeaf) {
		int child = 2 * rootPosition + 1;// 根的左孩子
		while (child <= lastLeaf) {
			if (child + 1 <= lastLeaf && arr[child] < arr[child + 1]) child++;
			if (arr[rootPosition] >= arr[child])	break;
			int tmp = arr[child];
			arr[child] = arr[rootPosition];
			arr[rootPosition] = tmp;
			rootPosition = child;
			child = 2 * rootPosition + 1;
		}
	}
	
	// 在刚挑出顶的小根堆中调整使其成为小根堆
		public static void siftMin(int[] arr, int rootPosition, int lastLeaf) {
			int child = 2 * rootPosition + 1;// 根的左孩子
			while (child <= lastLeaf) {
				if (child + 1 <= lastLeaf && arr[child] > arr[child + 1]) child++;
				if (arr[rootPosition] <= arr[child])	break;
				int tmp = arr[child];
				arr[child] = arr[rootPosition];
				arr[rootPosition] = tmp;
				rootPosition = child;
				child = 2 * rootPosition + 1;
			}
		}
	
	public static void buildMaxHeap(int[] arr,int start,int end){
		int rootPosition = (end - 1)/2;
		while(rootPosition>=start){
			siftMax(arr,rootPosition,end);
			rootPosition--;
		}
	}
	
	public static void buildMinHeap(int[] arr,int start,int end){
		int rootPosition = (end - 1)/2;
		while(rootPosition>=start){
			siftMin(arr,rootPosition,end);
			rootPosition--;
		}
	}
	
	public static void sort(int[] arr){
		buildMaxHeap(arr,0,arr.length-1);
		for(int i=arr.length-1;i>0;){
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			siftMax(arr,0,--i);
		}
	}
	
	public static int[] topK(int[] arr,int k){
		int[] topK = new int[k];
		for(int i=0;i<k;i++)
			topK[i] = arr[i];
		buildMinHeap(topK,0,k-1);
		for(int j = k;j<arr.length;j++){
			if(arr[j]>topK[0]){
				topK[0] = arr[j];
				siftMin(topK,0,k-1);
			}
		}
		return topK;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51}; 
		HeapSort.sort(arr);		
		for(int b : arr)
			System.out.printf("%d,",b);
		System.out.println();
		int[] topK = HeapSort.topK(arr, 9);
		for(int b : topK)
			System.out.printf("%d,",b);
	}

}