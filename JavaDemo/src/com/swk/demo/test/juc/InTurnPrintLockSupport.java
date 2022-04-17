/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @classDesc: 交替输出locksupport实现
 * @author vico
 * @createTime Apr 5, 2022 5:50:16 PM
 * @version v1.0.0
 */
public class InTurnPrintLockSupport {

	static Thread t1 = null, t2= null;
	
	public static void main(String[] args) {
		
		  t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.print(i);
					// 先唤醒其他线程再挂起自己
					LockSupport.unpark(t2);
					LockSupport.park();
				}
				
			}
		});
		  
		t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					int len = 10 + 'A';
					for (char i = 'A'; i < len; i++) {
						LockSupport.park();
						System.out.print(i);
						LockSupport.unpark(t1);
						
						
					}
					
				}
			});
		
		t1.start();
		t2.start();
		
		
	}
	
}
