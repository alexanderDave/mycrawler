package com.Utils;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class MD5 {
	
	public static Logger logger = Logger.getLogger(MD5.class);
	
	/**
	 * @author davedaiw
	 * @param str
	 * @return md5
	 * @see get Md5
	 */
	public static String generateMd5(String str){
		byte[] strBytes = str.getBytes();
		String md5 = null;
		char hexDigits[] = {
				'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
		};
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(strBytes);
			byte temp[] = md.digest();
			char mstr[] = new char[16*2];
			
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte mbyte = temp[i];
				mstr[k++] = hexDigits[mbyte >>>	4 & 0xf];
				mstr[k++] = hexDigits[mbyte & 0xf];
			}
			md5 = new String(mstr);
		} catch (NoSuchAlgorithmException e) {
			logger.error("MD5 err!");
		}	
		return md5;
	}

}
