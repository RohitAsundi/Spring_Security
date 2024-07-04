package com.ascent.Spring.Security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // We have to use Controller to connect with html page or else RestController be used
public class TestController {

    @GetMapping("/signin")
    public String signin(){
        return "Login"; // Should always match the name of the HTML file
    }
}
