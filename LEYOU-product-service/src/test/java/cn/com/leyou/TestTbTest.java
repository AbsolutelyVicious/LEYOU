package cn.com.leyou;

import java.util.Date;

import cn.com.leyou.core.pojo.TestTb;
import cn.com.leyou.service.core.dao.TestTbDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试测试类的DAO
 * 
 * @author Administrator
 *
 */
/**
 * Junit + Spring
 * 
 * @author Administrator
 * 这样就不用写代码来加载applicationContext.xml和getBean了
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTbTest {
	
	@Autowired
	private TestTbDAO testTbDAO;

	/**
	 * 测试DAO
	 */
	@Test
	public void testAdd() {
		
		TestTb testTb = new TestTb();
		testTb.setName("范冰冰");
		testTb.setBirthday(new Date());
		testTbDAO.add(testTb);
	}
	
	

}
