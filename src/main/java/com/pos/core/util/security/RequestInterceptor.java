package com.pos.core.util.security;

import com.pos.app.model.core.User;
import com.pos.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 4/14/18.
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("SESSION_USER");
        if(user != null) {
            User tenantUser = userRepository.findByUserName(user.getUserName());
            if(tenantUser != null){
                final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(tenantUser,
                        user.getUserPassword());
//                auth.setDetails();
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }
}
