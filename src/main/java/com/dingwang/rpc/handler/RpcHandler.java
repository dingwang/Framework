/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.rpc.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dingwang.rpc.pojo.RpcRequest;
import com.dingwang.rpc.pojo.RpcResponse;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

/**
 * 类RpcHandler.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年2月22日 下午4:12:46
 */
public class RpcHandler extends SimpleChannelInboundHandler<RpcRequest> {

    private static final Logger       LOGGER = LoggerFactory.getLogger(RpcHandler.class);

    private final Map<String, Object> handlerMap;

    public RpcHandler(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.SimpleChannelInboundHandler#messageReceived(io.netty.
     * channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, RpcRequest request) throws Exception {

        System.out.println("-----------------------------------------server messageReceived");
        RpcResponse response = new RpcResponse();
        response.setRequestId(request.getRequestId());
        try {
            Object result = handle(request);
            response.setResult(result);
        } catch (Throwable t) {
            response.setError(t);
        }
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }

    /*
     * (non-Javadoc)
     * @see
     * io.netty.channel.SimpleChannelInboundHandler#channelRead(io.netty.channel
     * .ChannelHandlerContext, java.lang.Object)
     */
    //    @Override
    //    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    //        System.out.println("-----------------------------------------server channelRead");
    //        RpcRequest request = (RpcRequest) msg;
    //        RpcResponse response = new RpcResponse();
    //        response.setRequestId(request.getRequestId());
    //        try {
    //            Object result = handle(request);
    //            response.setResult(result);
    //        } catch (Throwable t) {
    //            response.setError(t);
    //        }
    //        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    //    }

    private Object handle(RpcRequest request) throws Throwable {
        String className = request.getClassName();
        Object serviceBean = handlerMap.get(className);

        Class<?> serviceClass = serviceBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] parameters = request.getParameters();

        /*
         * Method method = serviceClass.getMethod(methodName, parameterTypes);
         * method.setAccessible(true); return method.invoke(serviceBean,
         * parameters);
         */

        FastClass serviceFastClass = FastClass.create(serviceClass);
        FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
        return serviceFastMethod.invoke(serviceBean, parameters);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        LOGGER.error("server caught exception", cause);
        ctx.close();
    }

}
