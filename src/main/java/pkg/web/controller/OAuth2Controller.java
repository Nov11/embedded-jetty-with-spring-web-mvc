package pkg.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OAuth2Controller {
    @ResponseBody
    @RequestMapping("/callback")
    public String callback(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(name = "code", required = true) String code,
                           @RequestParam(name = "state", required = false) String state
    ) {
        //check state if needed

        //POST https://api.authorization-server.com/token
        //  grant_type=authorization_code&
        //  code=AUTH_CODE_HERE&
        //  redirect_uri=REDIRECT_URI&
        //  client_id=CLIENT_ID&
        //  client_secret=CLIENT_SECRET



        return "auth failed";
    }
}
