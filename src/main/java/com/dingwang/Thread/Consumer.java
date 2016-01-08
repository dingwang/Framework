/*
 * Copyright 2015 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 类Consumer.java的实现描述：TODO 类实现描述
 * 
 * @author dingwang 2015年10月14日 下午3:27:19
 */
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> shareQueue;

    public Consumer(BlockingQueue<Integer> shareQueue) {
        this.shareQueue = shareQueue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        int i;
        while (true) {
            try {
                i = shareQueue.take();
                System.out.println("##########Consumer=" + i + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        BlockingQueue<Integer> shareQueue1 = new LinkedBlockingQueue<Integer>();
        new Thread(new Producer(shareQueue1)).start();
        new Thread(new Consumer(shareQueue1)).start();
        new Thread(new Consumer(shareQueue1)).start();
        new Thread(new Consumer(shareQueue1)).start();
    }

}
