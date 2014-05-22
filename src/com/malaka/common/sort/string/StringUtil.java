package com.malaka.common.sort.string;

public class StringUtil {
	
	
	
	public static String[] getArrayStr(String str ,int length)
	{
		str = str.replaceAll("(\\\\')+", "").replaceAll("/", "");
		boolean hasTaht = false;
		int position    = 0;
		String[] array = new String[length];
		int count = 0;
		for(int i=0;i<str.length();i++)
		{
			//ascii码  ' is 39 
			if(39 == str.charAt(i))
			{
				if(hasTaht)
					hasTaht = false;
				else
					hasTaht = true;
			}
			//ascii码  , is 39 
			if(str.charAt(i) == 44)
			{
				if(!hasTaht)
				{
					array[count++] = str.substring(position, (i)).replace("'", "");
					position = i+1;
				}
			}
		}
		
		array[length-1] = str.substring(position, str.length()).replace("'", "");
		return array;
	}
	
	public static void main(String[] args) {
		String s1 = "124966,171584,'发饰','Q\\'GGLE/娇酷','大众','女','','咖啡色','发饰,纯手工,天然树脂','','2014-05-09 08:12:36'";
//		//s1 = s1.replace("/", "");
//		System.out.println(s1);
//		s1 = s1.replaceAll("(\\\\')+", "");
//		System.out.println(s1);
		for(String s: getArrayStr(s1,11))
		{
			System.out.println(s);
		}
		
//		String s1 = "124966,171584,'发饰','Q\\'GGLE/娇酷'";
//		s1 = s1.replaceAll("(\\\\')+", "");
//		System.out.println(s1);
	}
	
}
