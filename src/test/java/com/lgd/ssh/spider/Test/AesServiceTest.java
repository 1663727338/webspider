package com.lgd.ssh.spider.Test;

import com.lgd.ssh.spider.Service.AesService;

public class AesServiceTest {

	private static AesService aesService;
	public static void main(String[] args) {
		
		ContextLoad.loadContext();
		
		String url = "http://yuncode.net/code/c_54a75easd9535268481";
		
		System.out.println("url = " + url);
		
		String aes = aesService.Encrypt(url);
		
		System.out.println("aeslen = " + aes.length());
		System.out.println("aes = " + aes);
		
		String deurl = aesService.Decrypt(aes);
		
		System.out.println("deurl = " + deurl );
	}
	
	public static AesService getAesService() {
		return aesService;
	}
	public static void setAesService(AesService aesService) {
		AesServiceTest.aesService = aesService;
	}
	
	
}
