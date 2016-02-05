/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Thread;

/**
 * 类StudentLocal.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月4日 下午12:17:04
 */
public class StudentLocal {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 2;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);

        return seqNum.get();

    }

    public static void main(String[] args) throws InterruptedException {
        StudentLocal local = new StudentLocal();

        //        for (int i = 0; i < 100; i++) {
        //            new Thread(new FirstThread(local)).start();
        //        }
        System.out.println(Thread.currentThread().getName());
        StudentThread t1 = new StudentThread(local);

        StudentThread t2 = new StudentThread(local);

        StudentThread t3 = new StudentThread(local);
        t1.start();
        t2.start();
        t3.start();

    }

}
