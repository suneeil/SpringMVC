package com.example.springmvc.login;

import com.example.springmvc.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @Autowired
    LoginService service;// = new LoginService();
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if(!service.validateUser(name, password)) {
            model.put("errorMessage", "Ivalid credentials");
            return "login";
        }
            model.put("name", name);
            logger.info("name {}", name);
            return "welcome";
    }
}
