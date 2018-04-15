package com.pos.core.util.security;

import com.pos.app.model.core.User;
import com.pos.app.services.SecurityService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 4/13/2018.
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
    private static final String AUTH_TOKEN = "X-AuthToken";
    private static List<String> skipUrlsForAuth = new ArrayList<>();

    static {

        skipUrlsForAuth.add("/login");
    }

    /**Security Service*/
    @Autowired
    private transient SecurityService securityService;

    private boolean containsUrlToSkip(String requestUrl){

        for(String url : skipUrlsForAuth){
            if(requestUrl.contains(url)){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {

        TenantContext.setCurrentTenant("pos");
        String authToken = req.getHeader(AUTH_TOKEN);
        String requestUrl = req.getRequestURI();
        boolean validateAuthToken = !containsUrlToSkip(requestUrl);
        boolean unAuthorized = false;
        User user = null;

        if(validateAuthToken) {
            try {
                user = securityService.validateToken(authToken);
            } catch (SignatureException se) {
                logger.error("Error while validating token.", se);
                unAuthorized = true;
            } catch (ExpiredJwtException ex) {
                logger.error("Error while validating token.", ex);
                unAuthorized = true;
            }
        }

        if(unAuthorized) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            res.getWriter().write("{\"status\": \"ERROR\",\"message\": \"Not Authorized\"}");
            res.getWriter().flush();
        } else {
            req.getSession().setAttribute("SESSION_USER", user);
        }

        return !unAuthorized;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

    }

}
