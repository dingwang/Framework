/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.file;

import java.io.IOException;

import org.junit.Test;

import com.dingwang.File.MapFileToMemory;

/**
 * 类MapFileToMemoryTest.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月4日 上午11:57:29
 */
public class MapFileToMemoryTest {

    @Test
    public void mapToFile() throws IOException {
        final MapFileToMemory mm = new MapFileToMemory();
        mm.parseFile();
    }

}
