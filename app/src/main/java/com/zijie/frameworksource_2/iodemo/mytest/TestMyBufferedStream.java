package com.zijie.frameworksource_2.iodemo.mytest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 * Created by hezijie on 2020/3/31.
 */
public class TestMyBufferedStream {
    private static final byte[] byteArray = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };
    public static void main(String[] args){
//        bufferedTest();
//        dataStreamTest();
//        readerAndWriter();
        randomAccessTest();

    }

    private static void randomAccessTest() {
        File file = new File("E:/vvNewFile/FrameWorkSource_2/app/src/main/java/com/zijie/frameworksource_2/iodemo/mytest/Random.txt");
        if (file.exists()){
            file.delete();
        }
        try {
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            raf.seek(10000);
            System.out.println("1---" + raf.length());
            raf.setLength(10000);
            System.out.println("2---" + raf.length());
            raf.writeUTF("何子杰"); //写入URF字符时，每个字符占3个子杰，2个子杰记录长度
            System.out.println("3---" + raf.length());
            raf.seek(1000);
            for (int i = 0; i < 100; i++) {
                raf.writeChar('a');
            }
            System.out.println("4---" + raf.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(file,"r");
            raf.seek(1000);
            byte[] b1 = new byte[200];
            raf.read(b1);
            System.out.println("5---" + new String(b1));
            raf.seek(10000);
            System.out.println("6---" + raf.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  static String s = "I am hezijie";

    private static void readerAndWriter() {
        File file = new File("E:/vvNewFile/FrameWorkSource_2/app/src/main/java/com/zijie/frameworksource_2/iodemo/mytest/OutputSreamWriter.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file,false);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(s + osw.getEncoding() );
            bw.newLine();
            bw.flush();

            OutputStreamWriter osw2 = new OutputStreamWriter(fos);
            BufferedWriter bw2 = new BufferedWriter(osw2);
            bw2.write(s + osw2.getEncoding());
            bw2.flush();


            OutputStreamWriter osw3 = new OutputStreamWriter(fos);
            BufferedWriter bw3 = new BufferedWriter(osw3);
            bw3.write(s + osw3.getEncoding());
            bw3.flush();
            bw.close();
            bw2.close();
            bw3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            BufferedReader br = new BufferedReader(isr);
            String s = "";
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }


            InputStreamReader isr2 = new InputStreamReader(fis,"GBK");
            BufferedReader br2 = new BufferedReader(isr2);
            while ((s = br2.readLine()) != null){
                System.out.println(s);
            }

            InputStreamReader isr3 = new InputStreamReader(fis,"GBK");
            BufferedReader br3 = new BufferedReader(isr3);
            while ((s = br3.readLine()) != null){
                System.out.println(s);
            }
            br.close();
            br2.close();
            br3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dataStreamTest() {
        File file = new File("E:/vvNewFile/FrameWorkSource_2/app/src/main/java/com/zijie/frameworksource_2/iodemo/mytest/DataStream.txt");
        try {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            dos.writeBoolean(true);
            dos.writeByte((byte)77);
            dos.writeInt(78);
            dos.writeShort((short)79);
            dos.writeLong(80L);
            dos.writeChar('M');
            dos.writeDouble(101.1d);
//            dos.writeBytes("abcd");
            dos.writeUTF("efg");
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            System.out.println(dis.readBoolean());
            System.out.println(dis.readByte());
            System.out.println(dis.readInt());
            System.out.println(dis.readShort());
            System.out.println(dis.readLong());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
//            byte[] bytes = new byte[1024];
//            System.out.println(dis.read(bytes));
            System.out.println(dis.readUTF());
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedTest() {
        File file = new File("E:/vvNewFile/FrameWorkSource_2/app/src/main/java/com/zijie/frameworksource_2/iodemo/mytest/Buferred.txt");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(byteArray[0]);
            bos.write(byteArray,1,byteArray.length - 1);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        byte[] bytes = new byte[1024];
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            int read = bis.read(bytes, 0, 6);
            System.out.println("bis.read(bytes, 0, 6)------" + read);
            int read1 = bis.read(bytes);
            System.out.println("bis.read(bytes)------" + read1);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (byte b :bytes){
            if (b != 0 ){
                System.out.println(new String(new byte[]{b}));
            }
        }
    }


}
