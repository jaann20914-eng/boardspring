package com.keud.boardproject.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtUtil {

	@Value("${jwt.expiration}")
	private Long exp;

	private Algorithm algorithm;
	private JWTVerifier jwt;

	// 생성자
	public JwtUtil(@Value("${jwt.secret}") String secret) {
		this.algorithm = Algorithm.HMAC256(secret);
		this.jwt = JWT.require(algorithm).build();
	}

	public String createToken(String id) {
		return (JWT.create() // 토큰을 만들건데 데이터를 마음대로 넣을건데 의미있는걸 넣어라
				.withSubject(id) // withSubject : 대표 데이터
				.withIssuedAt(new Date()) // 추가적으로 넣고 싶다면 claim으로 넣을 수 있다. / 값은 무한으로 넣을 수 있다.
				.withClaim("name", "tom") // withIssuedAt(new Date()) : 언제 발급하였는가여서 new date라고 해서 지금이라는 의미를 줌.
				.withExpiresAt(new Date(System.currentTimeMillis() + exp)) //
				.sign(this.algorithm));
	}

	public DecodedJWT verifyToken(String token) {
		return jwt.verify(token);
		// return이 없으면 토큰 값이 없는거고

	}

}
