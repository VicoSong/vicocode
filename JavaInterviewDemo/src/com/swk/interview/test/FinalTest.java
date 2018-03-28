/**
 * @createTime: 2018年3月5日
 * @copyright: 新智认知数据服务有限公司
 */
package com.swk.interview.test;

/**
 * @classDesc: 类描述: final测试
 * @author vico
 * @createTime 2018年3月5日 下午5:26:08
 * @version v1.0.0
 * @copyright: 新智认知数据服务有限公司
 */
public class FinalTest {

	private final int a=10;
	public void finalTest()
	{
		final int b;
		b=12;
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
	public static void main(String[] args) {
		FinalTest test =new FinalTest();
		test.finalTest();
	}
}
