package cn.com.leyou.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XuYuandong
 * @create 2017-10-30 4:27 AM
 * @desc
 **/
@Controller
public class IndexAction {

    @RequestMapping(value = "/portal/index.do")
    public String showIndex() {
        return "index";
    }



}
