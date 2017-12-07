package testMain;

import com.guoy.dao.MyBatisDao;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMain {


    @Resource
    MyBatisDao myBatisDao;


    public static void main(String[] args) {

    String nana = "曹亚洁";
        System.out.println(nana);



    }


    @Test
    public void queryUserAll() {
        List<User> selectList = myBatisDao.selectList("UserMapper.queryUserAll");
        //
        System.out.println(selectList);

    }
}