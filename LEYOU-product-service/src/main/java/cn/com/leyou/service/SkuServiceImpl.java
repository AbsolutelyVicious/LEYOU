package cn.com.leyou.service;

import cn.com.leyou.core.pojo.Sku;
import cn.com.leyou.core.service.SkuService;
import cn.com.leyou.service.core.dao.SkuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-27 9:39 PM
 * @desc
 **/
@Service("skuService")
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuDAO skuDAO;

    @Override
    public List<Sku> selectSkuList(Long productId) {

        List<Sku> skuList = skuDAO.selectSkuList(productId);

        return skuList;
    }

    @Override
    public int updateSku(Sku sku) {
        int i = skuDAO.updateByPrimaryKeySelective(sku);
        return i;
    }
}
