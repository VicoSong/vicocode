/**
 * @createTime: 2018年3月5日
 * @copyright: 新智认知数据服务有限公司
 */
package com.swk.interview.test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.Buffer;
import java.util.HashMap;

/**
 * @classDesc: 类描述: 对象clone
 *            有两种方式：
 *			  1). 实现Cloneable接口并重写Object类中的clone()方法；
 *             2). 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆
 * @author vico
 * @createTime 2018年3月5日 上午11:39:04
 * @version v1.0.0
 * @copyright: 新智认知数据服务有限公司
 */
public class ObjectClone {

	private ObjectClone()
	{
		throw new AssertionError();
	}
	
	public static <T> T clone(T obj) throws Exception
	{
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bout);
		oos.writeObject(obj);
		ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bin);
		return (T) ois.readObject();
		// 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
	   // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
	}
	
	
    public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
	
}
