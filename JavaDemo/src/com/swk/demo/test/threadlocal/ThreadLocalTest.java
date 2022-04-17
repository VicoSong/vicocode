/**
 * @createTime: Apr 9, 2022
 */
package com.swk.demo.test.threadlocal;

import cn.hutool.core.thread.ThreadUtil;

/**
 * @classDesc: TODO
 * @author vico
 * @createTime Apr 9, 2022 11:49:29 AM
 * @version v1.0.0
 */
public class ThreadLocalTest {
	
	static final ThreadLocal<Object> tl = ThreadLocal.withInitial(() ->{
		return   new String("ni hao");
	});	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				String ss = new String("hello");
				tl.set(ss);
				while (true) {
					ThreadUtil.sleep(100);
					System.out.println(tl.get());
				}
			}
		});
		t1.start();
		ThreadUtil.sleep(500);
		tl.remove();
		System.out.println("t1 remove");
	}
	

}
