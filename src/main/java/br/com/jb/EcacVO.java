package br.com.jb;

import javafx.scene.robot.Robot;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class EcacVO {

  private Stage stage;

  private WebView WebView;

  private String url;

  private Robot robot;

  public EcacVO() {}

  @SuppressWarnings("exports")
  public EcacVO(Stage stage, WebView webView, String url, Robot robot) {
    this.stage = stage;
    this.WebView = webView;
    this.url = url;
    this.robot = robot;
  }

  @SuppressWarnings("exports")
  public Stage getStage() {
    return this.stage;
  }

  @SuppressWarnings("exports")
  public void setStage(Stage stage) {
    this.stage = stage;
  }

  @SuppressWarnings("exports")
  public WebView getWebView() {
    return this.WebView;
  }

  @SuppressWarnings("exports")
  public void setWebView(WebView webView) {
    this.WebView = webView;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @SuppressWarnings("exports")
  public Robot getRobot() {
    return robot;
  }

  @SuppressWarnings("exports")
  public void setRobot(Robot robot) {
    this.robot = robot;
  }
}
