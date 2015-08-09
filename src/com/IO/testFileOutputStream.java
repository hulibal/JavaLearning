package com.IO;

import java.io.*;

public class testFileOutputStream {
	public static void main(String [] args)throws IOException{
		File source = new File("E:/douban/movie/        √ÎÀŸ5¿Â√◊ (∂π∞Í).txt");
		
		File destdictory = new File("E:/IOTest");
		if(!destdictory.exists())
			destdictory.mkdirs();
		File destnation = new File(destdictory,"Lucy.txt");
		if(!destnation.exists())
			destnation.createNewFile();
		
		FileOutputStream out = new FileOutputStream(destnation,true);
		FileInputStream in = new FileInputStream(source);
		
		byte [] bufer = new byte[512];
		
		while(in.read(bufer, 0, 512) != -1){
			System.out.println(new String(bufer));
			out.write(bufer, 0, 512);
		}
		in.close();
		out.close();
	}
}
