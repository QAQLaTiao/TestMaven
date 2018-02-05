package testMain;


import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class TestPy {
    /*
        public static void main(String[] args
    /*        PySystemState sys = Py.getSystemState();
            sys.path.add("E:\\Lib");
            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile("E:/test_exam.py");

            // &#x7b2c;&#x4e00;&#x4e2a;&#x53c2;&#x6570;&#x4e3a;&#x671f;&#x671b;&#x83b7;&#x5f97;&#x7684;&#x51fd;&#x6570;&#xff08;&#x53d8;&#x91cf;&#xff09;&#x7684;&#x540d;&#x5b57;&#xff0c;&#x7b2c;&#x4e8c;&#x4e2a;&#x53c2;&#x6570;&#x4e3a;&#x671f;&#x671b;&#x8fd4;&#x56de;&#x7684;&#x5bf9;&#x8c61;&#x7c7b;&#x578b;
            PyFunction pyFunction = interpreter.get("test_para", PyFunction.class);
            // &#x8c03;&#x7528;&#x51fd;&#x6570;
            PyObject pyObject = pyFunction.__call__(new PyString("bbbbb"));

            System.out.println(pyObject);
        }
    }*/
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            //执行py文件
            args = new String[] { "python E:\\classify\\inference.py", "尿频,尿频"};
            Process proc=Runtime.getRuntime().exec(args);
            InputStreamReader stdin=new InputStreamReader(proc.getInputStream());
            LineNumberReader input=new LineNumberReader(stdin);
            String line;
            while((line=input.readLine())!=null ){
                //得到输出
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}