package com.swk.demo.test.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 测试指令重排
 *
 */
public class DisOrderDemo {

	private static Integer a = 0, b=0;
	
	private static Integer x = 0, y=0;
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0 ; i< Integer.MAX_VALUE; i++) {
			a = 0;
			b = 0;
			x = 0;
			y = 0;
			
			CountDownLatch latch = new CountDownLatch(2);
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					a = 1;
					x = b;
					latch.countDown();
				}
			});
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					b = 1;
					y = a;
					latch.countDown();
				}
			});
			t1.start();
			t2.start();
			latch.await();
			// 如果没有指令重排不会出现 x=0 y=0的情况
			if (x == 0 && y ==0) {
				System.out.println(String.format("第%d次x、y同时为0", i));
				break;
			}
		}
		
		
		
		
	}
	
	
}
