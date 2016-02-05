/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.flow;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dingwang.engine.helper.AssertHelper;
import com.dingwang.engine.helper.StreamHelper;
import com.dingwang.engine.model.ProcessModel;
import com.dingwang.engine.parser.ModelParser;

/**
 * 类FlowClient.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年1月20日 下午7:49:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class FlowClient {

    @SuppressWarnings("unused")
    public void deploy(InputStream input, String creator) throws IOException {
        AssertHelper.notNull(input);
        byte[] bytes = StreamHelper.readBytes(input);
        ProcessModel model = ModelParser.parse(bytes);
        System.out.println(model.toString());
    }

    @Test
    public void start() throws IOException {
        deploy(StreamHelper.getStreamFromClasspath("leave.jpdl.xml"), null);
    }
}
