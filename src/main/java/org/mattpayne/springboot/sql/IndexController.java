package org.mattpayne.springboot.sql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/jsp")
    public String index() {
        return "index";
    }

}
