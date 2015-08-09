package com.Algorithm;

public class ReverseInteger {
	public int reverse(int x) {
//        int e = 1;
//        int [] reverse = new int[10];
//        while((x%Math.pow(10,e))!=x){
//            reverse[e-1] = (int)((x%Math.pow(10,e))/Math.pow(10,e-1));
//            x=x- (int)(reverse[e-1]*Math.pow(10,e-1));
//            e++;
//        }
//        reverse[e-1] = (int)(x/Math.pow(10,e-1));
//        long re = 0;
//        
//        int count = e-1;
//        for(int i = 0;i<e;i++){
//            re+=(long)(reverse[i]*(Math.pow(10,count)));
//            count--;
//        }
//        if(re>(long)(Math.pow(2,31)-1)||re<(long)(-1*Math.pow(2,31)))
//        	return 0;
//        else
//        	return (int)re;
		long result = 0;
        while(x!=0){
            result *= 10;
            result += x%10;
            x /= 10;
        }
        if(result>2147483647||result<-2147483648)
            return 0;
        else
            return (int) result;
    }
	public static void main(String [] args){
		ReverseInteger t = new ReverseInteger();
		System.out.println(t.reverse(10000));
	}
}
