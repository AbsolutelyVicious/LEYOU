package cn.com.leyou.service;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.pojo.Color;
import cn.com.leyou.core.pojo.Product;
import cn.com.leyou.core.service.ProductService;
import cn.com.leyou.core.tools.PageHelper;
import cn.com.leyou.service.core.dao.BrandDAO;
import cn.com.leyou.service.core.dao.ColorDAO;
import cn.com.leyou.service.core.dao.ProductDao;
import com.github.abel533.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYuandong
 * @create 2017-10-25 7:48 PM
 * @desc
 **/
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ColorDAO colorDAO;

    @Autowired
    private BrandDAO brandDAO;

    @Autowired
    private Jedis jedis;

    @Override
    public PageHelper.Page<Product> findProductsList(Product product, Integer pageNum, Integer pageSize) {
        Example example = new Example(Product.class);
        if(product.getName()==null){
            product.setName("");
        }
        example.createCriteria().andLike("name","%"+product.getName()+"%");
        example.setOrderByClause("id desc");
        // 设置查询条件
        example.createCriteria().andLike("name", "%" + product.getName() + "%");
        PageHelper.startPage(pageNum,pageSize);
        productDao.selectByExample(example);
        PageHelper.Page endPage = PageHelper.endPage();
        return endPage;
    }

    @Override
    public List findProductBrand() {
        Example example = new Example(Product.class);
        List<Product> products = productDao.selectByExample(example);
        ArrayList<Long> list = new ArrayList<>();
        for(Product product : products){
            if(!list.contains(product.getBrandId())){
                list.add(product.getBrandId());
            }
        }
        return list;
    }

    @Override
    public List<Color> findColor() {
        Example example = new Example(Color.class);
        List<Color> colors = colorDAO.selectByExample(example);
        return colors;
    }

    @Override
    public List<Brand> findByAllBrands() {
        Brand brand = new Brand();
        List<Brand> brands = brandDAO.findByAll(brand);
        return brands;
    }

    @Override
    public void insertProduct(Product product) {

        String colors = product.getColors();
        String sizes = product.getSizes();
        String[] color = colors.split(",");
        String[] size = sizes.split(",");
        for (int i=0 ; i<color.length ; i++){
            for(int j=0 ; j<size.length ; j++){
                Long pno = jedis.incr("pno");
                product.setId(pno);
                product.setIsShow(0);
                product.setColors(size[j]);
                product.setSizes(color[i]);
                productDao.insert(product);
            }
        }
        System.out.println("XXXXXXXXXXXXXXXXXXX"+product);
    }
}
