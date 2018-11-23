package pkg.web.auth;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static pkg.web.auth.OAuth2Defs.*;

@Controller
public class OAuth2Controller {
    @ResponseBody
    @RequestMapping("/callback")
    public String callback(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(name = "code", required = true) String code,
                           @RequestParam(name = "state", required = false) String state
    ) throws IOException {
        //check state if needed

        //POST https://api.authorization-server.com/token
        //  grant_type=authorization_code&
        //  code=AUTH_CODE_HERE&
        //  redirect_uri=REDIRECT_URI&
        //  client_id=CLIENT_ID&
        //  client_secret=CLIENT_SECRET

        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "authorization_code");
        map.add("code", code);
        map.add("redirect_uri", REDIRECT_URL);
        map.add("client_id", CLIENT_ID);
        map.add("client_secret", CLIENT_SECRET);
        AccessToken accessToken = restTemplate.postForObject(TOKEN, map, AccessToken.class);

        //access token to profile

        //save profile info into something, like a cookie

        //if on requesting resource, the target url has been saved.
        //retrieve it and redirect to there

        response.sendRedirect(String.format("/?access_token={%s}", accessToken.getAccessToken()));

        return "auth success";
    }
}
