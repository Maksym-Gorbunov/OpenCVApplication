package com.recognition.algoritm;

import com.recognition.constants.Constants;
import com.recognition.gui.ImagePanel;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.awt.image.BufferedImage;

import java.io.File;

public class FaceDetection {
  private CascadeClassifier cascadeClassifier;

  public FaceDetection() {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    this.cascadeClassifier = new CascadeClassifier(Constants.CASCADE_CLASSIFIER);
  }

  public void detectFaces(File file, ImagePanel imagePanel) {
    Mat image = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);

    MatOfRect faceDetections = new MatOfRect();
    cascadeClassifier.detectMultiScale(image, faceDetections);

    // Paint rectangles around recognized faces
    for (Rect rect : faceDetections.toArray()) {
      Imgproc.rectangle(image,
              new Point(rect.x, rect.y),
              new Point(rect.x + rect.width, rect.y + rect.height),
              new Scalar(100, 100, 250), 10);
    }

    BufferedImage bufferedImage = convertMatToImage(image);
    imagePanel.updadeImage(bufferedImage);
  }

  private BufferedImage convertMatToImage(Mat image) {
  }
}
