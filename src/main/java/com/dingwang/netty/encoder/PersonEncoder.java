/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.encoder;

import com.dingwang.netty.pojo.Person;
import com.google.gson.Gson;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 类PersonEncoder.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 上午11:38:02
 */
public class PersonEncoder extends MessageToByteEncoder<Person> {

    /*
     * (non-Javadoc)
     * @see io.netty.handler.codec.MessageToByteEncoder#encode(io.netty.channel.
     * ChannelHandlerContext, java.lang.Object, io.netty.buffer.ByteBuf)
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf out) throws Exception {

        Gson gson = new Gson();
        String str = gson.toJson(msg);
        System.out.println("str===" + str);

        byte[] src = str.getBytes("UTF-8");

        out.writeBytes(src);
    }

}
