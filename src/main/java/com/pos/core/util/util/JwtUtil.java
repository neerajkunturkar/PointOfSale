package com.pos.core.util.util;

import com.pos.app.model.core.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Created by admin on 4/13/2018.
 */
public class JwtUtil {

    public String createJwt(User loggedInUser) {

        String token = Jwts.builder()
                .setSubject(loggedInUser.getUserName()) // + "-" + loggedInUser.getCustomer().getSchemaName()
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
                .compact();

        return SecurityConstants.TOKEN_PREFIX + token;
    }

    public String parseJwt(String token)throws Exception{
        String userName = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET.getBytes())
                .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        return userName;
    }

}
