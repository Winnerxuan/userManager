package com.example.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.bean.User;

public class JwtToken {
	
	public static String SECRET = "Winner";
	
	public static String createToken(User user) throws Exception{
		
		//签发时间
		Date iatDate = new Date();
		
		//过期时间-1分钟过期
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.MINUTE, 60);
		Date expiresDate = nowTime.getTime();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");
		String token = JWT.create()
				.withHeader(map)
				.withClaim("userid", user.getId())
				.withClaim("UA", "UA123456")
				.withExpiresAt(expiresDate) //过期时间
				.withIssuedAt(iatDate) //签发时间
				.sign(Algorithm.HMAC256(SECRET));//加密
		return token;
	}
	
	//解密Token，如果过期就会抛异常
			public static Map<String, Claim> verifyToken(String token) throws Exception{
				JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
						.build();
				DecodedJWT jwt = null;
				try {
					jwt = verifier.verify(token);
				}catch(Exception e) {
					throw new RuntimeException("登录凭证已过去，请重新登录");
				}
				
				return jwt.getClaims();
			}
}
