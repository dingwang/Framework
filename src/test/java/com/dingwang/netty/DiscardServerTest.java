/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty;

import org.junit.Test;

import com.dingwang.netty.server.DiscardServer;

/**
 * 类DiscardServerTest.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午3:18:10
 */
public class DiscardServerTest {

    @Test
    public void start() throws InterruptedException {
        int port = 8080;
        new DiscardServer(port).run();
    }

}
