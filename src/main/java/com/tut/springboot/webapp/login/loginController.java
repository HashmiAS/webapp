package com.tut.springboot.webapp.login;

import com.tut.springboot.webapp.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loginController {

    private AuthenticationService authenticationService;

    public loginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap map) {
        if (authenticationService.authenticate(name,password)) {
            map.put("name", name);
            map.put("password", password);
            return "welcome";
        }
        map.put("errorMessage","Invalid username or password");
        return "login";
    }

}
