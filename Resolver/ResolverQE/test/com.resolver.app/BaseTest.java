package com.resolver.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static com.resolver.app.Constants.DRIVER_LOCATION;
import static com.resolver.app.Constants.WAIT_IN_SECONDS;

public class BaseTest {

    WebDriver driver;
    Utilities utilities;
    WebDriverWait wait;
    TestPage testPage;

    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chromedriver.path",DRIVER_LOCATION);
        driver = new ChromeDriver();
        utilities = new Utilities();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_IN_SECONDS));
        testPage = new TestPage(driver);
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
