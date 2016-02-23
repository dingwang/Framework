/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.client;

import io.netty.channel.Channel;

/**
 * 类ChannelPool.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 下午6:32:11
 */
public class ChannelPool {

    private static Channel channel;

    public static Channel getChannel() {
        return channel;
    }

    public static void setChannel(Channel channel) {
        ChannelPool.channel = channel;
    }
}
