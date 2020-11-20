import java.io.*;
import java.net.Socket;

/*
Socket 客户端实例
如下的 GreetingClient 是一个客户端程序，该程序通过 socket 连接到服务器并发送一个请求，然后等待一个响应。
* */

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        System.out.printf("连接到主机：%s，端口号%d", serverName, port);

        try {
            Socket client = new Socket(serverName, port);
            System.out.printf("远程主机地址：%s", client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello form " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应：" + in.readUTF());
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
