package com.malaka.common.sort;
/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.sort
 *创建日期：2013-11-28
 *作者：malaka.weng@vipshop.com
 */
public class MString {
	/**
	 * @param a
	 * @param b
	 * @return返回a中包换b的次数
	 */
	public static int hasTimes(String a,String b)
	{
		return (a.length() - a.replaceAll(b,"").length())/b.length();
	}
	
	
	public static void main(String[] args) {
		String sample = "汤碗[7336]: 15646874,6326 15646876,4217 15647253,6326 15647749,4217 15647750,4217 ";
		System.out.println(MString.hasTimes(sample, ","));
	}
}
