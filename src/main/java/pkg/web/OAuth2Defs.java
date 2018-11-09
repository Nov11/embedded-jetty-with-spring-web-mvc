package pkg.web;

public interface OAuth2Defs {
    String CLIENT_ID = "clientId";
    String REDIRECT_URL = "http://localhost:60000/callback";
    String SCOPE = "all";
    String STATE = "state";
    String URL = "https://authorization-server.com/auth?response_type=code&client_id=%s&redirect_uri=%s&scope=%s&state=%s";
}
