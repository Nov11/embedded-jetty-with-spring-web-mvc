package pkg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pkg.app.service.AppService;

@Controller
public class WebController {
    @Autowired
    AppService appService;

    @ResponseBody
    @RequestMapping("/foo")
    public String foo() {
        return appService.generateMessage();
    }
}
