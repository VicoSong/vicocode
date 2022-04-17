/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @classDesc: 交替输出 TransferQueue实现
 * @author vico
 * @createTime Apr 5, 2022 5:50:16 PM
 * @version v1.0.0
 */
public class InTurnPrintTransferQueue {

	static Thread t1 = null, t2= null;
	
	
	public static void main(String[] args) {
		TransferQueue<Character> tq = new LinkedTransferQueue<>();
		
		  t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
					try {
						for (int i = 0; i < 10; i++) {
							System.out.print(tq.take());
							tq.transfer(Character.valueOf((char)(i+'0')));
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
								tq.transfer(i);
								System.out.print(tq.take());
								
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
