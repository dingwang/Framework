/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.client;

import com.dingwang.netty.decoder.PersonDecoder;
import com.dingwang.netty.encoder.PersonEncoder;
import com.dingwang.netty.handler.PersonInHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 类DiscardClient.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午4:37:39
 */
public class PersonClient {

    private int    port;

    private String host;

    public PersonClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void run() {
        EventLoopGroup workerGroup = new NioEventLoopGroup(10);

        //BootStrap和ServerBootstrap类似,不过他是对非服务端的channel而言，比如客户端或者无连接传输模式的channel。
        Bootstrap b = new Bootstrap();

        //如果你只指定了一个EventLoopGroup，那他就会即作为一个‘boss’线程，也会作为一个‘workder’线程，尽管客户
        //端不需要使用到‘boss’线程。
        b.group(workerGroup);

        //代替NioServerSocketChannel的是NioSocketChannel,这个类在客户端channel被创建时使用。
        b.channel(NioSocketChannel.class);

        //不像在使用ServerBootstrap时需要用childOption()方法，因为客户端的SocketChannel没有父channel的概念。
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new PersonEncoder(), new PersonDecoder(), new PersonInHandler());
            }
        });

        ChannelFuture f;
        try {
            //我们用connect()方法代替了bind()方法。
            f = b.connect(host, port).sync();
            ChannelPool.setChannel(f.channel());
            //            Person p = new Person();
            //            p.setAge(10);
            //            p.setName("dw");
            //            f.channel().writeAndFlush(p);

            //            Thread.currentThread().sleep(1000);
            //
            //            p.setName("test");
            //            f.channel().writeAndFlush(p);
            //            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //            workerGroup.shutdownGracefully();
        }
    }

}
