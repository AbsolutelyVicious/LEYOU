package cn.com.leyou.core.service;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.pojo.Product;
import cn.com.leyou.core.tools.PageHelper;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-21 8:14 PM
 * @desc
 **/
public interface BrandService {

    PageHelper.Page<Brand> findByExample(Brand brand , Integer pageNum , Integer pageSize);

    Brand findById(Long id);

    void update(Brand brand);

    void deleteById(Long id);

}
