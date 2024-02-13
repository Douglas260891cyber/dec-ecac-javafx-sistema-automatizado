package br.com.jb;

import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class EcacController {

  public void ecac(@SuppressWarnings("exports") Stage stage) {
    String url =
      "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwi60dq0" +
      "8Z6EAxVWqpUCHQ8lCNsQjBB6BAgKEAE&url=https%3A%2F%2Fwww4.cav.receita.fazenda.gov.br%2Fautenticaca" +
      "o&usg=AOvVaw3S8f5EXwMBh58WT5aMnhfz&opi=89978449";

    EcacVO vo = new EcacVO(stage, new WebView(), url);
    EcacComponent component = new EcacComponent();
    component.start(vo);
  }
}
