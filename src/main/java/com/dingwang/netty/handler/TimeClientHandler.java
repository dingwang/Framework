/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.handler;

import com.dingwang.netty.pojo.UnixTime;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 类TimeClientHandler.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午4:46:46
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

    /*
     * (non-Javadoc)
     * @see io.netty.channel.ChannelHandlerAdapter#channelRead(io.netty.channel.
     * ChannelHandlerContext, java.lang.Object)
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //        ByteBuf m = (ByteBuf) msg;
        //
        //        try {
        //            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
        //            System.out.println(new Date(currentTimeMillis));
        //            ctx.close();
        //        } finally {
        //            m.release();
        //        }
        UnixTime m = (UnixTime) msg;
        System.out.println(String.format("m%s", m.toString()));
        ctx.close();
    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.ChannelHandlerAdapter#exceptionCaught(io.netty.channel.
     * ChannelHandlerContext, java.lang.Throwable)
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
