/**
 * @createTime: Apr 5, 2022
 */
package com.swk.demo.test.juc;

/**
 * @classDesc: 交替输出 自定义CAS实现
 * @author vico
 * @createTime Apr 5, 2022 5:50:16 PM
 * @version v1.0.0
 */
public class InTurnPrintCas {

	static Thread t1 = null, t2= null;
	
	enum TreadEnum {
		T1,
		T2
	}
	
	static volatile TreadEnum toRun = TreadEnum.T1;
	
	public static void main(String[] args) {
		  t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
					try {
						for (int i = 0; i < 10; i++) {
							while (toRun != TreadEnum.T1) {};
							System.out.print(i);
							toRun = TreadEnum.T2;
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
								while (toRun != TreadEnum.T2) {};
								System.out.print(i);
								toRun = TreadEnum.T1;
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
