package pkg.web;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static pkg.web.OAuth2Defs.*;

@Service
public class OAuth2Interceptor implements HandlerInterceptor {


    private boolean hasLogin(HttpServletRequest request) {
        return false;
    }

    private static String getRedirectUrl() {
        return String.format(URL, CLIENT_ID, REDIRECT_URL, SCOPE, STATE);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (hasLogin(request)) {
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
