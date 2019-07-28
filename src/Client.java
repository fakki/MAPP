import javax.mail.*;
import javax.swing.*;
import java.awt.EventQueue;

public class Client {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClientFrame frame = new ClientFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
