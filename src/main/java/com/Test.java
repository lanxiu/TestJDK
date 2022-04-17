package com;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	
	public static void main(String[] args) {
		
//		Pattern pattern = Pattern.compile("(.*)(\\Q...a\\E).*");
//		// pattern = Pattern.compile("(.*).*");
//		Matcher matcher = pattern.matcher("00000000025@JIANGMENG4.COM.CN...aa");
//		System.out.println(matcher.matches());
//		System.out.println(matcher.groupCount());
//		System.out.println(matcher.group(1));
//		System.out.println(matcher.group(2));
//		String[] aa = { "1" };
//		Holder holder = new Holder(2);
//		holder.setAa(aa);
//		String[] bb = holder.getAa();
//		bb = new String[] { "2", "2" };
//		System.out.println(holder.getAa().length);
//		System.out.println(holder.getAa()[0]);
//		
		
		System.out.println(Runtime.getRuntime().maxMemory());
		
		String str = "19800309715";
		System.out.println(str.charAt(0));
	}
}
