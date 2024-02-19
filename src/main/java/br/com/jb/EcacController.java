package br.com.jb;

import javafx.scene.robot.Robot;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class EcacController {

  private final Robot robot = new Robot();

  public void ecac(Stage stage) {
    try {
      String url = "https://cav.receita.fazenda.gov.br/autenticacao/Login";
      EcacVO vo = new EcacVO(stage, new WebView(), url, robot);
    //   EcacComponent component = new EcacComponent();
    //   component.start(vo);
      EcacWebDriveComponent driveComponent = new EcacWebDriveComponent();
      driveComponent.start(vo);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
