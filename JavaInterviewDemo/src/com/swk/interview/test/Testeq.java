/**
 * @createTime: 2018年3月10日
 * @copyright: 新智认知数据服务有限公司
 */
package com.swk.interview.test;

/**
 * @classDesc: 类描述: TODO
 * @author vico
 * @createTime 2018年3月10日 上午9:13:07
 * @version v1.0.0
 * @copyright: 新智认知数据服务有限公司
 */
public class Testeq {

	private int age;
	private String name;
	public int hashCode()
	{
		final int base=31;
		int  result=1;
		result=result*base+age;
		result=result*base+(name==null?1:name.hashCode());
		return result;
	}
	
	public boolean equals(Object obj)
	{
		if(this==obj) 
		{
			return true;
		}
		if (obj==null) 
		{
			return false;
		}
		if(!this.getClass().equals(obj.getClass()))
		{
			return false;
		}
		
		Testeq  thisObj=(Testeq) obj;
		if(this.age!=thisObj.age)
		{
			return false;
		}
		if(!this.name.equals(thisObj.name))
		{
			return false;
		}
		return true;
	}
	
}
