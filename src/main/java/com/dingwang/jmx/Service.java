/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.jmx;

/**
 * 类Service.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年1月18日 下午8:49:36
 */
public class Service implements TestService {

    /*
     * (non-Javadoc)
     * @see com.dingwang.jmx.TestService#printService(java.lang.String)
     */
    @Override
    public void printService(String str) {
        // TODO Auto-generated method stub
        System.out.println("test service ####  =" + str);
    }

}
