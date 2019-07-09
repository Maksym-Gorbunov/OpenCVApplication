package com.recognition.video;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;

public class MainFrame2 extends JFrame {
  private static final long serialVersionUID = 1L;
  private Detector detector;
  private CameraPanel cameraPanel;

  public MainFrame2() {
    super("Face Detection");

    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    this.detector = new Detector();
    this.cameraPanel = new CameraPanel();

    setContentPane(this.cameraPanel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 500);
    setVisible(true);
  }

  public void displayScreen() {
    Mat webcamImage = new Mat();
    VideoCapture videoCapture = new VideoCapture(0);

    if (videoCapture.isOpened()) {
      while (true) {
        videoCapture.read(webcamImage);
        if (!webcamImage.empty()) {
          setSize(webcamImage.width() + 50, webcamImage.height() + 70);
          webcamImage = detector.detect(webcamImage);
          cameraPanel.convertMatToImage(webcamImage);
          cameraPanel.repaint(); // update camera panel
        } else {
          System.out.println("Problem");
          break;
        }
      }
    }
  }
}
