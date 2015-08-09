package com.Algorithm;

public class StringToInteger {
	public int atoi(String str) {
        str = str.trim();
        long result = 0;
        int flag = 1;
        boolean exitFlag = false;
        char [] schar = str.toCharArray();
        for(int i = 0;i<schar.length;i++){
            short charToNum = (short)schar[i];
            if(charToNum>=48&&charToNum<=57){
                result = result*10 + charToNum;
                exitFlag = true;
            }
            else if(exitFlag){
                result = result*flag;
                if(result>2147483647)
                    return 2147483647;
                else if(result<-2147483648)
                    return -2147483648;
                else
                    return (int)result;
            }
            else if(charToNum == 45)
                flag = -1;
            else
                flag = 1;
        }
        return 0;
    }
	public static void main(String [] args){
		String a = "+-0123456789";
		char[] b = a.toCharArray();
		switch(a){
		
		}
		for(int i=0;i<b.length;i++){
			char temp = b[i];
			System.out.println((short)temp);
		}
 	}
}
