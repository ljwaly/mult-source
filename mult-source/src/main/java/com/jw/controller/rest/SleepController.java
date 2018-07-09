package com.jw.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sleep")
public class SleepController {

	@RequestMapping("/test")
	public Map<String, Object> testSleep(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			Thread.sleep(300000L);
			map.put("result", "success");
			return map;
		} catch (Exception e) {
			map.put("result", "fail");
		}
		return map;
	}
	
	@RequestMapping("/test1")
	public Map<String, Object> testSleep1(@RequestHeader HttpHeaders headers,@RequestBody String body, String userId){
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		String abc = headers.getFirst("abc");
		System.out.println("head:abc="+abc);
		System.out.println("body="+body);
		System.out.println("userId="+userId);
		map.put("head:abc", abc);
		map.put("body", body);
		map.put("userId", userId);
		try {
			
			map.put("result", "success");
			return map;
		} catch (Exception e) {
			map.put("result", "fail");
		}
		return map;
	}
}
