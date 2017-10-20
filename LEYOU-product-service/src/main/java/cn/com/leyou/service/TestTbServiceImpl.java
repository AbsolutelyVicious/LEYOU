package cn.com.leyou.service;

import cn.com.leyou.core.service.TestTbService;
import cn.com.leyou.service.core.dao.TestTbDAO;
import cn.com.leyou.service.core.pojo.TestTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {

    @Autowired
    private TestTbDAO testTbDAO;

    public void add(TestTb testTb) {

        testTbDAO.addTestTb(testTb);

        //int num = 5/0;

        TestTb testTb2 = new TestTb();
        testTb2.setName("范冰冰21");
        testTb2.setBirthday(new Date());
        testTbDAO.addTestTb(testTb2);
    }
}

