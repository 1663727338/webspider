package com.lgd.ssh.spider.Service;

/**
 * Aes 加解密
 * @author lgd
 *
 */
public interface AesService {	
	
	
	/**
	 * 得到url对应的aes摘要信息
	 * @param urlSrc
	 * @return
	 */
	public String Encrypt(String urlSrc);
	
	/**
	 * 根据url的Aes摘要得到url
	 * @param urlAes
	 * @return
	 */
	public String Decrypt(String urlAes);
}
