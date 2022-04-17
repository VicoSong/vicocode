/**
 * @createTime: Apr 16, 2022
 */
package com.swk.demo.test.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @classDesc: 进入到bin目录 找到jvisualVM.exe 
 * 如果没有visualGC 则点击 工具》》插件 》》 可用插件 安装
 * @author vico
 * @createTime Apr 16, 2022 2:29:44 PM
 * @version v1.0.0
 */
public class TestVisualVM {

	public static void main(String[] args) {
		List<Long> ll = new ArrayList<>();
		for(long i=0; i<Long.MAX_VALUE; i++) {
			ll.add(i);
			try {
				if (i < 3) {
					TimeUnit.SECONDS.sleep(10);
				} else {
					TimeUnit.MILLISECONDS.sleep(1);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
