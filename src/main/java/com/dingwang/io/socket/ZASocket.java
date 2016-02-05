/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.io.socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 类ZASocket.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月5日 下午3:32:40
 */
public class ZASocket {
    public static final String GREETING = "Hello I must be going.\r\n";

    public static void send() throws IOException, InterruptedException {
        //        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("localhost", 8088));
        while (!sc.finishConnect()) {
            System.out.println("do not finish connect");
            Thread.sleep(1 * 1000);
        }
        //        buffer.rewind();
        //        sc.write(buffer);
        //        sc.close();

        OutputStream out = null;
        for (int i = 0; i < 10; i++) {
            String message = "Hello";
            message += i;
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            sc.write(buffer);
        }
        sc.close();

    }

    public static void get() throws IOException, InterruptedException {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[1024]);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress("localhost", 8088));
        ssc.configureBlocking(false);
        while (true) {
            System.out.println("Waiting for connections");
            SocketChannel sc = ssc.accept();
            //            sc.connect(new InetSocketAddress("localhost", 8080));
            if (sc == null) {
                Thread.sleep(2 * 1000);
            } else {
                int n = 0;
                InputStream in = new BufferedInputStream(sc.socket().getInputStream());
                String str = "";
                while ((n = in.read()) != -1) {
                    str += (char) n;
                }
                System.out.println("accept context=" + str);
                System.out.println("Incoming connection from: " + sc.socket().getRemoteSocketAddress());
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    send();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

        //

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    get();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
