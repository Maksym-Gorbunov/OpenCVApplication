package com.recognition.gui;

import com.recognition.algoritm.FaceDetection;
import com.recognition.constants.Constants;

import javax.swing.*;
import java.io.File;

public class MainFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private ImagePanel imagePanel;
  private JFileChooser fileChooser;
  private FaceDetection faceDetection;
  private File file;

  public MainFrame(){
    super(Constants.APPLICATION_NAME);

    setJMenuBar(createMenuBar());

    this.imagePanel = new ImagePanel();
    this.fileChooser = new JFileChooser();
    this.faceDetection = new FaceDetection();

    add(imagePanel, BorderLayout.CENTER);

    setSize();
  }
}
