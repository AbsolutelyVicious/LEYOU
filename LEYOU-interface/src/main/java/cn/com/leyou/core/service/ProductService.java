package cn.com.leyou.core.service;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.pojo.Color;
import cn.com.leyou.core.pojo.Product;
import cn.com.leyou.core.tools.PageHelper;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-25 7:44 PM
 * @desc
 **/
public interface ProductService {

    PageHelper.Page<Product> findProductsList(Product product, Integer pageNum, Integer pageSize);

    List<Long> findProductBrand();

    List<Color> findColor();

    List<Brand> findByAllBrands();

    void insertProduct(Product product);

    void doDeleteProduct(Integer id);

}
