/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.juc;

/**
 * @classDesc: 交替输出 synchronized wait notify实现
 * @author vico
 * @createTime Apr 5, 2022 5:50:16 PM
 * @version v1.0.0
 */
public class InTurnPrintSyncWaitNotify {

	static Thread t1 = null, t2= null;
	
	public static void main(String[] args) {
		 final Object obj = new Object();
		  t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (obj) {
					try {
						for (int i = 0; i < 10; i++) {
							System.out.print(i);
							obj.notify();
							obj.wait();
						}
						obj.notify();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		  
		t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						synchronized (obj) {
							int len = 10 + 'A';
							for (char i = 'A'; i < len; i++) {
								System.out.print(i);
								obj.notify();
								obj.wait();
							}
							obj.notify();
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
