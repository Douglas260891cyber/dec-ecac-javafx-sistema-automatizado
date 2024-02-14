package br.com.jb;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.robot.Robot;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

public class EcacComponent {

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

    moverMouse(800, 310, scene);

    // Simula um clique automático após 3 segundos
    new Timer()
      .schedule(
        new TimerTask() {
          @Override
          public void run() {
            simularClique(scene, 800, 310);
          }
        },
        3000
      ); // 3000 milissegundos = 3 segundos
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

  // Simula um clique na posição (x, y)
  private void simularClique(Scene scene, int x, int y) {
    Platform.runLater(() -> {
      try {
        Robot robot = new Robot();

        Double sceneX = scene.getWindow().getX() + scene.getX() + x;
        Double sceneY = scene.getWindow().getY() + scene.getY() + y;

        robot.mouseMove(sceneX.intValue(), sceneY.intValue());
        robot.mousePress(MouseButton.PRIMARY);
        robot.mouseRelease(MouseButton.PRIMARY);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  private Integer valorRandomico() {
    Random random = new Random();
    return random.nextInt(0);
  }
}
