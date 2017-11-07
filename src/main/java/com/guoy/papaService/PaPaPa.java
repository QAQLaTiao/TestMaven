package com.guoy.papaService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guoy.dao.MyBatisDao;
import com.guoy.model.Video;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PaPaPa {

	@Resource
	MyBatisDao myBatisDao;
	
	
	@Test
	public void queryAll() {
		int i =0;
		double o = 3.14159*1;
		for(int ii = 1 ; ii <57 ; ii++) {
			System.out.println("第"+ii+"页");
			
			List<Video> list; 
			try {
			list = new GPPMain().papaMain(ii);
			}catch(Exception e){
				continue;
			}
			for (Video video : list) {
				myBatisDao.insert("videoMapper.insertVideo", video);
				i+=1;
				System.out.println(i);
			}
		}
	}
}
