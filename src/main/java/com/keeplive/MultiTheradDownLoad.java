package com.keeplive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Encode:UTF-8
 * 
 * Author:zhiming.xu
 * 
 * ���̵߳Ķϵ����س��򣬸��������url��ָ���߳���������ɶϵ��������ܡ�
 * 
 * ÿ���߳�֧����ĳһС�ε��������أ���ͨ��RandomAccessFile������ݵ����ϡ�
 */
public class MultiTheradDownLoad {

    private String filepath = null;
    private String filename = null;
    private String tmpfilename = null;

    private int threadNum = 0;

    private CountDownLatch latch = null;//����һ������������������Ҫ������ɶԻ����ļ���ɾ��

    private long fileLength = 0l;
    private long threadLength = 0l;
    private long[] startPos;//����ÿ���߳��������ݵ���ʼλ�á�
    private long[] endPos;//����ÿ���߳��������ݵĽ�ֹλ�á�

    private boolean bool = false;
    private URL url = null;

    //�вι��캯�����ȹ�����Ҫ������
    public MultiTheradDownLoad(String filepath, int threadNum) {
        this.filepath = filepath;
        this.threadNum = threadNum;
        startPos = new long[this.threadNum];
        endPos = new long[this.threadNum];
        latch = new CountDownLatch(this.threadNum);
        // First set the default cookie manager.
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    }

    /*
     * ��֯�ϵ��������ܵķ���
     */
    public void downloadPart() {

        File file = null;
        File tmpfile = null;
        HttpURLConnection httpcon = null;

        //������url�ڻ�ȡ�ļ���Դ�����ƣ��˴�û�����ļ���Ϊ�յ�������������������ʹ��UUID������һ��Ψһ���������ļ�����
        filename = "D:/"+filepath.substring(filepath.lastIndexOf('/') + 1, filepath
                .contains("?") ? filepath.lastIndexOf('?') : filepath.length());
        tmpfilename =  filename + "_tmp";

        try {
            url = new URL(filepath);
            httpcon = (HttpURLConnection) url.openConnection();

//            setHeader(httpcon);
          //��ȡ������Դ���ܳ��ȡ�
//            fileLength = httpcon.getContentLengthLong();
            int responseCode=httpcon.getResponseCode(); 
            System.out.println("****"+responseCode);

			for (int i = 1;; i++) {
				// DataInputStream in = new
				// DataInputStream(httpConnection.getInputStream ());
				// Utility.log(in.readLine());
				String sHeader = httpcon.getHeaderFieldKey(i);
				if (sHeader != null) {
					if (sHeader.equals("Content-Length")) {
						fileLength = Integer.parseInt(httpcon
								.getHeaderField(sHeader));
						break;
					}
				} else
					break;
			}
            
            
            file = new File(filename);
            tmpfile = new File(tmpfilename);

            threadLength = fileLength / threadNum;//ÿ���߳������ص���Դ��С��
            System.out.println("fileName: " + filename + " ," + "fileLength= "
                    + fileLength + " the threadLength= " + threadLength);

            if (file.exists() && file.length() == fileLength) {
                System.out
                        .println("the file you want to download has exited!!");
                return;
            } else {
                setBreakPoint(startPos, endPos, tmpfile);
                ExecutorService exec = Executors.newCachedThreadPool();
                for (int i = 0; i < threadNum; i++) {
                    exec.execute(new DownLoadThread(startPos[i], endPos[i],
                            this, i, tmpfile, latch));
                }
                latch.await();//����ļ�������Ϊ0֮ǰ�����ڴ˴�һֱ������
                exec.shutdown();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (file.length() == fileLength) {
            if (tmpfile.exists()) {
                System.out.println("delect the temp file!!");
                tmpfile.delete();
            }
        }
    }

    /*
     * �ϵ����÷�����������ʱ�ļ�ʱ��ֱ������ʱ�ļ��ж�ȡ�ϴ������ж�ʱ�Ķϵ�λ�á�û����ʱ�ļ�������һ������ʱ���������öϵ㡣
     * 
     * rantmpfile.seek()��ת��һ��λ�õ�Ŀ����Ϊ���ø����ϵ�洢��λ�þ����ֿ���
     * 
     * ����ʵ�ֶϵ���������Ҫ������
     */
    private void setBreakPoint(long[] startPos, long[] endPos, File tmpfile) {
        RandomAccessFile rantmpfile = null;
        try {
            if (tmpfile.exists()) {
                System.out.println("the download has continued!!");
                rantmpfile = new RandomAccessFile(tmpfile, "rw");
                for (int i = 0; i < threadNum; i++) {
                    rantmpfile.seek(8 * i + 8);
                    startPos[i] = rantmpfile.readLong();

                    rantmpfile.seek(8 * (i + 1000) + 16);
                    endPos[i] = rantmpfile.readLong();

                    System.out.println("the Array content in the exit file: ");
                    System.out.println("thre thread" + (i + 1) + " startPos:"
                            + startPos[i] + ", endPos: " + endPos[i]);
                }
            } else {
                System.out.println("the tmpfile is not available!!");
                rantmpfile = new RandomAccessFile(tmpfile, "rw");
                
                //���һ���̵߳Ľ�ֹλ�ô�СΪ������Դ�Ĵ�С
                for (int i = 0; i < threadNum; i++) {
                    startPos[i] = threadLength * i;
                    if (i == threadNum - 1) {
                        endPos[i] = fileLength;
                    } else {
                        endPos[i] = threadLength * (i + 1) - 1;
                    }

                    rantmpfile.seek(8 * i + 8);
                    rantmpfile.writeLong(startPos[i]);

                    rantmpfile.seek(8 * (i + 1000) + 16);
                    rantmpfile.writeLong(endPos[i]);

                    System.out.println("the Array content: ");
                    System.out.println("thre thread" + (i + 1) + " startPos:"
                            + startPos[i] + ", endPos: " + endPos[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rantmpfile != null) {
                    rantmpfile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /*
     * ʵ�����ع��ܵ��ڲ��࣬ͨ����ȡ�ϵ��������������������������䡣
     */
    class DownLoadThread implements Runnable {

        private long startPos;
        private long endPos;
        private MultiTheradDownLoad task = null;
        private RandomAccessFile downloadfile = null;
        private int id;
        private File tmpfile = null;
        private RandomAccessFile rantmpfile = null;
        private CountDownLatch latch = null;

        public DownLoadThread(long startPos, long endPos,
                MultiTheradDownLoad task, int id, File tmpfile,
                CountDownLatch latch) {
            this.startPos = startPos;
            this.endPos = endPos;
            this.task = task;
            this.tmpfile = tmpfile;
            try {
                this.downloadfile = new RandomAccessFile(this.task.filename,
                        "rw");
                this.rantmpfile = new RandomAccessFile(this.tmpfile, "rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {

            HttpURLConnection httpcon = null;
            InputStream is = null;
            int length = 0;

            System.out.println("the thread " + id + " has started!!");

            while (true) {
                try {
                    httpcon = (HttpURLConnection) task.url.openConnection();
                    setHeader(httpcon);
                    
                    //��ֹ��������������ָ���ĳ�ʱʱ�䣻��λ����ms������ָ��ʱ�䣬�ͻ��׳��쳣
                    httpcon.setReadTimeout(20000);//��ȡ���ݵĳ�ʱ����
                    httpcon.setConnectTimeout(20000);//���ӵĳ�ʱ����

                    if (startPos < endPos) {
                        
                        //�����������ָ������ε����ݣ�����ʵ�ֶϵ������ĸ�����
                        httpcon.setRequestProperty("Range", "bytes=" + startPos
                                + "-" + endPos);

                        System.out
                                .println("Thread " + id
                                        + " the total size:---- "
                                        + (endPos - startPos));

                        downloadfile.seek(startPos);

                        if (httpcon.getResponseCode() != HttpURLConnection.HTTP_OK
                                && httpcon.getResponseCode() != HttpURLConnection.HTTP_PARTIAL) {
                            this.task.bool = true;
                            httpcon.disconnect();
                            downloadfile.close();
                            System.out.println("the thread ---" + id
                                    + " has done!!");
                            latch.countDown();//�������Լ�
                            break;
                        }

                        is = httpcon.getInputStream();//��ȡ���������ص���Դ��
                        long count = 0l;
                        byte[] buf = new byte[1024];

                        while (!this.task.bool && (length = is.read(buf)) != -1) {
                            count += length;
                            downloadfile.write(buf, 0, length);
                            
                            //���ϸ���ÿ���߳�������Դ����ʼλ�ã���д����ʱ�ļ���Ϊ�ϵ�������׼��
                            startPos += length;
                            rantmpfile.seek(8 * id + 8);
                            rantmpfile.writeLong(startPos);
                        }
                        System.out.println("the thread " + id
                                + " total load count: " + count);
                        
                        //�ر���
                        is.close();
                        httpcon.disconnect();
                        downloadfile.close();
                        rantmpfile.close();
                    }
                    latch.countDown();//�������Լ�
                    System.out.println("the thread " + id + " has done!!");
                    break;
                } catch (IOException e) {
//                    e.printStackTrace();
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /*
     * Ϊһ��HttpURLConnectionģ������ͷ��αװ��һ�����������������
     */
    private void setHeader(HttpURLConnection con) {
        con.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.75 Safari/537.36");
        con.setRequestProperty("Accept", "image/webp,image/*,*/*;q=0.8");
//        con.setRequestProperty("Accept-Encoding", "aa");
//        con.setRequestProperty("Accept-Charset",
//                "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
//        con.setRequestProperty("Keep-Alive", "300");
//        con.setRequestProperty("Connection", "keep-alive");
//        con.setRequestProperty("If-Modified-Since",
//                "Fri, 02 Jan 2009 17:00:05 GMT");
//        con.setRequestProperty("If-None-Match", "\"1261d8-4290-df64d224\"");
//        con.setRequestProperty("Cache-Control", "max-age=0");
//        con.setRequestProperty("Referer",
//                "http://www.skycn.com/soft/14857.html");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		//http://ftp.kaist.ac.kr/eclipse/technology/epp/downloads/release/indigo/SR2/eclipse-jee-indigo-SR2-win32-x86_64.zip
		MultiTheradDownLoad mtd = new MultiTheradDownLoad("http://ftp.kaist.ac.kr/eclipse/technology/epp/downloads/release/indigo/SR2/eclipse-jee-indigo-SR2-win32-x86_64.zip", 1);
		mtd.downloadPart();
	}
}