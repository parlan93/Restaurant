package parlan.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    
    @RequestMapping()
    public String init(Model model) {
        return "index";
    }
    
}
