package pkg.web.auth;

public interface OAuth2Defs {
    String CLIENT_ID = "app";
    String CLIENT_SECRET = "appclientsecret";
//    String REDIRECT_URL = Base64.getUrlEncoder().encodeToString("http://localhost:60000/callback".getBytes());
    //RestTemplate will do Base64 encoding
    //so that ':" will be %3A
    //if this string is encoded, ':' will be %253A, which may lead to a access_denied error
    String REDIRECT_URL = "http://localhost:60000/callback";
    String SCOPE = "all";
    String STATE = "state";
    String AUTH = "http://localhost:8080/lockdin/authorize?response_type=code&client_id=%s&redirect_uri=%s&scope=%s&state=%s";
    String TOKEN = "http://localhost:8080/lockdin/token";
}

