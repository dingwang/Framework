/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.handler;

import com.dingwang.netty.pojo.UnixTime;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 类DiscardServerHandler.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午3:04:38
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {

    /*
     * (non-Javadoc)
     * @see io.netty.channel.ChannelHandlerAdapter#channelRead(io.netty.channel.
     * ChannelHandlerContext, java.lang.Object)
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //        ByteBuf in = (ByteBuf) msg;

        //        try {
        //将收到的消息打印到控制台
        //            StringBuilder sb = new StringBuilder();
        //            while (in.isReadable()) {
        //                sb.append((char) in.readByte());
        //            }
        //            System.out.println(sb.toString());

        //        } catch (Exception e) {
        //            ReferenceCountUtil.release(msg);
        //        }

        //对消息作出相应
        //ctx.write(Object)方法不会使消息写入到通道上，他被缓冲在了内部，你需要调用ctx.flush()方法来把缓冲区中数据
        //强行输出。或者你可以用更简洁的cxt.writeAndFlush(msg)以达到同样的目的。
        ctx.writeAndFlush(msg);
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

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.ChannelHandlerAdapter#channelActive(io.netty.channel.
     * ChannelHandlerContext)
     */
    @Override
    //channelActive()方法将会在连接被建立并且准备进行通信时被调用。因此让我们在这个方法里完成一个代表当前时
    //间的32位整数消息的构建工作。
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        //为了发送一个新的消息，我们需要分配一个包含这个消息的新的缓冲。因为我们需要写入一个32位的整数，因此我
        //们需要一个至少有4个字节的ByteBuf。通过ChannelHandlerContext.alloc()得到一个当前的ByteBufAllocator，然
        //后分配一个新的缓冲。
        //        final ByteBuf time = ctx.alloc().buffer(4);
        //        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        //另外一个点需要注意的是ChannelHandlerContext.write()(和
        //writeAndFlush())方法会返回一个ChannelFuture对象，一个ChannelFuture代表了一个还没有发生的I/O操作。这
        //意味着任何一个请求操作都不会马上被执行，因为在Netty里所有的操作都是异步的。举个例子下面的代码中在消
        //息被发送之前可能会先关闭连接。
        //因此你需要在write()方法返回的ChannelFuture完成后调用close()方法，然后当他的写操作已经完成他会通知他的
        //监听者。请注意,close()方法也可能不会立马关闭，他也会返回一个ChannelFuture。
        //        final ChannelFuture f = ctx.writeAndFlush(time);

        //当一个写请求已经完成是如何通知到我们？这个只需要简单地在返回的ChannelFuture上增加一
        //个ChannelFutureListener。这里我们构建了一个匿名的ChannelFutureListener类用来在操作完成时关闭
        //Channel。或者，你可以使用简单的预定义监听器代码:
        //f.addListener(ChannelFutureListener.CLOSE);
        //        f.addListener(new ChannelFutureListener() {
        //            @Override
        //
        //            public void operationComplete(ChannelFuture future) {
        //                assert f == future;
        //                ctx.close();
        //
        //            }
        //        });

        System.out.println("1111111111111111111");
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);

    }
}
