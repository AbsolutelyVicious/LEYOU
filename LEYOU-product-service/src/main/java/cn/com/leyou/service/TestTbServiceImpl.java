package cn.com.leyou.service;

import java.util.Date;

import cn.com.leyou.core.pojo.TestTb;
import cn.com.leyou.core.service.TestTbService;
import cn.com.leyou.service.core.dao.TestTbDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 测试类服务实现类
 * 
 * @author Administrator
 *
 */
@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {
	
	@Autowired
	private TestTbDAO testTbDAO;
	

	@Override
	public void add(TestTb testTb) {
		
		testTbDAO.add(testTb);
		
		
		//手动制造异常
	    //int num = 5/0;
				
		
		TestTb testTb2 = new TestTb();
		
		testTb2.setName("景甜6");
		testTb2.setBirthday(new Date());
		
		testTbDAO.add(testTb2);
	}

}
