import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientFrame extends JFrame {
    public ClientFrame(){
        setTitle("MailAPP");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        final JTextField from = new JTextField();
        final JTextField to = new JTextField();
        final JTextField subject = new JTextField();
        final JTextField account = new JTextField();
        final JTextField hostType = new JTextField();
        final JPasswordField password = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(7, 2));
        northPanel.add(new JLabel("寄件人:           ", SwingConstants.RIGHT));
        northPanel.add(from);
        northPanel.add(new JLabel("收件人:           ", SwingConstants.RIGHT));
        northPanel.add(to);
        northPanel.add(new JLabel("主题:             ", SwingConstants.RIGHT));
        northPanel.add(subject);
        northPanel.add(new JLabel("账号:             ", SwingConstants.RIGHT));
        northPanel.add(account);
        northPanel.add(new JLabel("密码:             ", SwingConstants.RIGHT));
        northPanel.add(password);
        northPanel.add(new JLabel("寄件人邮箱地址类型: ", SwingConstants.RIGHT));
        northPanel.add(hostType);
        northPanel.add(new JLabel("邮件内容:          ", SwingConstants.RIGHT));

        add(northPanel, BorderLayout.NORTH);


        final JTextArea message = new JTextArea(8, 40);
        JScrollPane scrollPanel = new JScrollPane(message);
        add(scrollPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        JButton sendButton = new JButton("发送");
        southPanel.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MailSender mailSender = new MailSender(from.getText(), to.getText(),
                        subject.getText(), account.getText(), new String(password.getPassword()),
                        message.getText(), hostType.getText());
                try {
                    mailSender.sendMail();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        add(southPanel, BorderLayout.SOUTH);

    }

    public static final int DEFAULT_WIDTH = 700;
    public static final int DEFAULT_HEIGHT = 300;
}
