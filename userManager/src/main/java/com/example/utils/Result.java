package com.example.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;




public class Result {
	
	private int code;
	private String message;
	private String status;
	private Object result;
	
	public Result(){
		super();
	}
	
	public Result(int code, String message, String status){
		super();
		this.code=code;
		this.message=message;
		this.status=status;
	}
	
	public Result(int code, String message, String status, Object result){
		super();
		this.code=code;
		this.message=message;
		this.status=status;
		this.result=result;
	}
	
	@Override
	public String toString() {
		Map<String, Object> map = new LinkedHashMap<>();
				map.put("code", code);
				map.put("message", message);
				map.put("status", status);
				map.put("Data", result);
				String json = JSON.toJSONString(map);
				return json;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}


}
