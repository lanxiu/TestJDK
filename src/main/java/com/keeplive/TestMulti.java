package com.keeplive;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class TestMulti {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
//		MultiTheradDownLoad mtd = new MultiTheradDownLoad("http://ftp.kaist.ac.kr/eclipse/technology/epp/downloads/release/indigo/SR2/eclipse-jee-indigo-SR2-win32-x86_64.zip", 2);
//		mtd.downloadPart();
		TestMulti tm = new TestMulti();
		tm.downloadNetRandom();
	}
	@Test
    public void downloadNet( ) throws MalformedURLException   {
        // ���������ļ�
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL(" http://mirror.centos.org/centos/7/os/x86_64/Packages/libevent-devel-2.0.21-4.el7.x86_64.rpm");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("d:/11.zip");

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void downloadNetRandom( ) throws MalformedURLException   {
        // ���������ļ�
        int bytesum = 0;
        int byteread = 0;
        CookieHandler.setDefault(new CookieManager());
        URL url = new URL("http://ftp.kaist.ac.kr/eclipse/technology/epp/downloads/release/indigo/SR2/eclipse-jee-indigo-SR2-win32-x86_64.zip");

        try {
        	int startpos = 89232222;
            URLConnection conn = url.openConnection();
//            conn.setRequestProperty("Range", "bytes=" + 89232222
//                    + "-" );
            conn.addRequestProperty("Range", "bytes=" + 89232222
                    + "-" );
            InputStream inStream = conn.getInputStream();
            RandomAccessFile fs = new RandomAccessFile("d:/12.zip",
                    "rw");

            fs.seek(startpos);
            bytesum= startpos;
            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
