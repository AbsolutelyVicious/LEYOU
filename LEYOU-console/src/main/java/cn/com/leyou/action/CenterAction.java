package cn.com.leyou.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CenterAction {
    @RequestMapping(value="/test/index.do")
    public String index(Model model)
    {
        System.out.println("haha");
        return "index";
    }
}
