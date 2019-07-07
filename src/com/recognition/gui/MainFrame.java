package com.recognition.gui;

import com.recognition.algoritm.FaceDetection;
import com.recognition.constants.Constants;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
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
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
  }

  public JMenuBar createMenuBar(){
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenuItem loadMenuItem = new JMenuItem("Load image");
    JMenuItem detectMenuItem = new JMenuItem("Detect faces");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    fileMenu.add(loadMenuItem);
    fileMenu.add(detectMenuItem);
    fileMenu.add(exitMenuItem);

    loadMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
          MainFrame.this.file = fileChooser.getSelectedFile();
          // load the image
        }
      }
    });
    detectMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // detect algorithm
      }
    });
    exitMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        int action = JOptionPane.showConfirmDialog(MainFrame.this, Constants.EXIT_WARNING);
        if(action == JOptionPane.OK_OPTION){
            System.gc();
            System.exit(0);
        }
      }
    });

    JMenu aboutMenu = new JMenu("About");
    JMenu helpMenu = new JMenu("Help");

    menuBar.add(fileMenu);
    menuBar.add(aboutMenu);
    menuBar.add(helpMenu);

    return menuBar;
  }
}
