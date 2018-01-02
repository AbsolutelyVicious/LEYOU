package cn.com.leyou.action;

import cn.com.leyou.core.pojo.SuperPojo;
import cn.com.leyou.core.service.SolrService;
import cn.com.leyou.core.tools.Encoding;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-30 4:27 AM
 * @desc
 **/
@Controller
public class IndexAction {

    @Autowired
    private SolrService solrService;

    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model , String keyword) throws SolrServerException {
        keyword = Encoding.encodeGetRequest(keyword);
        System.out.println(keyword);
        List<SuperPojo> superProducts = solrService.findProductByKeyWord(keyword);
        model.addAttribute("superProducts",superProducts);
        model.addAttribute("keyword",keyword);
        System.out.println("搜索。。。");
        return "search";
    }



}
