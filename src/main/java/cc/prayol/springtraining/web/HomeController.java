package cc.prayol.springtraining.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hjx
 * @date 2020/8/11
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
