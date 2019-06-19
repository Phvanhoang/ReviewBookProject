package config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()){
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication auth){
        String url = "";
        Collection<? extends GrantedAuthority> grantedAuthority = auth.getAuthorities();
        Set<String> roleNames = new HashSet<>();
        for (GrantedAuthority a: grantedAuthority) {
            roleNames.add(a.getAuthority());
        }
        if (roleNames.contains("DBA")){
            url = "/dba";
        } else if(roleNames.contains("ADMIN")){
            url = "/admin";
        } else if(roleNames.contains("USER")){
            url = "/user";
        } else{
            url = "/accessDenied";
        }
        return url;
    }

    public void setRedirectStratery(RedirectStrategy redirectStratery){
        this.redirectStrategy = redirectStratery;
    }

    protected RedirectStrategy getRedirectStratery(){
        return redirectStrategy;
    }
}
