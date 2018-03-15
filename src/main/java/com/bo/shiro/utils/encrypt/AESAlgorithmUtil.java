package com.bo.shiro.utils.encrypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Description AES 加密解密工具类
 * @author 王博
 * @version 2018年3月10日 下午2:10:38
 */
public class AESAlgorithmUtil {

	public final static String ENCODING = "UTF-8";

	/**
	 * 将二进制转换成16进制
	 *
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 *
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 生成密钥 随机生成base64 编码后的AES128位密钥
	 *
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String getAESKey() throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(128);// 要生成多少位，只需要修改这里即可128, 192或256
//		SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
//		kg.init(128, new SecureRandom(password.getBytes()));// 生成指定种子的秘钥
		SecretKey sk = kg.generateKey();
		byte[] b = sk.getEncoded();
		return parseByte2HexStr(b);
	}

	/**
	 * 生成密钥 使用种子生成base64 编码后的AES128位密钥
	 *
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String getAESKey(String seed) throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		// SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
		kg.init(128, new SecureRandom(seed.getBytes()));// 生成指定种子的秘钥   要生成多少位，只需要修改这里即可128, 192或256
		SecretKey sk = kg.generateKey();
		byte[] b = sk.getEncoded();
		return parseByte2HexStr(b);
	}
	
	/**
	 * AES 加密
	 *
	 * @param base64Key
	 *            base64编码后的 AES key
	 * @param text
	 *            待加密的字符串
	 * @return 加密后的byte[] 数组
	 * @throws Exception
	 */
	public static byte[] getAESEncode(String base64Key, String text) throws Exception {
		byte[] key = parseHexStr2Byte(base64Key);
		SecretKeySpec sKeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
		byte[] bjiamihou = cipher.doFinal(text.getBytes(ENCODING));
		return bjiamihou;
	}

	/**
	 * AES解密
	 *
	 * @param base64Key
	 *            base64编码后的 AES key
	 * @param text
	 *            待解密的字符串
	 * @return 解密后的byte[] 数组
	 * @throws Exception
	 */
	public static byte[] getAESDecode(String base64Key, byte[] text) throws Exception {
		byte[] key = parseHexStr2Byte(base64Key);
		SecretKeySpec sKeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
		byte[] bjiemihou = cipher.doFinal(text);
		return bjiemihou;
	}
}
