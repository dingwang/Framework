/*
 * Copyright 2015 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.dingwang.aop.HelloWorldAop;

/**
 * 类HWFactoryBean.java的实现描述：TODO 类实现描述
 * 
 * @author dingwang 2015年10月21日 上午10:45:14
 */
public class HWFactoryBean implements FactoryBean<Object>, InitializingBean {

    public static final Logger                       log = LoggerFactory.getLogger(HWFactoryBean.class);

    /** 被代理对象实现的接口 */
    private String                                   interfaceName;

    /** 被代理的对象 */
    private Object                                   target;

    /** 生成的代理对象 */
    private Object                                   proxyObj;

    /** 要处理的代理对象中的方法，若为空，则处理所有方法 */
    private Map<String/* 代理对象的方法名 */, HelloWorldAop> proxyMethodMap;

    /**
     * @return the proxyMethodMap
     */
    public Map<String, HelloWorldAop> getProxyMethodMap() {
        return proxyMethodMap;
    }

    /**
     * @param proxyMethodMap the proxyMethodMap to set
     */
    public void setProxyMethodMap(Map<String, HelloWorldAop> proxyMethodMap) {
        this.proxyMethodMap = proxyMethodMap;
    }

    /**
     * @return the interfaceName
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * @param interfaceName the interfaceName to set
     */
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    /**
     * @return the target
     */
    public Object getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Object target) {
        this.target = target;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[] { Class.forName(interfaceName) }, new InvocationHandler() {

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        String methodName = method.getName();
                        log.info("method:" + method.getName());
                        //判断此方法是否需要做处理
                        if (proxyMethodMap != null && proxyMethodMap.containsKey(methodName)) {
                            //做before处理
                            proxyMethodMap.get(methodName).doBefore(args);
                            result = method.invoke(target, args);
                            //做after处理
                            proxyMethodMap.get(methodName).doAfter(args);
                        } else {
                            result = method.invoke(target, args);
                        }

                        return result;
                    }
                });
        log.info("afterPropertiesSet............");
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     */
    public Object getObject() throws Exception {
        log.info("get the proxy Object");
        return proxyObj;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     */
    public Class<?> getObjectType() {
        log.info("get the proxy Object class");
        return proxyObj == null ? Object.class : proxyObj.getClass();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     */
    public boolean isSingleton() {
        log.info("this is a Singleton");
        return true;
    }

}
