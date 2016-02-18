/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.encoder;

import com.dingwang.netty.pojo.UnixTime;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/**
 * 类TimeEncoder.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午5:28:55
 */
public class TimeEncoder extends ChannelHandlerAdapter {

    /*
     * (non-Javadoc)
     * @see io.netty.channel.ChannelHandlerAdapter#write(io.netty.channel.
     * ChannelHandlerContext, java.lang.Object, io.netty.channel.ChannelPromise)
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("2222222222222");
        UnixTime m = (UnixTime) msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeInt(m.getValue());
        ctx.write(encoded, promise);
    }

}
