package br.com.jb;

import javafx.scene.robot.Robot;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class EcacController {

  private final Robot robot = new Robot();

  public void ecac(@SuppressWarnings("exports") Stage stage) {
    try {
      String url = "https://www4.cav.receita.fazenda.gov.br/autenticacao";

      EcacVO vo = new EcacVO(stage, new WebView(), url, robot);
      EcacComponent component = new EcacComponent();
      component.start(vo);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
