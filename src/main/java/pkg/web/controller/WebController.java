package pkg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pkg.app.service.AppService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @Autowired
    AppService appService;

    @ResponseBody
    @RequestMapping("/foo")
    public String foo() {
        return appService.generateMessage();
    }

    @RequestMapping("/fm")
    public String freemaker(Model model) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        model.addAttribute("list", list);
        model.addAttribute("boolean", true);
        model.addAttribute("number", 111);
        model.addAttribute("string", "string");
        return "viewname";
    }
}
