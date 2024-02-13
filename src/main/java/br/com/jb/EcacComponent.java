package br.com.jb;

import javafx.scene.Scene;
import javafx.scene.robot.Robot;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

public class EcacComponent<MouseRobot> {

  public void start(EcacVO vo) {
    WebEngine webEngine = vo.getWebView().getEngine();
    webEngine.load(vo.getUrl());
    webEngine.setJavaScriptEnabled(false);

    Stage stage = vo.getStage();
    stage.setX(0);
    stage.setY(0);
    stage.setWidth(1000);
    stage.setHeight(800);

    Scene scene = new Scene(vo.getWebView(), 1100, 800);
    vo.getStage().setScene(scene);
    vo.getStage().show();

    moverMouse(800, 360, scene);
  }

  // Movendo
  private void moverMouse(int x, int y, Scene scene) {
    try {
      Robot robot = new Robot();

      Double sceneX = scene.getWindow().getX() + scene.getX() + x;
      Double sceneY = scene.getWindow().getY() + scene.getY() + y;

      robot.mouseMove(sceneX.intValue(), sceneY.intValue());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
