package webadv.s99201105.p02;

import org.apache.commons.codec.digest.DigestUtils;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        if(args[0].equals("17205117_黄鹏飞")&&sha256hex(args[1]).equals("8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92")){
            System.out.println("登录成功!");
         }
         else{
            System.out.println("登录失败!");
         }
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
