package org.mattpayne.springboot.sql;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// from https://github.com/Spring-Squad/jsp-thymeleaf-config
@Controller
public class HomeController {

    @RequestMapping(value = "/h", method = RequestMethod.GET)
    public ModelAndView showHome(@RequestParam(value = "viewResolver") Optional<String> viewResolver) {
        return getDefaultView(viewResolver);
    }

    private ModelAndView getDefaultView(Optional<String> viewResolver) {
        ModelAndView model = new ModelAndView(createView(viewResolver, "/home"));
        model.addObject("name", "Spring Squad");
        return model;
    }

    private String createView(Optional<String> viewResolver, String viewName) {
        String result = viewResolver.isPresent() ? viewResolver.get() : "jsp";
        result += viewName;
        return result;
    }
}
