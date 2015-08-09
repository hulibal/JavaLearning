package com.Algorithm;

public class ZigZag {
	public static String convert(String s, int nRows) {
//		if(s.length()==0||nRows==1||s.length()<=nRows)
//            return s;
//        int basicNum = 2*(nRows-1);
//        int nLines = s.length()/basicNum;
//        int yuNum = s.length()%basicNum;
//        if(yuNum > 0) nLines++;
//        char [] temp = new char[s.length()];
//        for(int i = 1;i <= s.length();i++){
//            int yu = (i%basicNum);
//            int lNo = yu > 0?(i/basicNum + 1):(i/basicNum);
//            int nNo = yu > nRows ? (basicNum-yu+2):yu;
//            if(yu == 0) nNo = 2;
//            if(nNo==1){
//                temp[lNo-1] = s.charAt(i-1);
//            }else if(nNo == nRows){
//               if(yuNum!=0){
//            	    int point = (yuNum >= nRows) ? (lNo+(2*nRows-3)*(nLines-1)+yuNum-2):(lNo+(2*nRows-3)*(nLines-1)+yuNum-1);
//            	    temp[point] = s.charAt(i-1);
//               }
//            	else
//            		temp[lNo+(2*nRows-3)*nLines-1] = s.charAt(i-1);
//            }else if(yuNum > nRows){
//                int chaNum = basicNum-yuNum+2;
//        		int yus = (yu == 0)?basicNum:yu;
//                int point = chaNum >= nNo?((2*nNo-3)*nLines+2*(lNo-1)+yus/nRows-nNo+2):((2*nNo-3)*nLines+2*(lNo-1)+yus/nRows-chaNum+2);
//                temp[point]= s.charAt(i-1);
//            }else{
//        		int yus = (yu == 0)?basicNum:yu;
//            	if(yuNum ==0){
//            		temp[nLines*(2*nNo-3)+(lNo-1)*2+yus/nRows] = s.charAt(i-1);
//            		continue;
//            	}
//                int point = (yuNum >= nNo)?((nLines-1)*(2*nNo-3)+2*(lNo-1)+yus/nRows+nNo-1):((nLines-1)*(2*nNo-3)+2*(lNo-1)+yus/nRows+yuNum);
//                temp[point]= s.charAt(i-1);
//            }
//        }
//        return new String(temp);
		
		if(s.length()==0||nRows==1||s.length()<=nRows)
            return s;
        int basicNum = 2*(nRows-1);
        int nLines = s.length()/basicNum;
        int yuNum = s.length()%basicNum;
        if(yuNum > 0) nLines++;
        if(yuNum == 0) yuNum = basicNum;
        char [][] temp = new char[nRows][];
        temp[0] = new char[nLines];
        temp[nRows-1] = new char[nLines+yuNum/nRows-1];
        for(int i = 1;i<nRows-1;i++){
            if(yuNum<i+1)
                temp[i] = new char[2*(nLines-1)];
            else if(i+1<=yuNum&&(yuNum+i)<(2*nRows-1))
                temp[i] = new char[2*(nLines-1)+1];
            else
                temp[i] = new char[2*(nLines-1)+2];
        }
        for(int j = 1;j<=s.length();j++){
            int yu = (j%basicNum);
            int lNo = yu > 0?(j/basicNum + 1):(j/basicNum);
            int nNo = yu > nRows ? (basicNum-yu+2):yu;
            if(yu == 0) {
                nNo = 2;
                yu = basicNum;
            }
            if(nNo == 1||nNo == nRows){
                temp[nNo-1][lNo-1] = s.charAt(j-1);
            }else{
                temp[nNo-1][2*(lNo-1)+yu/nRows] = s.charAt(j-1);
            }
        }
        char[] result = new char[s.length()];
        int count = 0;
        for(int i = 0;i<nRows;i++){
        	for(int j=0;j<temp[i].length;j++){
        		result[count] = temp[i][j];
        		count++;
        	}
        }
        return new String(result);
	}
		
		
	
	public static void main(String[] args) {
		System.out.println(convert("ABCDE", 4));
	}
}
