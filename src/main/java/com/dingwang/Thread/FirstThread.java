/*
 * Copyright 2015 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * 类FirstThread.java的实现描述：TODO 类实现描述
 * 
 * @author dingwang 2015年10月13日 下午4:01:06
 */
public class FirstThread implements Runnable {

    private final CountDownLatch latch;

    public FirstThread(CountDownLatch latch) {
        this.latch = latch;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        System.out.println("the first thread is running!");
        latch.countDown();
        System.out.println("FirstThread----------->count=" + latch.getCount());
    }

    public static void main(String[] args) {
        Integer i = 7;
        Integer m = null;
        int k = 7;
        Integer j = new Integer(7);
        System.out.println("1".equals(null));
    }

}
