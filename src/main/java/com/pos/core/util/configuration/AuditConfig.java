package com.pos.core.util.configuration;

import com.pos.app.model.core.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by admin on 4/14/18.
 */
@Configuration
@EnableJpaAuditing
class AuditConfig {
    @Bean
    public AuditorAware<Long> createAuditorProvider() {
        return new SecurityAuditor();
    }

    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }

    public static class SecurityAuditor implements AuditorAware<Long> {
        @Override
        public Long getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = authentication != null ? (User)authentication.getPrincipal() : null;
            if(user !=null)
                return user.getId();
            else
                return 1L; 	// System


        }
    }
}