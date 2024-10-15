/*<!--引入jwt-->
<dependency>
<groupId>com.auth0</groupId>
<artifactId>java-jwt</artifactId>
<version>4.4.0</version>
</dependency>*/

package com.admin.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
	private static final String SIGN = "easy"; // 密钥
	// 1.通过jwt生成token字符串。

	public static String createToken(Map<String, Object> params) {

		Map<String, Object> head = new HashMap();
		head.put("alg", "HS256");
		head.put("typ", "JWT");

		// 定义颁发时间
		Date iss = new Date();
		// 过期时间
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.DAY_OF_YEAR, 3);
		Date expire = nowTime.getTime();

		String token = JWT.create()
				// 指定头信息
				.withHeader(head)
				// 载荷种的过期时间
				.withExpiresAt(expire)
				// 颁发时间
				.withIssuedAt(iss)
				// 颁发人
				.withIssuer("easy")
				// 自定义的载荷内容
				.withClaim("userInfo", params)
				// 签名
				.sign(Algorithm.HMAC256(SIGN));

		return token;
	}

	// 2. 判断token是否合法
	public static boolean verifyToken(String token) {
		JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGN)).build();
		try {
			DecodedJWT verify = build.verify(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 3. 解析token中的内容
	public static Map<String, Object> decodeJWT(String token) {
		Map<String, Object> userInfo = JWT.decode(token).getClaim("userInfo").asMap();
		return userInfo;
	}

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap();
		map.put("name", "zhangsan");
		map.put("id", 1);
		map.put("age", 19);
		String token = createToken(map);
		System.out.println(token);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean bool = verifyToken(token);
		System.out.println(bool);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> map2 = decodeJWT(token);
		System.out.println(map2);

	}
}
