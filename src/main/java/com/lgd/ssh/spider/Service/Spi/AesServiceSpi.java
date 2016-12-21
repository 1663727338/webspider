package com.lgd.ssh.spider.Service.Spi;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.lgd.ssh.spider.Common.SpiderConstants;
import com.lgd.ssh.spider.Common.SpiderException;
import com.lgd.ssh.spider.Service.AesService;

public class AesServiceSpi implements AesService {

	private Logger logger = Logger.getLogger(AesServiceSpi.class);

	private String aesKey = "0123456789abcdef";

	/**
	 * 得到url对应的aes摘要信息
	 * 
	 * @param urlSrc
	 * @return
	 */
	public String Encrypt(String urlSrc) {
		if (StringUtils.isBlank(urlSrc)) {
			logger.error(SpiderConstants.AesException.PARAMETER_INVALID_CODE);
			throw new SpiderException(SpiderConstants.AesException.PARAMETER_INVALID_CODE,
					"AesService encrypt urlSrc is blank");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("start AesServiceSpi.Encrypt");
		}

		String aes = null;
		try {
			byte[] raw = aesKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(urlSrc.getBytes("utf-8"));
			Base64 base64 = new Base64();
			aes = base64.encodeToString(encrypted);
		} catch (Exception e) {
			logger.error(SpiderConstants.AesException.TO_AES_ERROR_CODE);
			throw new SpiderException(SpiderConstants.AesException.TO_AES_ERROR_CODE, 
					"AesService encrypt failed");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("end AesServiceSpi.Encrypt");
		}
		
		return aes;
	}

	/**
	 * 根据url的Aes摘要得到url
	 * 
	 * @param urlAes
	 * @return
	 */
	public String Decrypt(String urlAes) {
		
		if (StringUtils.isBlank(urlAes)) {
			logger.error(SpiderConstants.AesException.PARAMETER_INVALID_CODE);
			throw new SpiderException(SpiderConstants.AesException.PARAMETER_INVALID_CODE,
					"AesService encrypt urlAes is blank");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("start AesServiceSpi.Decrypt");
		}

		String originalString = null;
		try {
			byte[] raw = aesKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted = new Base64().decode(urlAes);
            byte[] original = cipher.doFinal(encrypted);
            originalString = new String(original,"utf-8");

		} catch (Exception e) {
			logger.error(SpiderConstants.AesException.TO_URL_ERROR_CODE);
			throw new SpiderException(SpiderConstants.AesException.TO_URL_ERROR_CODE, 
					"AesService Decrypt failed");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("end AesServiceSpi.Decrypt");
		}
		return originalString;
	}

}
