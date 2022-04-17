/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @classDesc: 三个线程交替输出ABC Lock Condition 实现
 * @author vico
 * @createTime Apr 5, 2022 5:50:16 PM
 * @version v1.0.0
 */
public class InTurnPrintLockCondition3 {

	static Thread t1 = null, t2= null, t3 = null;
	
	static CountDownLatch cdl = new CountDownLatch(1);
	
	static CountDownLatch cd2 = new CountDownLatch(1);
	
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition(); 
		Condition condition2 = lock.newCondition(); 
		Condition condition3 = lock.newCondition(); 
		// 打印A 
		  t1 = new Thread(new Runnable() {
			@Override
			public void run() {
					try {
						lock.lock();
						for (int i = 0; i < 10; i++) {
							System.out.print("A");
							if (i == 0) {
								cdl.countDown();
							}
							condition2.signal();
							condition1.await();
						}
						condition2.signal();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
			}
		});
		// 打印B 
		t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					
					try {
						cdl.await();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					lock.lock();
					try {
							int len = 10 + 'A';
							for (char i = 'A'; i < len; i++) {
								System.out.print("B");
								if (i == 'A') {
									cd2.countDown();
								}
								condition3.signal();
								condition2.await();
							}
							condition3.signal();
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						lock.unlock();
					}
				}
			
			});
		
		// 打印C 
		t3 = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							cd2.await();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
						lock.lock();
						try {
								int len = 10 + 'A';
								for (char i = 'A'; i < len; i++) {
									System.out.println('C');
									condition1.signal();
									condition3.await();
								}
								condition1.signal();
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							lock.unlock();
						}
					}
				
				});
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
}
