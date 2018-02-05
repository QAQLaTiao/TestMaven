package com.guoy.papaService;

import com.guoy.model.Text;
import com.guoy.util.ConnectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GPPText {
    private String urlFir = "https://www.797cf.com";

    public List<Text> papaMain(int count,int page,String textClass) throws InterruptedException {
        String url = "";
        url = "https://www.797cf.com/htm/novellist"+count+"/"+page+".htm";
        //Thread.sleep(RandomUtil.getRandom(500,1200));
        String result = null;
        try {
            result = ConnectionUtil.Connect(url, "utf-8");
        } catch (Exception e) {
            System.out.println("1c error");
            try {
                result = ConnectionUtil.Connect(url, "utf-8");
            } catch (Exception e1) {
                result = ConnectionUtil.Connect(url, "utf-8");
                e1.printStackTrace();
            }
        }
        System.out.println("1层");

        String[] split = result.split("<li><a href=\"");

        List<String> list = Arrays.asList(split);

        List<String> list1 = new ArrayList<String>(list);
        ;

        list1.remove(0);

        List<Text> videoList = new ArrayList<Text>();
        int cc = 0;
        for (String s : list1) {
            cc++;
            Text text = new Text();

            String[] split1 = s.split("\" target=\"_blank\"><span>");

            String[] split2 = split1[1].split("</span>");

            String[] titles = split2[1].split("</a></li>");

            String title = titles[0];
            String url2 = split1[0];
            String textS = "";
            try {
              //  Thread.sleep(RandomUtil.getRandom(500,1200));
                textS = fenli1(urlFir + url2, title, cc);
            } catch (Exception e) {
                continue;
            }


            text.setText(textS);
            text.setTitle(title);
            text.setTextClass(textClass);
            videoList.add(text);
        }

        return videoList;
    }

    private String fenli1(String url, String title, int cc) throws InterruptedException {
       // Thread.sleep(RandomUtil.getRandom(500,1200));
        String result = null;
        try {
            result = ConnectionUtil.Connect(url, "utf-8");
        } catch (Exception e) {
            System.out.println("2c error");
            try {
                result = ConnectionUtil.Connect(url, "utf-8");
            } catch (Exception e1) {
                result = ConnectionUtil.Connect(url, "utf-8");
                e1.printStackTrace();
            }
        }
        System.out.println("2层" + cc);

        String[] split = result.split("<div class=\"content\">");

        String string = split[1];

        String[] split1 = string.split("</div>");

        String text = split1[0];


        return text;
    }
}
