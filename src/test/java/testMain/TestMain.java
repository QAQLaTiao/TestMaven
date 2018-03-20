package testMain;

import com.guoy.dao.MyBatisDao;
import com.guoy.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMain {
	
	
	@Resource
	MyBatisDao myBatisDao;
	
	
	public static void main(String[] args) {
		HashMap<String,Object>map = new HashMap<String,Object>();
		
		System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
		
		//map.put("seqNo", GenerateSequenceUtil.generate19SequenceNoLong());
		
		//System.out.println(JSONObject.toJSONString(map));
		
		//System.out.println(GenerateSequenceUtil.generate19SequenceNoLong());
	}
	
	
	@Test
	public void queryUserAll() {
		List<User> selectList = myBatisDao.selectList("UserMapper.queryUserAll");
		
		System.out.println(selectList);
	
	}
}