package webadv.s99201105.p02;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        try{
            String encoding="utf-8"; //设置读取文件的字符编码
            File file=new File("password.txt");//获取文件句柄
            if(file.isFile() && file.exists()){ 
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String line = null;
                while((line = bufferedReader.readLine()) != null)
                {
                    if(line.equals(args[0]+sha256hex(args[1]))){
                        System.out.println("登录成功!");
                    }
                    else{
                        System.out.println("登录失败!");
                    }
                 }
                 read.close();
             }else
             {
                 System.out.println("找不到指定的文件");
             }
         } catch (Exception e)
         {
             System.out.println("读取文件内容出错");
             e.printStackTrace();
         }
        
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
