package com.lgd.ssh.spider.Common;

public class SpiderConstants {

	
	/**
	 * 成功返回码
	 */
	public static final String SUCCESS = "00000000";

	/**
	 * jackson错误码
	 * 
	 * @author lgd
	 *
	 */
	public interface JsonException {

		/**
		 * 对象转化为json失败
		 */
		String TO_JSON_ERROR_CODE = "30002001";

		/**
		 * json转换成对象失败
		 */
		String TO_OBJECT_ERROR_CODE = "30002002";
	}

	public interface RedisException {

		/**
		 * redis访问错误码
		 */
		String REDIS_ACCESS_ERROR_CODE = "40002001";

		/**
		 * 参数不合法
		 */
		String PARAMETER_INVALID_CODE = "40001099";

		/**
		 * 批量新增或更新时 baseKey不统一
		 */
		String BASEKEY_INVALID = "40001098";
	}

	public interface ThreadException {
		/**
		 * 线程类型错误
		 */
		String THREAD_TYPE_INVALID = "50002001";
	}

	public interface AesException {

		/**
		 * 参数错误
		 */
		String PARAMETER_INVALID_CODE = "60001099";

		/**
		 * url aes加密失败
		 */
		String TO_AES_ERROR_CODE = "60002001";

		/**
		 * url aes解密失败
		 */
		String TO_URL_ERROR_CODE = "60002001";
	}

	public static final String SPIDER_TASK = "spidertask";
	
	public static final String COLON = ":";

}
