package br.com.jb;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(@SuppressWarnings("exports") Stage stage) {
    EcacController controller = new EcacController();
    controller.ecac(stage);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
