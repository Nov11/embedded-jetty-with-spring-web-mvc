package pkg.web;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class OAuth2Interceptor implements HandlerInterceptor {
    private static final String CLIENT_ID = "clientId";
    private static final String REDIRECT_URL = "redirectUrl";
    private static final String SCOPE = "all";
    private static final String STATE = "state";
    private static final String URL = "https://authorization-server.com/auth?response_type=code&client_id=%s&redirect_uri=%s&scope=%s&state=%s";

    private boolean hasLogin(HttpServletRequest request){
        return false;
    }

    private static String getRedirectUrl(){
        return String.format(URL, CLIENT_ID, REDIRECT_URL, SCOPE, STATE);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(hasLogin(request)){
            return true;
        }
        response.sendRedirect(getRedirectUrl());
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
