package org.hxn.app.shiro.kit;

import org.apache.shiro.crypto.hash.Md5Hash;

public class ShiroKit {

	/**
	 * 加密
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String md5(String password, String salt) {
		String p = null;
		p = new Md5Hash(password, salt).toHex();
		return p;
	}

	public static boolean isEmpty(Object obj) {

		if (obj instanceof String) {
			return "".equals(obj) || null == obj;
		}

		if (obj instanceof Integer) {
			return (Integer) obj == 0 || null == obj;
		}
		if (obj == null)
			return true;
		else
			return false;
	}
}
