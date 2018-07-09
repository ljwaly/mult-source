package com.jw.controller.rest;

import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * 此类用来统一处理自定义异常，异常处理方法上使用注解@ExceptionHandler
 * 
 * 当控制器内部抛出异常的时候，通过此类将异常信息封装返回异常信息
 * 
 * 如：
 * @ExceptionHandler(MyDemoException.class) 
 * public BasicRestResponsemyDemoExceptionHandler(Exception e){ 
 * 		BasicRestResponse response=new BasicRestResponse(); 
 * 		response.setResultCode(ResultCode.ERR_MY_DEMO_ERROR);
 * 		response.setResultDesc(e.getMessage()); 
 * 		return response; 
 * }
 *
 */
public class BaseController {

	private final static String ERROR_UNKONW = "ERR_UNKNOW";
	private final static String WRONG_PARAM = "WRONG_PARAM";

	
}
