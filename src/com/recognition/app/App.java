package com.recognition.app;

import com.recognition.image.gui.MainFrame;
import com.recognition.video.MainFrame2;

import javax.swing.*;

public class App {
  public static void main(String[] args) {
    try{
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException
            | UnsupportedLookAndFeelException | IllegalAccessException e) {
      e.printStackTrace();
    }

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
//        new MainFrame();
        MainFrame2 mainFrame = new MainFrame2();
        mainFrame.displayScreen();
      }
    });
  }
}
