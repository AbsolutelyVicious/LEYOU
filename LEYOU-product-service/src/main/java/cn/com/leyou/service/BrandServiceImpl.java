package cn.com.leyou.service;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.service.BrandService;
import cn.com.leyou.core.tools.PageHelper;
import cn.com.leyou.service.core.dao.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author XuYuandong
 * @create 2017-10-21 8:17 PM
 * @desc
 **/
@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDAO brandDAO;

    public PageHelper.Page<Brand> findByExample(Brand brand , Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        brandDAO.findByAll(brand);
        PageHelper.Page endPage = PageHelper.endPage();

        return endPage;
    }

    @Override
    public Brand findById(Long id) {
        Brand brand = brandDAO.findById(id);
        return brand;
    }

    @Override
    public void update(Brand brand) {
        brandDAO.update(brand);
    }

    @Override
    public void deleteById(Long id) {
//        for(Long id : ids){
            brandDAO.deleteById(id);
//        }
    }

}
