package com.recognition.gui;

import com.recognition.constants.Constants;

import javax.swing.*;
import java.awt.BorderLayout;

public class ImagePanel extends JPanel{
  private static final long serialVersionUID = 1L;
  private JLabel imageLabel;

  public ImagePanel(){
    this.imageLabel = new JLabel();

    setLayout(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(Constants.IMAGE_LABEL_BORDER, Constants.IMAGE_LABEL_BORDER,
            Constants.IMAGE_LABEL_BORDER, Constants.IMAGE_LABEL_BORDER));
    add(imageLabel, BorderLayout.CENTER);
  }
}
