package com.zijie.frameworksource_2.iodemo.classTop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingDeque;

public class BufferedStreamTest {
	private static final byte[] byteArray = {
	        0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
	        0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
	    };
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bufferedOutPutStream();
		bufferedInputStream();
	}
	
	private static void bufferedOutPutStream() {
		try {
			File file = new File("E:/vvNewFile/FrameWorkSource_2/app/src/main/java/com/zijie/frameworksource_2/iodemo/BufferedStreamTest.txt");

			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(byteArray[0]);
			bos.write(byteArray, 1, byteArray.length - 1);
			bos.flush();
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据JAVA官方文档的描述，mark(int readlimit)方法表示，标记当前位置，并保证在mark以后最多可以读取readlimit字节数据，mark标记仍有效。
	 * 如果在mark后读取超过readlimit字节数据，mark标记就会失效，调用reset()方法会有异常。
	 * 但实际的运行情况却和JAVA文档中的描述并不完全相符。 有时候在BufferedInputStream类中调用mark(int readlimit)方法后，即使读取超过readlimit字节的数据，mark标记仍有效，
	 * 仍然能正确调用reset方法重置。
	 *
	 * 事实上，mark在JAVA中的实现是和缓冲区相关的。只要缓冲区够大，mark后读取的数据没有超出缓冲区的大小，mark标记就不会失效。如果不够大，mark后又读取了大量的数据，
	 * 导致缓冲区更新，原来标记的位置自然找不到了。
	 *
	 * 因此，mark后读取多少字节才失效，并不完全由readlimit参数确定，也和BufferedInputStream类的缓冲区大小有关。 如果BufferedInputStream类的缓冲区大小大于readlimit，
	 * 在mark以后只有读取超过缓冲区大小的数据，mark标记才会失效。看下面的例子。
	 */
	private static void bufferedInputStream() {
		try {
			File file = new File("E:/vvNewFile/FrameWorkSource_2/app/src/main/java/com/zijie/frameworksource_2/iodemo/BufferedStreamTest.txt");
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
			for(int i = 0; i < 10; i++) {
				//还剩下多少个数据，下面应该不能等于0
				if (bin.available() > 0) {
					System.out.println("bin.available()：" + bin.available());
					//更具注释可以看出是读取下一个字节数据
					System.out.println(byteToString((byte)bin.read()));
				}
			}
			//这个标记有效时，最多只能读取这么多个字节数据
			bin.mark(3);

			bin.skip(10);//跳过10个

			byte[] b = new byte[1024];
			int n1 = bin.read(b, 0, b.length); //返回读到的数量
			System.out.println("--------" + n1);
			printByteValue(b);
			//
			bin.reset();
			int n2 = bin.read(b,0, b.length);
			System.out.println("++++++++" + n2);
			printByteValue(b);
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static String byteToString(byte b) {
		byte[] barray = {b};
		return new String(barray);
	}
	
	private static void printByteValue(byte[] buf) {
		for(byte b: buf) {
			if (b != 0) {
				System.out.print(byteToString(b) + " ");
			}
		}
	}

}
