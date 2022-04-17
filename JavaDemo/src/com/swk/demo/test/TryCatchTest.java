/**
 * @createTime: 2018年3月5日
 */
package com.swk.demo.test;

/**
 * @classDesc: 类描述: 测试try catch finally
 * @author vico
 * @createTime 2018年3月5日 下午5:12:35
 * @version v1.0.0
 */
public class TryCatchTest {

	public  int  finallyRetrunTest(int n)
	{
		try {
			return 1/n;
		}/*catch(Exception e)
		{
			//System.exit(0);
			throw new RuntimeException(4+"");
			return 2;
		}*/finally {
			return  3;
		}
		
	}
	
	public static void main(String[] args) {
		TryCatchTest test =new TryCatchTest();
		System.out.println(test.finallyRetrunTest(0));
	}
}
