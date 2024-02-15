package br.com.jb;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
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
    stage.setMaximized(false);

    Scene scene = new Scene(vo.getWebView(), 1100, 800);
    vo.getStage().setScene(scene);
    vo.getStage().show();

    gerenciarTimerMovClick(vo, 800, 350);
  }

  public void gerenciarTimerMovClick(EcacVO vo, Integer x, Integer y) {
    Integer initialDelay = valorRandomico() * 5; // Pausa aleatória antes de iniciar a ação de movimento

    new Timer()
      .schedule(
        new TimerTask() {
          @Override
          public void run() {
            moverMouse(x, y, vo);
          }
        },
        initialDelay
      );
  }

  private void moverMouse(Integer finalX, Integer finalY, EcacVO vo) {
    Random random = new Random();
    try {
      double sceneX = vo.getStage().getX() + vo.getStage().getScene().getX();
      double sceneY = vo.getStage().getY() + vo.getStage().getScene().getY();
      final int steps = 5; // Número de etapas para a animação
      final double deltaX = (finalX - sceneX) / (double) steps; // Calcula o incremento horizontal por etapa
      final double deltaY = (finalY - sceneY) / (double) steps; // Calcula o incremento vertical por etapa

      // Executa as etapas de animação
      for (int i = 1; i <= steps; i++) {
        double currentX = sceneX + deltaX * i;
        double currentY = sceneY + deltaY * i;
        final int finalXStep = (int) (
          currentX - vo.getStage().getScene().getX()
        );
        final int finalYStep = (int) (
          currentY - vo.getStage().getScene().getY()
        );

        final int stepIndex = i;
        double acceleration = 1 - Math.cos((stepIndex * Math.PI) / steps);
        int moveDelay = (int) (100 + 200 * acceleration); // Varia o atraso entre 100ms e 300ms conforme a aceleração
        int randomPause = random.nextInt(300); // Pausa aleatória entre 0ms e 300ms

        Platform.runLater(() -> {
          vo.getRobot().mouseMove(finalXStep, finalYStep);
          if (stepIndex == steps) {
            clicar(vo, finalX, finalY);
          }
        });

        Thread.sleep(moveDelay + randomPause);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Simula um clique na posição
  private void clicar(EcacVO vo, int x, int y) {
    Platform.runLater(() -> {
      try {
        vo.getRobot().mouseMove(x, y);
        vo.getRobot().mousePress(MouseButton.PRIMARY);
        vo.getRobot().mouseRelease(MouseButton.PRIMARY);
        System.out.println(
          "CLICOU NA POSICAO X = " + x + " E NA POSICAO Y = " + y
        );
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  private Integer valorRandomico() {
    Random random = new Random();
    return random.nextInt(4000);
  }
}
