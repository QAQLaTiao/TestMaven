package com.guoy.papaService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.guoy.model.Text;
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
    private MyBatisDao myBatisDao;


    @Test
    public void insertyzdy() {

        int i = 0;
        for (int ii = 1; ii < 56; ii++) {
            System.out.println("第" + ii + "页");
            List<Video> list = new ArrayList<>();
            try {
                list = new GPPMain().papaMain(1,ii,"yzdy");
            } catch (Exception e) {
                System.out.println("error");
                continue;
            }
            for (Video video : list) {
                myBatisDao.insert("videoMapper.insert", video);
                i += 1;
                System.out.println(i);
            }
        }
    }

    @Test
    public void insertAll() {
        int i = 0;
        int[] iii = new int[]{16};
        for (int count : iii) {
            System.out.println("type" + count);
            String type = "";
            switch (count) {
                case 12:
                    type = "jtll";
                    break;
                case 13:
                    type = "xycs";
                    break;
                case 14:
                    type = "rqjh";
                    break;
                case 16:
                    type = "gd";
                    break;
                default:
                    type = "ll";
                    break;
            }

            for (int ii = 3; ii < 22; ii++) {
                System.out.println("第" + ii + "页");

                List<Text> list = new ArrayList<>();
                try {
                    list = new GPPText().papaMain(count, ii, type);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                for (Text text : list) {
                    myBatisDao.insert("textMapper.insert", text);
                    i += 1;
                    System.out.println(i);
                }
            }
        }
    }



    @Test
    public void selectText() {
        List<Text> texts = myBatisDao.selectList("textMapper.selectText");
        int i = 0;
        for (Text t : texts) {
            String title = t.getTitle();
            String text = t.getText();
            //text.replaceAll("　","");
            t.setText(text.trim());

            t.setTitle(title.trim());
            int update = myBatisDao.update("textMapper.update", t);
            i++;
            System.out.println(update + " " + i);
        }
    }

    @Test
    public void writeAll() {
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            List<Video> videos = myBatisDao.selectList("videoMapper.selectVideo");
            /* 写入Txt文件 */
            File writename = new File("D:\\video.tx--------------------------t");
            writename.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for (Video v : videos) {
                out.write(v.getTitle() + ",," + v.getVideoUrl() + "\r\n");
            }
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readAll() {
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            //读入TXT文件
            String pathname = "E:/IdeaProjects/TestProject/testMaven/src/main/resources/video.txt";
            //    String pathname = this.getClass().getClassLoader().getResource("/").getPath() + "/video.txt";
            // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname);
            // 要读取以上路径的input.txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader);
            // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                // 一次读入一行数据
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

