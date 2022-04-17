import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * @文 件 名: Copy21.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2019年7月16日 上午10:10:19
 */
/**
 * @文 件 名: Copy21.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2019年7月16日 上午10:10:19
 */
public class Copy21 {
	
	
	
	public static void main(String[] args) {
		Copy21 cc = new Copy21();

//		cc.dir("F:\\workspace\\huanfang");
//		cc.dir("F:\\workspace\\Reactor");
//		cc.dir("F:\\workspace\\git\\site\\spring-boot-sample-web-jsp");
//		cc.dir("F:\\workspace\\TestJDK");
//		cc.dir("F:\\workspace\\TestJvm");
//		cc.dir("F:\\workspace\\Vue");
		cc.dir("F:\\work2\\10_python\\python");
		 
	}
	
	private String fileDir = null;
	private OutputStreamWriter		fw	= null;
	private  BufferedWriter	bw	= null;
	
	public   Copy21( ) {
		try {
			File file = new File("D:/1.txt");
			file.delete();
			
			fw =    new OutputStreamWriter(new FileOutputStream(file), "utf-8");
			bw = new BufferedWriter(fw);
		} catch  (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 功能简述: 遍历当前目录下的所有文件，并整理为一
	 * 
	 * @author 0216000799
	 * @version 1.0
	 * @since 1.0
	 * @param dir
	 */
	public void dir(String dir) {
		
		System.out.println("处理目录:" + dir);
		
		if(dir.endsWith("bin") || dir.endsWith(".settings") || dir.endsWith("target")|| dir.endsWith("lib")) {
			return;
		}
		
		
		File dirFile = new File(dir);
		for (File file : dirFile.listFiles()) {
			if (file.isDirectory()) {
				dir(file.getAbsolutePath());
				continue;
			}
			copy2One(file);
		}
		try {
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	
	/**
	 * 功能简述:写入一个文件
	 * 
	 * @author 0216000799
	 * @version 1.0
	 * @since 1.0
	 * @param file
	 */
	private void copy2One(File file) {
		try {
			

			System.out.println("处理文件:" + file.getAbsolutePath());
			
			bw.newLine();
			bw.append("********************************************\r\n");
			bw.append("###" + file.getAbsolutePath() + "###\r\n");
			bw.append("********************************************\r\n");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
			String line = "";
			while ((line = br.readLine()) != null) {
				bw.append("\r\n");
				bw.append(line);
				
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
