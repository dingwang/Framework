/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.rpc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dingwang.rpc.decode.RpcDecoder;
import com.dingwang.rpc.encode.RpcEncoder;
import com.dingwang.rpc.pojo.RpcRequest;
import com.dingwang.rpc.pojo.RpcResponse;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 类RpcClient.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 下午4:22:51
 */
public class RpcClient extends SimpleChannelInboundHandler<RpcResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcClient.class);

    private String              host;
    private int                 port;

    private RpcResponse         response;

    private final Object        obj    = new Object();

    public RpcClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("client caught exception", cause);
        ctx.close();
    }

    public RpcResponse send(RpcRequest request) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel channel) throws Exception {
                    channel.pipeline().addLast(new RpcEncoder(RpcRequest.class)) // 将 RPC 请求进行编码（为了发送请求）
                            .addLast(new RpcDecoder(RpcResponse.class)) // 将 RPC 响应进行解码（为了处理响应）
                            .addLast(RpcClient.this); // 使用 RpcClient 发送 RPC 请求
                }
            }).option(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().writeAndFlush(request).sync();

            synchronized (obj) {
                obj.wait(); // 未收到响应，使线程等待
            }

            if (response != null) {
                future.channel().closeFuture().sync();
            }
            return response;
        } finally {
            group.shutdownGracefully();
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.SimpleChannelInboundHandler#messageReceived(io.netty.
     * channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, RpcResponse response) throws Exception {
        System.out.println("##########messageReceived");
        this.response = response;
        synchronized (obj) {
            obj.notifyAll(); // 收到响应，唤醒线程
        }

    }

    /**
     * -------------------------------------------------------------------------
     * netty5中messageReceived和channelRead方法是同一个意思，channelRead会覆盖messageReceived
     * -------------------------------------------------------------------------
     */

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.SimpleChannelInboundHandler#channelRead(io.netty.channel
     * .ChannelHandlerContext, java.lang.Object)
     */
    //    @Override
    //    public void channelRead(ChannelHandlerContext ctx, Object response) throws Exception {
    //        System.out.println("##########channelRead-----------response=" + response);
    //        this.response = (RpcResponse) response;
    //        synchronized (obj) {
    //            obj.notifyAll(); // 收到响应，唤醒线程
    //        }
    //    }

}
