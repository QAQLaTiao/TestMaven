package testMain;

import com.guoy.dao.MyBatisDao;
import com.guoy.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMain {


    @Autowired
    MyBatisDao myBatisDao;


    public static void main(String[] args) {

    String nana = "曹亚洁";
        System.out.println(nana);



    }


    @Test
    public void queryUserAll() {
        List<User> selectList = myBatisDao.selectList("UserMapper.queryUserAll");
        //
        for(User u : selectList) {
            System.out.println(u);
        }
    }
}