/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.rpc.service;

/**
 * 类HelloService.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 下午3:14:36
 */
public interface HelloService {

    String hello(String name);

    String hello(String name, int age);

    String hello(String name, String sex);
}
