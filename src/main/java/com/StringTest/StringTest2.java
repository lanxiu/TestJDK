package com.StringTest;


public class StringTest2 {
		
		public static void main(String[] args)
        {
            String str1 = "ABCD1234";
            String str2 = "ABCD1234";
            String str3 = "ABCD";
            String str4 = "1234";
            String str5 = "ABCD" + "1234";
            String str6 = "ABCD" + str4;
            String str7 = str3 + str4;

            System.out.println("String str1 = \"ABCD1234\";");
            System.out.println("String str2 = \"ABCD1234\";");
            System.out.println("String str3 = \"ABCD\";");
            System.out.println("String str4 = \"1234\";");
            System.out.println("String str5 = \"ABCD\" + \"1234\";");
            System.out.println("String str6 = \"ABCD\" + str4;");
            System.out.println("String str7 = str3 + str4;");

            System.out.println("\n(str1, str2) = {0}:" + (str1== str2));
            System.out.println("(str1,  \"ABCD1234\") = {0}:"+ (str1 == "ABCD1234"));

            System.out.println("\n(str1, str5) = {0}:"+(str1==str5));
            System.out.println("(str1, str6) = {0}:"+(str1==str6));
            System.out.println("(str1, str7) = {0}:"+(str1==str7));

            System.out.println("\n(str1, String.Intern(str6)) = {0}:" + (str1== str6.intern()));
            System.out.println("(str1, String.Intern(str7)) = {0}:" + (str1== str7.intern()));
	}
}
