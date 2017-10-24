package cn.com.leyou.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CenterAction {

    @RequestMapping(value = "/console/{pageName}.do")
    public String consoleShow(@PathVariable(value = "pageName") String pageName) {
        return pageName;
    }


    @RequestMapping("/console/ad/{pageName}.do")
    public String consoleShowAd(@PathVariable("pageName") String pageName){
        return "/ad/"+pageName;
    }

    @RequestMapping("/console/brand/{pageName}.do")
    public String consoleShowBrand(@PathVariable("pageName") String pageName){
        return "/brand/"+pageName;
    }

    @RequestMapping("/console/frame/{pageName}.do")
    public String consoleShowFrame(@PathVariable("pageName") String pageName){
        return "/frame/"+pageName;
    }

    @RequestMapping("/console/order/{pageName}.do")
    public String consoleShowOrder(@PathVariable("pageName") String pageName){
        return "/order/"+pageName;
    }

    @RequestMapping("/console/position/{pageName}.do")
    public String consoleShowPosition(@PathVariable("pageName") String pageName){
        return "/position/"+pageName;
    }

    @RequestMapping("/console/product/{pageName}.do")
    public String consoleShowProduct(@PathVariable("pageName") String pageName){
        return "/product/"+pageName;
    }

    @RequestMapping("/console/sku/{pageName}.do")
    public String consoleShowSku(@PathVariable("pageName") String pageName){
        return "/sku/"+pageName;
    }

    @RequestMapping("/console/type/{pageName}.do")
    public String consoleShowType(@PathVariable("pageName") String pageName){
        return "/type/"+pageName;
    }


}
