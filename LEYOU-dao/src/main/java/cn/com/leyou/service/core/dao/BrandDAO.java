package cn.com.leyou.service.core.dao;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.tools.PageHelper;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-21 10:40 PM
 * @desc
 **/

public interface BrandDAO {

    public List<Brand> findByAll(Brand brand);

}
