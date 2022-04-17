/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @classDesc: ObjectLayout使用
 * @author vico
 * @createTime Apr 5, 2022 8:58:51 PM
 * @version v1.0.0
 */
public class ObjectLayout {
	
	public static void main(String[] args) {
		Object obj = new Object();
		String printable = ClassLayout.parseInstance(obj).toPrintable();
		System.out.println(printable);
		TypeClass tc = new TypeClass();
		printable = ClassLayout.parseInstance(tc).toPrintable();
		System.out.println(printable);
	}
}


class TypeClass {
	
	private  byte b = 1;
	private char c = 'a';
	private short so = 1;
	private Integer i = 128;
	private long l = 256;
	
	public TypeClass() {
		
	}
}
