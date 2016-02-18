/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.netty.pojo;

import java.util.Date;

/**
 * 类UnixTime.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月18日 下午5:13:26
 */
public class UnixTime {

    private int value;

    public UnixTime() {
        this((int) (System.currentTimeMillis() / 1000L + 2208988800L));
    }

    public UnixTime(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new Date((this.value - 2208988800L) * 1000).toString();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
