/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Test.jmx;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

import org.junit.Test;

import com.dingwang.jmx.HelloAgent;

/**
 * 类JmxClient.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年1月15日 下午4:12:02
 */
public class JmxClient {

    @Test
    public void testJmx() {
        try {
            new HelloAgent().start();
            for (;;) {

            }
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException
                | NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }
}
