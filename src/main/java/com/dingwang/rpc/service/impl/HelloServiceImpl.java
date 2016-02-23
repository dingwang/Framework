/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.rpc.service.impl;

import org.springframework.stereotype.Component;

import com.dingwang.Annotion.RpcService;
import com.dingwang.rpc.service.HelloService;

/**
 * 类HelloServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 下午3:15:38
 */
@RpcService(HelloService.class)
@Component("helloService") // 表明可被 Spring 扫描
public class HelloServiceImpl implements HelloService {

    /*
     * (non-Javadoc)
     * @see com.dingwang.rpc.service.HelloService#hello(java.lang.String)
     */
    @Override
    public String hello(String name) {
        return "Hello!" + name;
    }

    /*
     * (non-Javadoc)
     * @see com.dingwang.rpc.service.HelloService#hello(java.lang.String, int)
     */
    @Override
    public String hello(String name, int age) {
        return "Hello,my name is " + name + "and my age is " + age;
    }

    /*
     * (non-Javadoc)
     * @see com.dingwang.rpc.service.HelloService#hello(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String hello(String name, String sex) {
        return sex;
    }

}
