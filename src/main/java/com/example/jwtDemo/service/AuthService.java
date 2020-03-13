package com.example.jwtDemo.service;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.jwtDemo.model.userInfo;
@Service
public class AuthService {
	private String token;
	public String jwtCreate(userInfo UserInfo){
		try {
	    Algorithm algorithm = Algorithm.HMAC256(UserInfo.getPassword());
	    token = JWT.create()
	        .withIssuer(UserInfo.getUserName())
	        .sign(algorithm);
	    Algorithm verAlgorithm = Algorithm.HMAC256("password");
	    JWTVerifier verifier = JWT.require(verAlgorithm)
	        .withIssuer("ashish")
	        .build(); //Reusable verifier instance
	    DecodedJWT jwt = verifier.verify(token);
	    return "authorized";
		} catch (JWTVerificationException exception){
			return "unauthorized";
	    //Invalid Signing configuration / Couldn't convert Claims.
	}
	}
		
}
