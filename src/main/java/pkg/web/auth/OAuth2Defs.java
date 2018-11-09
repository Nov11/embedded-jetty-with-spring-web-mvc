package pkg.web.auth;

import java.util.Base64;

public interface OAuth2Defs {
    String CLIENT_ID = "app";
    String CLIENT_SECRET = "appclientsecret";
    String REDIRECT_URL = Base64.getUrlEncoder().encodeToString("http://localhost:60000/callback".getBytes());
    String SCOPE = "all";
    String STATE = "state";
    String AUTH = "http://localhost:8080/lockdin/authorize?response_type=code&client_id=%s&redirect_uri=%s&scope=%s&state=%s";
    String TOKEN = "http://localhost:8080/lockdin/token";
}

