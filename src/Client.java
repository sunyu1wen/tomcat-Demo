import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ${bocai}
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(客户端调用目标端口)
 * @Date ${date} ${time}
 */
public class Client {
    private static int port =5228;
    private static String host = "127.0.0.1";
    public static void main(String[] args){
      try {
          Socket con = new Socket(host,port);
          System.out.println("请输入URL地址：");
          Scanner sacnner = new Scanner(System.in);
          String info = sacnner.nextLine().trim();
          Writer writer = new OutputStreamWriter(con.getOutputStream());
          writer.write(info);
          writer.flush();
          writer.close();

      }catch (IOException e){
          e.printStackTrace();
        }
    };


}
