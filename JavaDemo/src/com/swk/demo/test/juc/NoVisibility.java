package com.swk.demo.test.juc;

/**
 * 测试不可见性
 *
 */
public class NoVisibility {

	static boolean ready = false;
	
	static int num;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new TestReadyThread();
		t.start();
		num = 42;
		ready = true;
		t.join();
		
	}
	
	static class TestReadyThread extends Thread {
		
		@Override
		public void run() {
			
			try {
				while (!ready) {
					 Thread.yield();
				}
				System.out.println(num);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	
}
