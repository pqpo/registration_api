package cn.edu.hhu.reg.common.secutiry;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private static MessageDigest MdMD5 = null;
	
	private static MessageDigest getMDMd5() throws NoSuchAlgorithmException {
		if(MdMD5 == null) MdMD5 = MessageDigest.getInstance("MD5");
		return MdMD5;
	}
	
	/**
	 * 计算YM密码散列
	 * @param str 原始密码
	 * @return 散列值
	 */
	public static String ymPass(String str) {
		if(str == null) return null;
		str = "Ym" + str + "yM";
		String pass = md5(str);
		pass = pass.substring(16, 32) + pass.substring(0, 16);
		return pass;
	}
	
	/**
	 * 计算字符串MD5值
	 * @param str 原始字符串
	 * @return 字符串MD5值
	 */
	public static String md5(String str) {
		return md5(str, 32);
	}
	
	/**
	 * 计算字符串MD5值
	 * @param str 原始字符串
	 * @param length MD5长度 仅可选 16/32
	 * @return 字符串MD5值
	 */
	public static String md5(String str, int length) {
		if(str == null) return null;
		try {
            byte[] bts = str.getBytes();
            MessageDigest mdMd5 = getMDMd5();
			mdMd5.update(bts);
            byte[] mdBts = mdMd5.digest();
    		String st = getHexDigits(mdBts);
    		if(length == 16) return st.substring(8,24);
    		return st;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String getHexDigits(byte[] bts) {
		int i;
		StringBuilder buf = new StringBuilder("");
		for(byte bt : bts) {
			i = bt;
			if(i < 0) i += 256;
			if(i < 16) buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		return buf.toString(); 
	}
}