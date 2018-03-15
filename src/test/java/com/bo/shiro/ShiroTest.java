package com.bo.shiro;

import java.io.UnsupportedEncodingException;

import org.apache.shiro.codec.Base64;
import org.junit.Test;
import org.springframework.util.Base64Utils;

import com.bo.shiro.utils.encrypt.AESAlgorithmUtil;

/**
 * @Description 
 * @author 王博
 * @version 2018年1月29日　上午10:59:01
 */
public class ShiroTest {

	/**
	 * @Description 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = new String();
	}

	@Test
	public void testBase64Encode() throws Exception {
		String secretKey = "RememberMecom.bo";
		String base64Str = Base64Utils.encodeToString(secretKey.getBytes());
		System.out.println("spring base64加密数据：" + base64Str);
		byte[] base64Byte = Base64Utils.decodeFromString(base64Str);
		System.out.println("spring base64解密数据：" + new String(base64Byte));
		
		String shiroBase64Str = Base64.encodeToString(secretKey.getBytes());
		System.out.println("shiro base64加密数据：" + shiroBase64Str);
		byte[] shiroBase64Byte = Base64.decode(shiroBase64Str);
		System.out.println("shiro base64解密数据：" + new String(shiroBase64Byte));
	}
	
	@Test
	public void tetsGenerateAESSecretKey() throws Exception {
		String aesKey = AESAlgorithmUtil.getAESKey("rememberMe");
		System.out.println("AES key: " + aesKey);
//		String str = Base64.decodeToString("FDC7481CDFA6552A629889D2A68D9047");
//		System.out.println(str);
	}
}
