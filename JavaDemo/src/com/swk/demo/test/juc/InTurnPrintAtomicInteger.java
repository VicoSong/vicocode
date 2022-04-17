/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @classDesc: 交替输出 AtomicInteger实现
 * @author vico
 * @createTime Apr 5, 2022 5:50:16 PM
 * @version v1.0.0
 */
public class InTurnPrintAtomicInteger {

	static Thread t1 = null, t2= null;
	
	
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(1);
		
		  t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
					try {
						for (int i = 0; i < 10; i++) {
							while (ai.get() != 1) {}
							System.out.print(i);
							ai.set(2);
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
		  
		t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
							int len = 10 + 'A';
							for (char i = 'A'; i < len; i++) {
								while (ai.get() != 2) {}
								System.out.print(i);
								ai.set(1);
								
							}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			});
		
		t1.start();
		t2.start();
		
		
	}
	
}
