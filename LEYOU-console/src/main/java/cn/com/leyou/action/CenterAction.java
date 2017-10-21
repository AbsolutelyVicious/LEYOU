package cn.com.leyou.action;

import cn.com.leyou.core.pojo.TestTb;
import cn.com.leyou.core.service.TestTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class CenterAction {

    @Autowired
    private TestTbService testTbService;

    @RequestMapping(value="/test/index.do")
    public String index(Model model)
    {
        /*System.out.println("haha");
        return "index";*/
        // Dubbo调用测试
        TestTb testTb = new TestTb();
        testTb.setName("范冰冰11");
        testTb.setBirthday(new Date());
        testTbService.add(testTb);

        return "index";

    }
}
