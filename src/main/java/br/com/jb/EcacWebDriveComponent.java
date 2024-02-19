package br.com.jb;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcacWebDriveComponent {

    public void start(EcacVO vo) {
        /*
         * ChromeOptions options = new ChromeOptions();
         * options.addArguments("--headless");
         * System.setProperty("webdriver.chrome.driver",
         * "/home/douglas/Documentos/chromedriver/chrome_linux/chrome");
         * WebDriver driver = new ChromeDriver(options);
         * System.out.println("passou");
         * 
         * driver.get(vo.getUrl());
         * driver.quit();
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get(vo.getUrl());
        acoes(driver);
    }

    private void acoes(WebDriver driver) {
        WebElement btnAcessarComGov = driver.findElement(By.xpath("//input[@alt='Acesso Gov BR']"));
        btnAcessarComGov.click();
        // ajustar para sempre mandar um valor diferente de delay
        delay(valorRandomico());

        WebElement inputIFedereal = driver.findElement(By.id("accountId"));
        inputIFedereal.sendKeys("08362514896");

        delay(valorRandomico());

        WebElement btnAcessarConta = driver.findElement(By.id("enter-account-id"));
        btnAcessarConta.click();
    }

    private void delay(Integer delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer valorRandomico() {
        Random random = new Random();
        return random.nextInt(10000);
    }
}
