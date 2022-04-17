package com;
import java.io.File;
import java.io.FileFilter;

public class TestJDKCharacter {
	public static void main(String[] args) {
	 File dir = new File("/an/dir/");
	 FileFilter directoryFilter = (File f) -> f.isDirectory();
	 File[] dirs = dir.listFiles(directoryFilter);
	 

		System.out.print(System.currentTimeMillis());
}
}
