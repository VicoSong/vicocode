/**
 * @createTime: 2018年3月10日
 * @copyright: 新智认知数据服务有限公司
 */
package com.swk.interview.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @classDesc: 类描述: cglib动态代理
 * @author vico
 * @createTime 2018年3月10日 上午8:27:41
 * @version v1.0.0
 * @copyright: 新智认知数据服务有限公司
 */
public class CglibProxy implements MethodInterceptor{

	private Object target;
	public  Object newInstance(Object target) {
		this.target=target;
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(target.getClass().getSuperclass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		methodProxy.invokeSuper(obj, args);
		return null;
	}

}
