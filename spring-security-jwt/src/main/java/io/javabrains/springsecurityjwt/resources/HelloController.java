package io.javabrains.springsecurityjwt.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping
    public String getHello(){
        return "Hello User";
    }
}
