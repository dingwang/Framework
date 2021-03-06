/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.string.format;

import java.util.Date;

import org.junit.Test;

/**
 * 类StringFormat.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 上午11:57:21
 */
public class StringFormat {

    @Test
    public void format() {

        System.out.println(String.format("hello,%tF", new Date()));

        System.out.println(String.format("hello,%1$s,%3$s", "dingwang", "", "welcome!"));

        System.out.println(String.format("hello,%010d%n", 123));

    }

}
