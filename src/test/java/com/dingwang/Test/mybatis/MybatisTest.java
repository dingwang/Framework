/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Test.mybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dingwang.dao.PolicyDTOMapper;
import com.dingwang.model.PolicyDTO;

/**
 * 类MybatisTest.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年1月14日 下午3:00:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MybatisTest {
    private static final Logger log = LoggerFactory.getLogger(MybatisTest.class);

    @Resource
    private PolicyDTOMapper     policyDAO;

    @Test
    public void Mybatis() {
        PolicyDTO dto = new PolicyDTO();
        dto = this.policyDAO.selectByPrimaryKey(5l);
        log.info(dto.toString());

    }

}
