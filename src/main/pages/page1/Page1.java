package main.pages.page1;

import main.pages.Pages;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class Page1 extends JFrame implements Pages {
  private static final long serialVersionUID = 1L;
  private JButton startButton;
  private JButton pauseButton;
  private JButton testButton;
  private JPanel webcamPanel;
  private Graphics graphics;
  private boolean status = false;
  private Color defaultPanelColor;

  public Page1(JButton startButton, JButton pauseButton, JButton testButton, JPanel webcamPanel) {
    this.startButton = startButton;
    this.pauseButton = pauseButton;
    this.testButton = testButton;
    this.webcamPanel = webcamPanel;

    defaultPanelColor = webcamPanel.getBackground();

    addListenersToPage1();
  }

  private void addListenersToPage1() {
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Start...");
        webSource = new VideoCapture(0);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        startButton.setEnabled(false);  //start button
        pauseButton.setEnabled(true);  // stop button
      }
    });

    pauseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Pause...");
        myThread.runnable = false;
        pauseButton.setEnabled(false);
        startButton.setEnabled(true);
        webSource.release();
      }
    });

    testButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        status = !status;
        if (status) {
          webcamPanel.setBackground(Color.ORANGE);
        } else {
          webcamPanel.setBackground(defaultPanelColor);
        }
        JOptionPane.showMessageDialog(null, "Test...", "Test title", JOptionPane.QUESTION_MESSAGE);
      }
    });

  }


  // definitions
  private Page1.DaemonThread myThread = null;
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
              Imgcodecs.imencode(".bmp", frame, mem);
              BufferedImage buff = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
              graphics = webcamPanel.getGraphics();
              if (graphics.drawImage(buff, 0, 0, 640, 480, 0, 0, buff.getWidth(), buff.getHeight(), null))
                if (runnable == false) {
                  System.out.println("Going to wait()");
                  this.wait();
                }
            } catch (Exception e) {
              System.out.println("Error");
            }
          }
        }
      }
    }
  }
}
