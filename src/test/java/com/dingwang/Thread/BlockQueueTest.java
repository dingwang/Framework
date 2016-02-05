/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 类BlockQueueTest.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年1月15日 下午3:33:33
 */
public class BlockQueueTest {

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    @Test
    public void testQueue() throws InterruptedException {
        this.queue.poll(2, TimeUnit.SECONDS);
        System.out.println("11111111111");
    }

}
