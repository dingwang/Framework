/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.jmx;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 * 类HelloAgent.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年1月15日 下午4:05:24
 */
public class HelloAgent {

    public void start() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException,
            NotCompliantMBeanException {
        MBeanServer server = MBeanServerFactory.createMBeanServer();

        ObjectName helloName = new ObjectName("dingwang:name=HelloWorld");
        server.registerMBean(new Hello(), helloName);

        ObjectName adapterNmae = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterNmae);

        ObjectName serviceName = new ObjectName("servicename:name=service");
        server.registerMBean(new Service(), serviceName);

        adapter.start();
        System.out.println("----------start jmx-----------");

    }
}
