/*
 * Copyright 2015 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dingwang.dao.PolicyDTOMapper;
import com.dingwang.model.PolicyDTO;

/**
 * 类Client.java的实现描述：
 * 
 * @author dingwang 2015年10月14日 下午3:29:40
 */
public class Client {

    public static final Logger log = LoggerFactory.getLogger(Client.class);

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "classpath:applicationContext.xml" });
        PolicyDTOMapper policyDAO = (PolicyDTOMapper) context.getBean("policyDAO");
        PolicyDTO policyDTO = policyDAO.selectByPrimaryKey(7L);
        System.out.println("############" + policyDTO.getChannelCode() + "########");
        //        HelloWorldService hw = (HelloWorldService) context.getBean("proxyHW");
        //        log.info("-----------------华丽的分割线-------------------------");
        //        hw.sayHelloWorld("LiuBei");
        //        log.info("-----------------华丽的分割线-------------------------");
        //        hw.sayGood("CaoCao");
        //        log.info("-----------------华丽的分割线-------------------------");
        //        hw.smile("SunQuan");
        //        HWFactoryBean hb = (HWFactoryBean) context.getBean("&proxyHW");
        //        log.warn(hb.getClass().getName());
        //        TestInit ti = (TestInit) context.getBean("testInit");
        //        ClassLoader cl = new Client().getClass().getClassLoader();
        //        final GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
        //
        //        new DefaultDiamondManager("DEFAULT_GROUP", "com.taobao.groovycode.test", new ManagerListenerAdapter() {
        //
        //            public void receiveConfigInfo(String configInfo) {
        //                log.info("########configInfo=" + configInfo);
        //                Class groovyClass = groovyCl.parseClass(configInfo);
        //                try {
        //                    Groovy groovy = (Groovy) groovyClass.newInstance();
        //                    groovy.logGroovy(context);
        //                } catch (InstantiationException e) {
        //                    // TODO Auto-generated catch block
        //                    e.printStackTrace();
        //                } catch (IllegalAccessException e) {
        //                    // TODO Auto-generated catch block
        //                    e.printStackTrace();
        //                }
        //            }
        //        }).getAvailableConfigureInfomation(100000);
        //
        //        Thread.currentThread().sleep(10000);
    }
}
