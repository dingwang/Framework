/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.dingwang.FactoryBean.HWFactoryBean;
import com.dingwang.rpc.client.RpcClient;
import com.dingwang.rpc.pojo.RpcRequest;
import com.dingwang.rpc.pojo.RpcResponse;

/**
 * 类ConsumerProxy.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月23日 上午11:44:29
 */
public class ConsumerProxy implements FactoryBean<Object>, InitializingBean {
    public static final Logger log = LoggerFactory.getLogger(HWFactoryBean.class);

    /** 被代理对象实现的接口 */
    private String             interfaceName;

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
                        RpcRequest request = new RpcRequest(); // 创建并初始化 RPC 请求
                        request.setRequestId(UUID.randomUUID().toString());
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);

                        RpcClient client = new RpcClient("localhost", 8000); // 初始化 RPC 客户端
                        RpcResponse response = client.send(request); // 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应

                        if (false) {
                            //                        if (response.isError()) {
                            throw response.getError();
                        } else {
                            return response.getResult();
                        }

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
        return true;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

}
