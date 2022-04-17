/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @classDesc: 交替输出 synchronized wait notify实现
 * @author vico
 * @createTime Apr 5, 2022 5:50:16 PM
 * @version v1.0.0
 */
public class InTurnPrintSyncWaitNotify2 {

	static CountDownLatch cdl = new CountDownLatch(1);
	
	public static void main(String[] args) {
		 final Object obj = new Object();
		 new Thread(() -> {
				try {
					cdl.await();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				synchronized (obj) {
						for (int i = 0; i < 10; i++) {
							System.out.print(i);
							try {
								obj.notify();
								obj.wait();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					obj.notify();
				}
		}, "t1").start();
		  
		new Thread(() -> {
					synchronized (obj) {
						int len = 10 + 'A';
						for (char i = 'A'; i < len; i++) {
							System.out.print(i);
							cdl.countDown();
							try {
								obj.notify();
								obj.wait();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						obj.notify();
					}
			}, "t2").start();
	}
	
}
