package br.com.jb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EcacWebDriveComponent {
    public void start(EcacVO vo) {
        // Configuração do WebDriver (neste caso, ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "/home/douglas/Documentos/chromedriver/chrome_linux/chrome"); // Substitua pelo caminho real do seu chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Execução em modo headless (sem interface gráfica)
        WebDriver driver = new ChromeDriver(options);

        driver.get(vo.getUrl());
    }
}


    

