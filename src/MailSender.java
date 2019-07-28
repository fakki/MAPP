import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    public MailSender(String from, String to, String subject, String account, String password, String content, String host){
        fromText = from;
        toText = to;
        subjectText = subject;
        accountText = account;
        passwordText = password;
        contentText = content;
        hostName = "smtp." + host + ".com";
    }

    public MimeMessage sendMail() throws Exception{
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.host", hostName);

        Session session = Session.getInstance(prop);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromText));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toText));
        message.setSubject(subjectText, "UTF-8");
        message.setContent(contentText, "text/html;charset=UTF-8");

        Transport transport = session.getTransport("smtp");
        transport.connect(hostName, accountText, passwordText);
        transport.sendMessage(message, message.getAllRecipients());

        transport.close();

        return message;
    }

    private String fromText;
    private String toText;
    private String subjectText;
    private String accountText;
    private String passwordText;
    private String contentText;
    private String hostName;
}
