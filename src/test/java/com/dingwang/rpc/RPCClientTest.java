/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.rpc;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dingwang.rpc.service.HelloService;

/**
 * 类RPCServerTest.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 下午4:42:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-client.xml")
public class RPCClientTest {

    //    @Autowired
    //    private RpcProxy     rpcProxy;

    @Resource
    private HelloService helloServiceConsumer;

    @Test
    public void helloTest() {

        //        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloServiceConsumer.hello("World");
        System.out.println("###############result=" + result);

        String reslut2 = helloServiceConsumer.hello("dw", 26);
        System.out.println("###############reslut2=" + reslut2);

        System.out.println(helloServiceConsumer.hello("dw", "男"));
        //        Assert.assertEquals("Hello! World", result);
    }
}
