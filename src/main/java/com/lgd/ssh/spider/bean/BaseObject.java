package com.lgd.ssh.spider.bean;

import java.io.Serializable;

public class BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5972370028053844840L;

	/**
	 * redis对应的主键key
	 */
	protected String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("BaseObject{");
		builder.append("key=" + key);
		builder.append("}");
		return builder.toString();
	}
}
