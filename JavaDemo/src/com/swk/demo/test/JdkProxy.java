/**
 * @createTime: 2018年3月10日
 */
package com.swk.demo.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;

/**
 * @classDesc: 类描述: JDK动态代理
 * @createTime 2018年3月10日 上午8:19:58
 * @version v1.0.0
 */
public class JdkProxy implements InvocationHandler{

	private Object target;
	
	public Object bind(Object target)
	{
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		method.invoke(proxy, args);
		return null;
	}
	
	
}
