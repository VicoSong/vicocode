/**
 * @createTime: Apr 4, 2022
 */
package com.swk.demo.test.philosophersproblem;

import cn.hutool.core.thread.ThreadUtil;

/**
 * @classDesc: 哲学家就餐问题-死锁演示
 * @author vico
 * @createTime Apr 4, 2022 6:15:42 PM
 * @version v1.0.0
 */
public class DeadLock {
	
	public static void main(String[] args) {
		ChopStick cs1 = new ChopStick();
		ChopStick cs2 = new ChopStick();
		ChopStick cs3 = new ChopStick();
		ChopStick cs4 = new ChopStick();
		ChopStick cs5 = new ChopStick();
		// 从左手边开始拿筷子
		Philopher p1 = new Philopher("p1", 1, cs1, cs2);
		Philopher p2 = new Philopher("p2",2, cs2, cs3);
		Philopher p3 = new Philopher("p3",3, cs3, cs4);
		Philopher p4 = new Philopher("p4",4, cs4, cs5);
		Philopher p5 = new Philopher("p5",5, cs5, cs1);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		
		
		
	}
	

	/**
	 * @classDesc: 会发生死锁 解决方案 : 1.给筷子加个整体锁  2.引入左撇子
	 * @author vico
	 * @createTime Apr 5, 2022 5:37:42 PM
	 * @version v1.0.0
	 */
	static class Philopher extends Thread {
		
		private ChopStick left, right;
		
		private int index;
		
		public Philopher(String name, int index, ChopStick left, ChopStick right) {
			this.setName(name);
			this.index = index;
			this.left = left;
			this.right = right;
		}

		@Override
		public void run() {
			synchronized (left) {
				System.out.println(index+"号哲学家获取到左边的筷子");
				ThreadUtil.sleep(1+index);
				synchronized (right) {
					ThreadUtil.sleep(1L);
					System.out.println(index +"号哲学家已经吃完");
				}
			}
			
			
		}
	}


	/**
	 * @classDesc: 引入左撇子解决问题
	 * @author vico
	 * @createTime Apr 5, 2022 5:37:07 PM
	 * @version v1.0.0
	 */
	static class PhilopherOpen extends Thread {
		
		private ChopStick left, right;
		
		private int index;
		
		public PhilopherOpen(String name, int index, ChopStick left, ChopStick right) {
			this.setName(name);
			this.index = index;
			this.left = left;
			this.right = right;
		}

		@Override
		public void run() {
			
			if (index%2 == 0) {
				synchronized (left) {
					System.out.println(index+"号哲学家获取到左边的筷子");
					ThreadUtil.sleep(1+index);
					synchronized (right) {
						ThreadUtil.sleep(1L);
						System.out.println(index +"号哲学家已经吃完");
					}
				}
				
			} else {
			    // 左撇子先取右边筷子再取左边
				synchronized (right) {
					System.out.println(index+"号哲学家获取到左边的筷子");
					ThreadUtil.sleep(1+index);
					synchronized (left) {
						ThreadUtil.sleep(1L);
						System.out.println(index +"号哲学家已经吃完");
					}
				}
				
			}
			
			
			
			
		}
	}
	
	
}
