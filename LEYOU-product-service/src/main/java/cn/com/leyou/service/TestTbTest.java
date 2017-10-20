package cn.com.leyou.service;

import java.util.Date;

import cn.com.leyou.service.core.pojo.TestTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.com.leyou.core.service.TestTbService;

/**
 * Junit + Spring
 *
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTbTest {

    @Autowired
    private TestTbService testTbService;

    @Test
    public void testAdd2()
    {
        TestTb testTb = new TestTb();
        testTb.setName("范冰冰2");
        testTb.setBirthday(new Date());
        testTbService.add(testTb);
    }
}
