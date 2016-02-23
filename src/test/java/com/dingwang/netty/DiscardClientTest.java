/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty;

import org.junit.Test;

import com.dingwang.netty.client.ChannelPool;
import com.dingwang.netty.client.PersonClient;
import com.dingwang.netty.pojo.Person;

import io.netty.channel.Channel;

/**
 * 类DiscardClientTest.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午4:54:42
 */
public class DiscardClientTest {

    @Test
    public void start() throws InterruptedException {
        int port = 8080;
        String host = "localhost";

        new PersonClient(port, host).run();

        Channel channel = ChannelPool.getChannel();

        for (int i = 0; i < 3; i++) {
            Person p = new Person();
            p.setAge(i);
            p.setName("dw" + i);
            channel.writeAndFlush(p);
        }
        try {
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            channel.close();
        }

        //        while (true) {
        //
        //        }
    }
}
