package cn.com.leyou.action;

import cn.com.leyou.core.pojo.Sku;
import cn.com.leyou.core.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author XuYuandong
 * @create 2017-10-27 7:22 PM
 * @desc
 **/
@Controller
public class SkuAction {

    @Autowired
    private SkuService skuService;

    @RequestMapping("/console/sku/list.do")
    public String selectSkuList(Model model ,Long productId){
        List<Sku> skus = skuService.selectSkuList(productId);
        model.addAttribute(skus);
        return "/sku/list";
    }

    @RequestMapping("/console/sku/update.do")
    public String updateSku(Sku sku){
        int updateSku = skuService.updateSku(sku);
        return updateSku+"";
    }

}
