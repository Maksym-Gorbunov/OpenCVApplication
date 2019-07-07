package com.recognition.algoritm;

import com.recognition.constants.Constants;
import org.opencv.core.Core;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetection {
  private CascadeClassifier cascadeClassifier;

  public FaceDetection() {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    this.cascadeClassifier = new CascadeClassifier(Constants.CASCADE_CLASSIFIER);
  }
}
