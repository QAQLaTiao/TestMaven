package com.guoy.papa.service;

import com.guoy.papa.service.model.Video;
import com.guoy.util.ConnectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GPPMain {
	private String urlFir = "http://retysd.com";

	public List<Video> papaMain(int page) {
		String address = "http://retysd.com/video-list-id-28-page-"+page+".html";
		
		String result = ConnectionUtil.Connect(address);
		System.out.println("1层");
		
		String[] split = result.split("<li>");
		
		List<String> list = Arrays.asList(split);
		
		List<String> list1 = new ArrayList<String>(list);;
		
		for(int i=0;i<3;i++) {
			list1.remove(0);
		}
		
		list1.remove(list1.size()-1);
		
//		System.out.println(JSON.toJSONString(list1));
		
		List<Video> videoList = new ArrayList<Video>();

		for(String s : list1) {
			Video video = new Video();
			String[] split2 = s.split("\"");
			String url2;
			List<String> list3 = Arrays.asList(split2);
			try {
			String url1 = fenli1(urlFir+list3.get(1));
			video.setBbb(url1);
			url2 = fenli2(url1);
			}catch(Exception e){
				continue;
			}
			
			video.setVideoUrl(url2);
			video.setVideoPicture(urlFir+list3.get(7));
			video.setTitle(list3.get(9));
			video.setAaa(urlFir+list3.get(13));
			video.setVideoName(list3.get(14));
			videoList.add(video);
		}
		
		return videoList;
	}
	
	public String fenli1(String url) {
		
		String result = ConnectionUtil.Connect(url);
		System.out.println("2层");
		
		String[] split = result.split("HTML5");
		
		String string = split[1];
		
		String[] split1 = string.split("a title='第1集' href=\"");
		
		String string2 = split1[1];
		
		String[] split3 = string2.split("\"");
		
		url = urlFir+split3[0];
		
		return url;
	}
	
	public String fenli2(String url) {
		
		String result = ConnectionUtil.Connect(url);
		System.out.println("3层");
		String[] split = result.split("video src=\"");
		
		String string = split[1];
		
		String[] split1 = string.split("\"");
		
		url = split1[0];
		
		return url;
	}
}
