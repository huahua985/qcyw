package qcyw.xchqcyws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("index")
    public String show(){
        return "1.html";
    }

}
