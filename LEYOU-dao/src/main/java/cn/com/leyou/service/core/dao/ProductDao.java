package cn.com.leyou.service.core.dao;

import cn.com.leyou.core.pojo.Product;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

public interface ProductDao extends Mapper<Product> {

    void toDelete(Integer id);

    void updateIsShow(@Param("id") Long id,@Param("isShow") Integer isShow);

    /**
     * 根据ID查询商品信息
     * @param id
     * @return
     */
    Product selectProductById(Long id);

}
