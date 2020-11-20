import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmalil {

    SendEmalil() {
        // 收件人
        String to = "392237716@qq.com";
        // 收件人电子邮件
        String from = "sey@live.cn";
        // 指定发送邮件的主机地址为localhost
        String host = "host";
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        // 获取默认session 对象
        Session session = Session.getDefaultInstance(properties);

        try
        {
            // 创建默认的MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set Form: 头部字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: 头部字段
            message.setSubject("This is the Subject Line!");
            // 设置消息体
            message.setText("This is actual message");
            // 发送消息
            Transport.send(message);
            System.out.println("Send message successfully...");
        } catch (MessagingException e)
        {
            e.printStackTrace();
        }

    }
}
