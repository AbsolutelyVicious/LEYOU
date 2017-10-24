package cn.com.leyou.action;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.service.BrandService;
import cn.com.leyou.core.tools.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static cn.com.leyou.core.tools.Encoding.encodeGetRequest;

/**
 * @author XuYuandong
 * @create 2017-10-21 8:10 PM
 * @desc
 **/

@Controller
public class BrandAction {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/console/brand/list.do")
    public String consoleShowList(String name,Integer isDisplay,Model model,Integer pageNum,Integer pageSize){
        name = encodeGetRequest(name);
        Brand brand = new Brand();
        brand.setName(name);
        brand.setIsDisplay(isDisplay);
        PageHelper.Page brandPage = brandService.findByExample(brand, pageNum, pageSize);
        brandPage.setPages(5);
        System.out.println("品牌数组的长度"+brandPage.getResult().size());
        model.addAttribute("brandPage",brandPage);
        model.addAttribute("name",brand.getName());
        model.addAttribute("isDisplay",brand.getIsDisplay());
        return "/brand/list";
    }

    @RequestMapping("/console/brand/edit.do")
    public String consoleShowToEdit(Model model,Long id){
        Brand brand = brandService.findById(id);
        System.out.println(brand);
        model.addAttribute("brand",brand);
        return "/brand/edit";
    }

    @RequestMapping("/console/brand/doEdit.do")
    public String consoleShowDoEdit(Brand brand){

        brandService.update(brand);
        return "redirect:/console/brand/list.do";
    }

    @RequestMapping("/deleteById.do")
    public String deleteById(Long id){
        brandService.deleteById(id);
        return "redirect:/console/brand/list.do";
    }

}
