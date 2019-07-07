package com.recognition.gui;

import com.recognition.constants.Constants;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;

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

  public void updadeImage(final Image image) {
    imageLabel.setIcon(new ImageIcon(scaleImage(image)));
  }

  private Image scaleImage(Image image) {
    return image.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
  }

  public void loadImage(File file) {
    this.transformedImageIcon = new ImageIcon(file.getAbsolutePath());
    Image image = transformedImageIcon.getImage();
    updadeImage(image);
  }
}
