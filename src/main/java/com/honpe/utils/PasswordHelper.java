/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.honpe.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.honpe.po.SysUser;

public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";

	private static String hashIteration = "2";

	private static int hashIterations = Integer.valueOf(hashIteration);

	public static String getSalt() {
		return randomNumberGenerator.nextBytes().toHex();
	}

	public static void encryptPassword(SysUser sysUser) {
		sysUser.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName, sysUser.getLoginPass(),
				ByteSource.Util.bytes(sysUser.getSalt()), hashIterations).toHex();
		sysUser.setLoginPass(newPassword);
	}

	/**
	 * 加密密码
	 * 
	 * @param loginPwd
	 *            明文密码
	 * @param salt
	 * @return
	 */
	public static String getPwd(String loginPwd, String salt) {
		String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(salt), hashIterations)
				.toHex();
		return newPassword;
	}
}
