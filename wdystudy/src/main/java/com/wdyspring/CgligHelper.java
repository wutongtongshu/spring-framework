package com.wdyspring;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @创建人：吴德运
 * @创建时间 2019/1/16 19:38
 * @当前项目 spring
 * @描述：
 */
public class CgligHelper implements MethodInterceptor
{
	private Object target;

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
	{
		System.out.println("拦截器启动");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("拦截器停止");
		return result;
	}

	public Object getProxyObject(Object target)
	{
		Enhancer enhancer = new Enhancer();
		return enhancer.create(target.getClass(), null, this);
	}
}
