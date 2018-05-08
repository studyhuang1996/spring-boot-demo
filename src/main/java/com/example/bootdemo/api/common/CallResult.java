/*
 * @(#) CallResult
 * <br> @author huang
 * <br> 2018-04-23 10:59:38
 */

package com.example.bootdemo.api.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CallResult implements Serializable {
	private boolean succee = true;
	private boolean code;
	private String msg = "操作成功";
	private Object data;
	
	Map<String, Object> datas;

	public Map<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}

	public void setData(Object data) {
		this.succee = true;
		this.data = data;
	}

	public CallResult() {

	}

	public CallResult(boolean succee, String msg) {
		this.msg = msg;
		this.succee = succee;

	}

	public boolean isSuccee() {
		return succee;
	}

	public void setSuccee(boolean succee) {
		this.succee = succee;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void fail(boolean code, String msg) {
		this.succee = false;
		this.msg = msg;
		this.code = code;
	}

	public void fail(String msg) {
		this.succee = false;
		this.msg = msg;
	}

	public void fail(boolean code) {
		this.succee = false;
		this.code = code;
	}

	public void succee(String msg) {
		this.succee = true;
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public boolean getCode() {
		return code;
	}

	public void setCode(boolean code) {
		this.code = code;
	}

	public void putData(String key, Object value) {
		if (datas == null) {
			datas = new HashMap<String, Object>();
		}
		datas.put(key, value);
	}

	public Object getData(String key) {
		if (datas != null) {
			return datas.get(key);
		}
		return null;
	}

}
