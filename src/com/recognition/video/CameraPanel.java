package com.recognition.video;

import javafx.scene.paint.Color;
import org.opencv.core.Mat;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.*;
import java.awt.Graphics;

public class CameraPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private BufferedImage bufferedImage;

  public CameraPanel() {
  }

  // Matrix image BlueGreenRed
  public boolean convertMatToImage(Mat matBGR) {
    int width = matBGR.width();
    int height = matBGR.height();
    int channels = matBGR.channels();

    byte[] sourcePixels = new byte[width * height * channels];
    matBGR.get(0, 0, sourcePixels);
    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    final byte[] targetPixel = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
    System.arraycopy(sourcePixels, 0, targetPixel, 0, sourcePixels.length);
    return true;
  }

  public void paintComponent(Graphics g) {
    System.out.println("ppppppppppppppppppppppppppppp");
    super.paintComponent(g);
    if (this.bufferedImage == null) {
      return;
    }
    g.drawImage(this.bufferedImage, 10, 10, this.bufferedImage.getWidth(), this.bufferedImage.getHeight(), null);
  }

//  public void setBackground(Color color) {
//    g.setBackground(color);
//  }
}
