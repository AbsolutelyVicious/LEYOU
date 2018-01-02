package cn.com.leyou.core.service;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.pojo.Color;
import cn.com.leyou.core.pojo.Product;
import cn.com.leyou.core.tools.PageHelper;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-25 7:44 PM
 * @desc
 **/
public interface ProductService {

    /**
     * findProductsList
     * @param product
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageHelper.Page<Product> findProductsList(Product product, Integer pageNum, Integer pageSize);

    /**
     * findProductBrand
     * @return
     */
    List<Long> findProductBrand();

    /**
     *findColor
     * @return
     */
    List<Color> findColor();

    /**
     *findByAllBrands
     * @return
     */
    List<Brand> findByAllBrands();

    /**
     *insertProduct
     * @param product
     */
    void insertProduct(Product product);

    /**
     *doDeleteProduct
     * @param id
     */
    void doDeleteProduct(Integer id);

    /**
     * doIsShow
     * @param id
     * @param isShow
     * @throws IOException
     * @throws SolrServerException
     */
    void doIsShow(Long id,Integer isShow) throws IOException, SolrServerException;

}
