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
    stage.setWidth(1000);
    stage.setHeight(800);

    Scene scene = new Scene(vo.getWebView(), 1100, 800);
    vo.getStage().setScene(scene);
    vo.getStage().show();

    gerenciarTimerMovClick(vo);
  }

  //Gerencia movimentação e click do mouse
  public void gerenciarTimerMovClick(EcacVO vo) {
    new Timer()
      .schedule(
        new TimerTask() {
          @Override
          public void run() {
            for (int i = 0; i < 3; i++) {
              Integer x = valorRandomico();
              Integer y = valorRandomico();
              //Gera novos valores randomicos para o movimento do cursor antes do clique.
              new Timer()
                .schedule(
                  new TimerTask() {
                    @Override
                    public void run() {
                      moverMouse(x, y, vo, false);
                    }
                  },
                  valorRandomico()
                );
            }
            moverMouse(800, 350, vo, true);
          }
        },
        valorRandomico()
      );
  }

  private void moverMouse(
    Integer finalX,
    Integer finalY,
    EcacVO vo,
    Boolean vaiClicar
  ) {
    try {
      Double sceneX = vo.getStage().getX() + vo.getStage().getScene().getX();
      Double sceneY = vo.getStage().getY() + vo.getStage().getScene().getY();

      final Integer steps = 15; // Número de etapas para a animação
      final Double deltaX = (finalX - sceneX) / steps; // Calcula o incremento horizontal por etapa
      final Double deltaY = (finalY - sceneY) / steps; // Calcula o incremento vertical por etapa

      // Executa as etapas de animação
      for (int i = 1; i <= steps; i++) {
        final Double currentX = sceneX + deltaX * i;
        final Double currentY = sceneY + deltaY * i;
        final int finalXStep = (int) (
          currentX - vo.getStage().getScene().getX()
        );
        final int finalYStep = (int) (
          currentY - vo.getStage().getScene().getY()
        );

        final int stepIndex = i; // Mantém o índice da etapa como final para uso dentro da lambda
        Platform.runLater(() -> {
          vo.getRobot().mouseMove(finalXStep, finalYStep);
          if (vaiClicar && stepIndex == steps) { // Clica apenas no último passo
            simularClique(vo, finalX, finalY); // Clica nas coordenadas finais
          }
        });

        Thread.sleep(100); // Adiciona um pequeno atraso entre as etapas (simulando uma animação mais suave)
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Simula um clique na posição
  private void simularClique(EcacVO vo, int x, int y) {
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
    Integer valor = random.nextInt(15000 - 1000 + 1) + 1000;
    return valor;
  }
}
