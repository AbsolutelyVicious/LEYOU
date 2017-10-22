package cn.com.leyou.action;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.service.BrandService;
import cn.com.leyou.core.tools.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-21 8:10 PM
 * @desc
 **/

@Controller
public class BrandAction {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/console/{pageName}.do")
    public String consoleShow(@PathVariable(value = "pageName") String pageName) {
        return pageName;
    }


    @RequestMapping("/console/ad/{pageName}.do")
    public String consoleShowAd(@PathVariable("pageName") String pageName){
        return "/ad/"+pageName;
    }

    @RequestMapping("/console/brand/{pageName}.do")
    public String consoleShowBrand(@PathVariable("pageName") String pageName,String name,Integer isDisplay,Model model,Integer pageNum,Integer pageSize){
        if(pageName.equals("list")){

            Brand brand = new Brand();
            brand.setName(name);
            brand.setIsDisplay(isDisplay);
            System.out.println(name);
            System.out.println(isDisplay);
            System.out.println(pageNum);
            System.out.println(pageSize);

            PageHelper.Page brandPage = brandService.findByExample(brand, pageNum, pageSize);
            brandPage.setPages(5);
            System.out.println("品牌数组的长度"+brandPage.getResult().size());
            System.out.println(brandPage);
            model.addAttribute("brandPage",brandPage);
            model.addAttribute("name",brand.getName());
            model.addAttribute("isDisplay",brand.getIsDisplay());
        }
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
