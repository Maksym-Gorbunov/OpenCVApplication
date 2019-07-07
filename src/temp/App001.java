package temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App001 {
  private JPanel panelMain;
  private JButton buttonMsg;

  public static void main(String[] args) {
    JFrame frame = new JFrame("Apasdfassp001");
    frame.setContentPane(new App001().panelMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public App001() {
    buttonMsg.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Hello");
        JOptionPane.showMessageDialog(null, "MsgBtn Clicked");
      }
    });
  }
}
