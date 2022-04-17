/**
 * @createTime: 2018年3月5日
 */
package com.swk.demo.test;

/**
 * @classDesc: 类描述: String/StringBuffer/StringBuilder 相关测试
 * @author vico
 * @createTime 2018年3月5日 上午10:39:48
 * @version v1.0.0
 */
public class StringTest {

	public void stringEqualTest() {
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
	}
	
	public String reverse(String originStr) {
	      if(originStr == null || originStr.length() <= 1) 
	          return originStr;
	      return reverse(originStr.substring(1)) + originStr.charAt(0);
	  }
}
