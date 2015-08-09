package com.IO;

import java.io.IOException;
import java.io.FileInputStream;

public class testFileInputStream {
	public static void main(String args[]) throws IOException {
		try {
			FileInputStream rf = new FileInputStream(
					"E:/douban/movie/        √ÎÀŸ5¿Â√◊ (∂π∞Í).txt");
			int n = 512;
			byte buffer[] = new byte[n];
			while (rf.read(buffer, 0, n) != -1) {
				System.out.println(new String(buffer));
			}
			System.out.println();
			rf.close();
		} catch (IOException IOe) {
			System.out.println(IOe.toString());
		}

	}
}
