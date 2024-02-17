package br.com.jb;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javafx.scene.robot.Robot;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class EcacController {

  private final Robot robot = new Robot();

  public void ecac(Stage stage) {
    try {
      String url = "https://www.selenium.dev/downloads/";

      EcacVO vo = new EcacVO(stage, new WebView(), url, robot);
      // EcacComponent component = new EcacComponent();
      // component.start(vo);
      EcacWebDriveComponent driveComponent = new EcacWebDriveComponent();
      driveComponent.start(vo);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
