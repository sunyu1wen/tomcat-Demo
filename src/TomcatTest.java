

//import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatTest {
    private static int post = 5228;

    private static UrlUtil urlutil = new UrlUtil();

    public static void main(String[] args) {
        System.out.println(" My Tomcat is Running");
        try {
            ServerSocket server = new ServerSocket(post);
            while (true) {
                Socket socket = server.accept();// 服务器每接受一次请求，就创建一个socket对象
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(in));
                String info = null;
                String infoline = br.readLine();
                System.out.println("=======scannIn  infoline=====:"+infoline.toString());
                while (infoline != null) {
                    info =info+infoline;
                    infoline = br.readLine();
                }
                UrlBean url = urlutil.readString(info);
                if (url != null) {
                    System.out.println("=======UrlBean=====");
                    String path=url.getPath();
                    String className = url.getFileName();
                    String methodName = url.getParameter().trim();
                    ClassLoader classloader=ClassLoader.getSystemClassLoader();
                    try {
                        classloader.loadClass(path+"."+className);
                        Class<?> getclass=Class.forName(path+"."+className);
                        Method method=getclass.getMethod(methodName, null);
                        method.invoke(getclass.newInstance(), null);

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("=======scannIn  null=====");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
