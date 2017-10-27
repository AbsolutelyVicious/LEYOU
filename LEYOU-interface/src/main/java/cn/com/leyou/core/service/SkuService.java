package cn.com.leyou.core.service;


import cn.com.leyou.core.pojo.Sku;

import java.util.List;

public interface SkuService {

    List<Sku> selectSkuList(Long brandId);

    int updateSku(Sku sku);

}
