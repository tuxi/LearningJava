/*
Socket 服务端实例
如下的GreetingServer 程序是一个服务器端应用程序，使用 Socket 来监听一个指定的端口。
* */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while (true) {

            System.out.printf("等待远程连接，端口号为：%s ...", serverSocket.getLocalPort());
            try
            {
                Socket server = serverSocket.accept();
                System.out.printf("远程主机地址：%s ", server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.printf(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye");
                server.close();
            }
            catch (SocketTimeoutException ex1) {
                System.out.println("Socket time out");
            }
            catch (IOException e)
            {
                e.printStackTrace();
                break;
            }

        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try
        {
            Thread t = new GreetingServer(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
