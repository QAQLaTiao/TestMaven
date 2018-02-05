package com.guoy.papaService;

import com.guoy.model.Video;
import com.guoy.util.ConnectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GPPMain {
    private String urlFir = "https://www.797cf.com";

    public List<Video> papaMain(int count,int page,String videlClass) {
        String address = "https://www.797cf.com/htm/downlist"+count+"/" + page + ".htm";


        String result = null;
        try {
            result = ConnectionUtil.Connect(address, "utf-8");
        } catch (Exception e) {
            System.out.println("1c error");
            try {
                result = ConnectionUtil.Connect(address, "utf-8");
            } catch (Exception e1) {
                result = ConnectionUtil.Connect(address, "utf-8");
            }
        }
        System.out.println("1层");

        String[] split = result.split("<li><a href=\"");

        List<String> list = Arrays.asList(split);

        List<String> list1 = new ArrayList<String>(list);
        ;

        list1.remove(0);

        List<Video> videoList = new ArrayList<Video>();
        int cc = 0;
        for (String s : list1) {
            cc++;
            Video video = new Video();

            String[] split1 = s.split("\" target=\"_blank\"><img src=\"");

            String url2 = split1[0];


            String[] split2 = split1[1].split("\" /><h3>");

            String picture = split2[0];

            String[] split3 = split2[1].split("</h3>");

            String title = split3[0];
            try {
                url2 = fenli2(urlFir + url2,cc);
            } catch (Exception e) {
                continue;
            }


            video.setVideoUrl(url2);
            video.setVideoPicture(picture);
            video.setTitle(title);
            video.setVideoClass(videlClass);
            videoList.add(video);
        }

        return videoList;
    }

    private String fenli2(String url,int cc) {

        String result = null;
        try {
            result = ConnectionUtil.Connect(url, "utf-8");
        } catch (Exception e) {
            System.out.println("3c error");
            try {
                result = ConnectionUtil.Connect(url, "utf-8");
            } catch (Exception e1) {
                result = ConnectionUtil.Connect(url, "utf-8");
            }
        }
        System.out.println("3层"+cc);
        String[] split = result.split("generate_down[(]");

        String split1 = split[1];

        String[] split2 = split1.split(" [+] \"");

        String switchS = split2[0];
        String[] split3 = split2[1].split("\"[)];");
        String realUrl = split3[0];

        String movieUrl = "http://down.maomixia.com:888";
        switch (switchS) {
            case "downurl_10_2":
                realUrl = movieUrl + realUrl;
                break;
            case "downurl_24k_2":
                realUrl = movieUrl + realUrl;
                break;
            case "downurl_new_2":
                realUrl = movieUrl + realUrl;
                break;
            case "downurl_69_2":
                realUrl = movieUrl + realUrl;
                break;
            default:
                realUrl = url;
                break;
        }
        return realUrl;
    }
}
