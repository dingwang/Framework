/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.decoder;

import java.util.List;

import com.dingwang.netty.pojo.UnixTime;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 类TimeDecoder.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午5:18:20
 */
public class TimeDecoder extends ByteToMessageDecoder {

    /*
     * (non-Javadoc)
     * @see io.netty.handler.codec.ByteToMessageDecoder#decode(io.netty.channel.
     * ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List)
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if (in.readableBytes() < 4) {
            return;
        }
        out.add(new UnixTime(in.readInt()));
    }

}
