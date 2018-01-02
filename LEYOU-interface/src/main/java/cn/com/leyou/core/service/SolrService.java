package cn.com.leyou.core.service;

import cn.com.leyou.core.pojo.SuperPojo;
import org.apache.solr.client.solrj.SolrServerException;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-30 3:09 AM
 * @desc
 **/
public interface SolrService {

    List<SuperPojo> findProductByKeyWord(String keyword) throws SolrServerException;

}
