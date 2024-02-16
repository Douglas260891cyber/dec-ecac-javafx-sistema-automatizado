module br.com.jb {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;
  requires org.jsoup;

  opens br.com.jb to javafx.fxml;
  exports br.com.jb ;
}
