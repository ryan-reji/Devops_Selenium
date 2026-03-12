package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AdditionWebAppTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("file:///C:/addition-webapplication/src/main/webapp/index.html");
    }

    @Test
    public void testAdditionOfTwoNumbers() throws InterruptedException {
        WebElement num1 = driver.findElement(By.id("num1"));
        num1.sendKeys("5");

        WebElement num2 = driver.findElement(By.id("num2"));
        num2.sendKeys("7");

        WebElement addButton = driver.findElement(By.cssSelector("input[type='submit']"));
        addButton.click();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("Sum = 12", result.getText());

        // Keep browser open for 10 seconds after test
        Thread.sleep(10000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
