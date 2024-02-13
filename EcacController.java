package br.com.jb;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class EcacController {

  @FXML
  private Button btnAcessar;

  @FXML
  private WebView webViewPage;

  @FXML
  void site(ActionEvent event) {
    String url =
      "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwi60dq0" +
      "8Z6EAxVWqpUCHQ8lCNsQjBB6BAgKEAE&url=https%3A%2F%2Fwww4.cav.receita.fazenda.gov.br%2Fautenticaca" +
      "o&usg=AOvVaw3S8f5EXwMBh58WT5aMnhfz&opi=89978449";

    WebEngine webEngine = webViewPage.getEngine();

    webEngine.setJavaScriptEnabled(false);
    webEngine.setUserAgent(
      "Mozilla/5.0 (Windows NT 11.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
    );
    carregarURLComCabeçalhos(webEngine, url);
  }

  private void carregarURLComCabeçalhos(WebEngine webEngine, String url) {
    // Configura os cabeçalhos HTTP
    Map<String, String> headers = new HashMap<>();
    headers.put("Referer", url);

    try {
      // Abre a conexão HTTP
      URL urlObj = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

      for (Map.Entry<String, String> entry : headers.entrySet()) {
        connection.setRequestProperty(entry.getKey(), entry.getValue());
      }
      // Carrega a URL no WebEngine
      webEngine.load(connection.getURL().toString());
      connection.disconnect();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
