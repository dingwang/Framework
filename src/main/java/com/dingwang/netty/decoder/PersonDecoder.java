/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.decoder;

import java.util.List;

import com.dingwang.netty.pojo.Person;
import com.google.gson.Gson;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 类PersonDecoder.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 上午11:46:32
 */
public class PersonDecoder extends ByteToMessageDecoder {

    /*
     * (non-Javadoc)
     * @see io.netty.handler.codec.ByteToMessageDecoder#decode(io.netty.channel.
     * ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List)
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if (in == null || in.readableBytes() <= 0) {
            System.out.println("##################");
            return;
        }
        byte[] src = new byte[in.readableBytes()];

        in.readBytes(src);

        String message = new String(src, "UTF-8");

        Person p = new Gson().fromJson(message, Person.class);

        System.out.println("message======" + message);

        out.add(p);
    }

}
