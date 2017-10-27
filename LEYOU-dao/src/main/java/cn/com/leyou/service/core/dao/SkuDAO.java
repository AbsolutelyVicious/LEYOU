package cn.com.leyou.service.core.dao;

import cn.com.leyou.core.pojo.Sku;
import com.github.abel533.mapper.Mapper;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-27 10:28 PM
 * @desc
 **/
public interface SkuDAO extends Mapper<Sku> {

    List<Sku> selectSkuList(Long productId);

}
