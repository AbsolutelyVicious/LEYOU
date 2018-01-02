package cn.com.leyou.service;

import cn.com.leyou.core.pojo.Brand;
import cn.com.leyou.core.pojo.Color;
import cn.com.leyou.core.pojo.Product;
import cn.com.leyou.core.pojo.Sku;
import cn.com.leyou.core.service.ProductService;
import cn.com.leyou.core.tools.PageHelper;
import cn.com.leyou.service.core.dao.BrandDAO;
import cn.com.leyou.service.core.dao.ColorDAO;
import cn.com.leyou.service.core.dao.ProductDao;
import cn.com.leyou.service.core.dao.SkuDAO;
import com.github.abel533.entity.Example;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
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

    @Autowired
    private SkuDAO skuDAO;

    @Autowired
    private SolrServer solrServer;

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
                product.setIsHot(0);
                product.setIsShow(0);
                product.setColors(size[j]);
                product.setSizes(color[i]);
                productDao.insert(product);
            }
        }
        System.out.println("XXXXXXXXXXXXXXXXXXX"+product);
    }

    @Override
    public void doDeleteProduct(Integer id) {
        productDao.toDelete(id);
    }

    @Override
    public void doIsShow(Long id,Integer isShow) throws IOException, SolrServerException {

        productDao.updateIsShow(id,isShow);

        if(isShow!=null && isShow==1){
            Product product = productDao.selectProductById(id);
            productDao.selectByPrimaryKey(id);
            SolrInputDocument solrInputFields = new SolrInputDocument();
            String url = product.getImgUrl().split(",")[0];
            Example example = new Example(Sku.class);
            example.createCriteria().andEqualTo("productId",product.getBrandId());
            example.setOrderByClause("price asc");
            System.out.println(example);
            List<Sku> skus = skuDAO.selectByExample(example);
            Float price = skus.get(0).getPrice();
            solrInputFields.addField("id",id);
            solrInputFields.addField("name_ik",product.getName());
            solrInputFields.addField("brandId",product.getBrandId());
            solrInputFields.addField("url",url);
            solrInputFields.addField("price",price);
            solrServer.add(solrInputFields);
            solrServer.commit();
        }

    }

}
