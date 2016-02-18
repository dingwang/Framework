/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty;

import org.junit.Test;

import com.dingwang.netty.client.DiscardClient;

/**
 * 类DiscardClientTest.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午4:54:42
 */
public class DiscardClientTest {

    @Test
    public void start() {
        int port = 8080;
        String host = "localhost";

        //        new DiscardClient(port, host).run();
        for (int i = 0; i < 100; i++) {
            new clientThread(port, host).start();
        }

        while (true) {

        }
    }

    class clientThread extends Thread {

        private int    port;

        private String host;

        public clientThread(int port, String host) {
            this.port = port;
            this.host = host;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            new DiscardClient(port, host).run();
        }
    }
}
