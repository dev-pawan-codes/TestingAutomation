
package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    public void testWebForm() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            WebElement textBox = driver.findElement(By.name("my-text"));
            textBox.sendKeys("Hello DevOps");

            driver.findElement(By.cssSelector("button")).click();

            WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(d ->
                d.findElement(By.tagName("body"))
                 .getText().contains("Received!")
            );

            String pageText =
                driver.findElement(By.tagName("body")).getText();

            assertTrue(pageText.contains("Received!"));
            System.out.println("Success message verified.");

        } finally {
            driver.quit();
        }
    }
}
