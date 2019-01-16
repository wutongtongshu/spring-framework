package com.wdyspring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @创建人：吴德运
 * @创建时间 2019/1/16 17:40
 * @当前项目 spring
 * @描述：
 */
public class ProxyHelper implements InvocationHandler
{
	private Object target;   //被代理对象

	/**
	 * 这个函数是被代理类隐式调用的
	 * @param proxy  代理类对象，这里没被使用
	 * @param method target 中的方法
	 * @param args target 中方法的参数
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println("代理实现开始");
		Object object = method.invoke(target, args);
		System.out.println("代理实现结束");
		return object;
	}

	/**
	 * 返回 target 的代理类,这个代理类跟 target 的类型是一样的。注意返回的类型不是ProxyHelper
	 * ProxyHelper 的 invoke()方法会被代理类调用，从而实现对 target 的增强。
	 */
	public Object getProxy(Object target)
	{
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
