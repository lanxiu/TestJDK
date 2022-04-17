import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;

public class Test3 {
	
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
		
		
		String vvv = "/%27%22%20onmouseover%3Dalert%28%29%20d%3D%27%22/?.tmp=t";
//		vvv = "/%2527%";
		for(byte b :vvv.getBytes()) {
//			System.out.println(b);
			System.out.print(Integer.toHexString(b) + ",");
			System.out.print(Short.parseShort(Integer.toHexString(b),16) + ",");
		}
		System.out.println();
		System.out.println(Short.parseShort("32", 16));
		System.out.println(Short.parseShort("35", 16));
		byte[] aa = {(byte)Short.parseShort("32", 16) ,(byte)Short.parseShort("35", 16)};
		System.out.println( " aa +" +new String(aa));
		
		byte bb[] = { 25,32,35,32,37,25,};
		System.out.println(new String(bb));
		try {
			System.out.println(URLDecoder.decode(vvv,"utf-8"));
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}

//		System.out.println(Runtime.getRuntime().maxMemory());
//		
//		System.out.println(Math.pow(2, 4));
//		System.exit(0);
//		new Thread().run();

	}
	@org.junit.Test
	public void a520() {
		System.out.println(217/2);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 108);
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	}

}
