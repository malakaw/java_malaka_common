package com.malaka.common;

import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common
 *创建日期：2013-12-31
 *作者：malaka.weng@vipshop.com
 */

@Data
public class Md5 {
	
	private String id;
	private String name;
	private String identity;
	
	
	public static void main(String[] args) {
		Md5 mm = new Md5();
		mm.setId("22");
		System.out.println(mm.getId());
	}
		
}
