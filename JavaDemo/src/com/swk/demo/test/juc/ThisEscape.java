package com.swk.demo.test.juc;

import java.io.IOException;

/**
 * @classDesc:  this 逃逸 来自effective java
 * @author vico
 * @createTime Apr 4, 2022 7:47:01 PM
 * @version v1.0.0
 */
public class ThisEscape {

	private int num = 8;
	
	public ThisEscape() {
		new Thread(() -> {
			System.out.println(this.num);
		}).start();
	}
	
	public static void main(String[] args) throws IOException {
		new ThisEscape();
		System.in.read();
		
		
	}
	
}
