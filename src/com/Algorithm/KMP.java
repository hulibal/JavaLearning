package com.Algorithm;

public class KMP {
	public static void main(String[] args) {
		KMP kmp = new KMP();
		String s = "dabcdabde";
		@SuppressWarnings("unused")
		int[] next = kmp.GetNext(s.toCharArray());
	}
	public int[] GetNext(char[] p){ 
		int[] next = new int[p.length];
	    next[0] = -1;  
	    int k = -1;  
	    int j = 0;  
	    while (j < p.length - 1) {  
	        if (k == -1 || p[j] == p[k]){  
	            ++k;  
	            ++j;  
	            next[j] = k;  
	        } else {  
	            k = next[k];  
	        }  
	    }
	    return next;
	}  
}
