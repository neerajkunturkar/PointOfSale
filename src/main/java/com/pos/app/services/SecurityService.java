package com.pos.app.services;

import com.pos.app.model.core.User;
import com.pos.app.repository.UserRepository;
import com.pos.core.util.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 4/13/2018.
 */
@Service
public class SecurityService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    @Autowired
    private UserRepository userRepository;

    public static Map<String, User> loggedInUserMap = new HashMap<String, User>();


    public User validUser(User user)throws Exception{

        try {

            final User authenticatedUser = userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
            JwtUtil jwtUtil = new JwtUtil();

            if (authenticatedUser != null) {
                authenticatedUser.setAuthToken(jwtUtil.createJwt(authenticatedUser));
                authenticatedUser.setLastLoginDate(new Date());

                userRepository.save(authenticatedUser);

                return authenticatedUser;
            }

        }catch (Exception e){
            logger.error("Error while validating User", e);
        }
        return null;
    }

    public User validateToken(String token) throws Exception{

        if(token == null){
            throw new Exception("Invalid user/password provided.");
        }

        JwtUtil jwtUtil = new JwtUtil();
        String userName = jwtUtil.parseJwt(token);

        User user = userRepository.findByUserName(userName);
        if(!loggedInUserMap.containsKey(userName)){
            loggedInUserMap.put(userName, user);
        }

        final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, user
                .getUserPassword());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return loggedInUserMap.get(userName);

    }

    public boolean releaseToken(User user) throws Exception{

        User authenticatedUser = userRepository.findByUserName(user.getUserName());
        authenticatedUser.setAuthToken("");
        userRepository.save(authenticatedUser);
        return true;
    }

}
