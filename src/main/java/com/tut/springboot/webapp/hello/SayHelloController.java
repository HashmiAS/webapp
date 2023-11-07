package com.tut.springboot.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Anwar";
    }

    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")
   // @ResponseBody
    public String sayHelloJsp(){
        return "sayHello";
    }

}
