package cn.com.leyou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * @author XuYuandong
 * @create 2017-10-27 9:49 AM
 * @desc
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestRedis {

    @Autowired
    private Jedis jedis;

    @Test
   public void testRedis(){
        Jedis jedis = new Jedis("192.168.192.128", 6379);
        Long stt = jedis.incr("STT");
        System.out.println(stt);
    }

    @Test
    public void testRedis2(){
        Long pno = jedis.incr("pno");
        System.out.println(pno);
    }

}
