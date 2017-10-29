package cn.com.leyou;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author XuYuandong
 * @create 2017-10-28 10:39 AM
 * @desc
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestSolr {

    @Autowired
    private HttpSolrServer httpSolrServer;

    @Test
    public void createIndex1() throws IOException, SolrServerException {
        HttpSolrServer solrServer = new HttpSolrServer("http://192.168.192.128:8080/solr/collection1");
        SolrInputDocument document  = new SolrInputDocument();
        document.addField("id","1");
        document.addField("name_ik","白富美范冰冰");
        solrServer.add(document);
        solrServer.commit();
    }

    @Test
    public void createIndex2() throws IOException, SolrServerException {
        SolrInputDocument document  = new SolrInputDocument();
        document.addField("id","2");
        document.addField("name_ik","厉害了我的哥哥");
        httpSolrServer.add(document);
        httpSolrServer.commit();
    }

}
