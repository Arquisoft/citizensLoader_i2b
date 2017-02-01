package es.uniovi.asw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController  {

    @RequestMapping("/")
    ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("text", "Hello world");
        return mav;
    }
}
