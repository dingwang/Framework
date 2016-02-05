/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.jmx;

/**
 * 类HelloMBean.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年1月15日 下午4:03:48
 */
public interface HelloMBean {

    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(Student student);

}
