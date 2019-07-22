package webcam001;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.ByteArrayInputStream;
//import org.opencv.*;
import org.opencv.core.*;

import java.awt.image.BufferedImage;
import java.awt.Graphics;


public class GUI extends javax.swing.JFrame {
  private JButton startButton;
  private JButton pauseButton;
  private JPanel camera;

  public GUI() {
    initComponents();
  }

  private void initComponents() {
    JFrame frame = new JFrame();
    this.add(startButton);
    this.add(pauseButton);
    this.add(camera);
    frame.setVisible(true);
  }


  public static void main(String[] args) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new GUI().setVisible(true);
      }
    });
  }

  private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
    webSource = new VideoCapture(0);
    myThread = new DaemonThread();
    Thread t = new Thread(myThread);
    t.setDaemon(true);
    myThread.runnable = true;
    t.start();
    startButton.setEnabled(false);  //start button
    pauseButton.setEnabled(true);  // stop button
  }

  private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {
    myThread.runnable = false;
    pauseButton.setEnabled(false);
    startButton.setEnabled(true);

    webSource.release();
  }


//   startButton.addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent arg0) {
//      int action = JOptionPane.showConfirmDialog(MainFrame.this, Constants.EXIT_WARNING);
//      if(action == JOptionPane.OK_OPTION){
//        System.gc();
//        System.exit(0);
//      }
//    }
//  });


  // definitions
  private DaemonThread myThread = null;
  int count = 0;
  VideoCapture webSource = null;

  Mat frame = new Mat();
  MatOfByte mem = new MatOfByte();


  // class DeamonThread
  class DaemonThread implements Runnable {
    protected volatile boolean runnable = false;

    @Override
    public void run() {
      synchronized (this) {
        while (runnable) {
          if (webSource.grab()) {
            try {
              webSource.retrieve(frame);
//              Highgui.imencode(".bmp", frame, mem);
              Imgcodecs.imencode(".bmp", frame, mem);
              BufferedImage buff = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

//              BufferedImage buff = (BufferedImage) im;
              Graphics g = camera.getGraphics();

              if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null))

                if (runnable == false) {
                  System.out.println("Going to wait()");
                  this.wait();
                }
            } catch (Exception ex) {
              System.out.println("Error");
            }
          }
        }
      }
    }
  }


}
