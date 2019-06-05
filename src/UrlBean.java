

//格式：协议：//主机号：端口号/目录路径/文件名
//例如： http：//127.0.0.1:8080/Test/Manage/index.jsp?a=1&b=2
public class UrlBean {
    private String Protocol;
    private String Host;
    private String Port;
    private String Path;
    private String FileName;
    private String Parameter;

    public UrlBean(String protocol, String host, String port, String path,
                   String fileName, String parameter) {
        super();
        Protocol = protocol;
        Host = host;
        Port = port;
        Path = path;
        FileName = fileName;
        Parameter = parameter;
    }

    public UrlBean() {
    }

    public String getProtocol() {
        return Protocol;
    }

    public void setProtocol(String protocol) {
        Protocol = protocol;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getParameter() {
        return Parameter;
    }

    public void setParameter(String parameter) {
        Parameter = parameter;
    }
}
