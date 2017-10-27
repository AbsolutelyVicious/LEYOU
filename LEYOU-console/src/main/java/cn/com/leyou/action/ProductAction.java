package cn.com.leyou.action;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.pojo.Color;
import cn.com.leyou.core.pojo.Product;
import cn.com.leyou.core.service.ProductService;
import cn.com.leyou.core.tools.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-25 8:05 PM
 * @desc
 **/
@Controller
public class ProductAction {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/console/product/list.do")
    public String findProductsList(Model model , Product product , Integer pageNum , Integer pageSize){
        PageHelper.Page<Product> productsList = productService.findProductsList(product, pageNum, pageSize);
        model.addAttribute("productsList",productsList);
        System.out.println(productsList.getResult());
        List<Long> brandId = productService.findProductBrand();
        model.addAttribute("products",brandId);
        model.addAttribute("product",product);
        System.out.println(productsList);
        return "/product/list";
    }

    @RequestMapping("/console/product/add.do")
    public String toAdd(Model model){
        List<Color> colors = productService.findColor();
        model.addAttribute("colors",colors);
        System.out.println(colors);

        List<Brand> brands = productService.findByAllBrands();
        model.addAttribute("brands",brands);

        return "/product/add";
    }

    @RequestMapping("/console/product/doAdd.do")
    public String doAdd(Model model, Product product){
        System.out.println("product"+product);
        productService.insertProduct(product);
        return "redirect:/console/product/list.do";
    }

    @RequestMapping("/console/product/toDelete.do")
    public String doDelete(String ids){
        String[] split = ids.split(",");
        System.out.println(split);
        for(String id : split){
            productService.doDeleteProduct(Integer.valueOf(id));
        }
        return "redirect:/console/product/list.do";
    }

}
