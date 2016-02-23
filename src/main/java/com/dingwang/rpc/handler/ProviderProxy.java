/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.rpc.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.dingwang.FactoryBean.HWFactoryBean;
import com.dingwang.rpc.pojo.RpcRequest;
import com.dingwang.rpc.pojo.RpcResponse;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

/**
 * 类ProviderProxy.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月23日 下午1:56:57
 */
public class ProviderProxy extends SimpleChannelInboundHandler<RpcRequest>
        implements FactoryBean<Object>, InitializingBean {

    public static final Logger log = LoggerFactory.getLogger(HWFactoryBean.class);

    /** 被代理对象实现的接口 */
    private String             interfaceName;

    /** 被代理的对象 */
    private Object             target;

    /** 生成的代理对象 */
    private Object             proxyObj;

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[] { Class.forName(interfaceName) }, new InvocationHandler() {

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        result = method.invoke(target, args);

                        return result;
                    }
                });
        log.info("afterPropertiesSet............");
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     */
    @Override
    public Object getObject() throws Exception {
        // TODO Auto-generated method stub
        return proxyObj;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     */
    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     */
    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.SimpleChannelInboundHandler#messageReceived(io.netty.
     * channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, RpcRequest request) throws Exception {
        System.out.println("-----------------------------------------server messageReceived");
        RpcResponse response = new RpcResponse();
        response.setRequestId(request.getRequestId());
        try {
            Object result = handle(request);
            response.setResult(result);
        } catch (Throwable t) {
            response.setError(t);
        }
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }

    private Object handle(RpcRequest request) throws Throwable {
        String className = request.getClassName();
        Object serviceBean = proxyObj;

        Class<?> serviceClass = serviceBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] parameters = request.getParameters();

        /*
         * Method method = serviceClass.getMethod(methodName, parameterTypes);
         * method.setAccessible(true); return method.invoke(serviceBean,
         * parameters);
         */

        FastClass serviceFastClass = FastClass.create(serviceClass);
        FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
        return serviceFastMethod.invoke(serviceBean, parameters);
    }

}
