package testMain;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadCSV {
    public static void main(String[] args) throws Exception {
        File csv = new File("D:\\mobike_new.csv");  // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        try {
            assert br != null;
            while (br.readLine() != null) {
                i++;
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
