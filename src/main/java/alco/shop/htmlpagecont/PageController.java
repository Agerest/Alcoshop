package alco.shop.htmlpagecont;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
        return "main";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model) {
        return "products";
    }

}
