package cn.com.leyou.service;

import cn.com.leyou.core.pojo.SuperPojo;
import cn.com.leyou.core.service.SolrService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author XuYuandong
 * @create 2017-10-30 4:30 AM
 * @desc
 **/
@Service("solrService")
public class SolrServiceImpl implements SolrService {

    @Autowired
    private HttpSolrServer solrServer;

    @Override
    public List<SuperPojo> findProductByKeyWord(String keyword) throws SolrServerException {

        SolrQuery solrQuery = new SolrQuery("name_ik:"+keyword);

        //设置高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("name_ik");
        solrQuery.setHighlightSimplePre("<span style='color:red'>");
        solrQuery.setHighlightSimplePost("</span>");

        //开始查询
        QueryResponse response = solrServer.query(solrQuery);

        //获得高亮数据集合
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

        //获得结果集
        SolrDocumentList results = response.getResults();

        //获得总数量
        long numFound = results.getNumFound();

        //创建商品对象集合
        ArrayList<SuperPojo> superPojos = new ArrayList<>();

        for(SolrDocument solrDocument : results){
            //创建商品对象
            SuperPojo superPojo = new SuperPojo();
            //商品ID
            String id = (String)solrDocument.get("id");
            superPojo.setProperty("id",id);
            // 取得高亮数据集合中的商品名称
            Map<String, List<String>> map = highlighting.get(id);
            String string = map.get("name_ik").get(0);
            superPojo.setProperty("name",string);
            //图片地址
            String imgUrl = (String) solrDocument.get("url");
            superPojo.setProperty("imgUrl",imgUrl);
            //商品最低价
            Float price = (Float) solrDocument.get("price");
            superPojo.setProperty("price", price);
            // 品牌id
            String brandId = (String) solrDocument.get("brandId");
            superPojo.setProperty("brandId", brandId);
            // 将万能商品对象添加到集合中
            superPojos.add(superPojo);
        }
        return superPojos;
    }
}
