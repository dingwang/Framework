/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Thread;

/**
 * 类StudentThread.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月4日 下午1:44:09
 */
public class StudentThread extends Thread {

    private StudentLocal local;

    public StudentThread(StudentLocal l) {
        this.local = l;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "=======" + local.getNextNum() + "local======"
                    + local.hashCode());
        }
    }

}
