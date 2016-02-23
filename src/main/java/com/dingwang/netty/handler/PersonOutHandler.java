/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.handler;

import com.dingwang.netty.pojo.Person;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 类PersonOutHandler.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 上午11:40:45
 */
public class PersonOutHandler extends ChannelHandlerAdapter {

    /*
     * (non-Javadoc)
     * @see io.netty.channel.ChannelHandlerAdapter#channelRead(io.netty.channel.
     * ChannelHandlerContext, java.lang.Object)
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("channelRead===" + msg.toString());

        Person p = (Person) msg;
        p.setName("dingwang");
        ctx.writeAndFlush(p);

    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.ChannelHandlerAdapter#exceptionCaught(io.netty.channel.
     * ChannelHandlerContext, java.lang.Throwable)
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // TODO Auto-generated method stub
        super.exceptionCaught(ctx, cause);
        //        ctx.close();
    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.ChannelHandlerAdapter#channelActive(io.netty.channel.
     * ChannelHandlerContext)
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("server active");
    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.ChannelHandlerAdapter#channelInactive(io.netty.channel.
     * ChannelHandlerContext)
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server inactive");
    }
}
