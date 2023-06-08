package com.resolver.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utilities {
    /**
     * @param driver
     * This method opens QE-index.html page.
     */
    public void openPage(WebDriver driver){
        String localFileLocation = "file:///Users/sureshkalyani/Downloads/QE-index.html";

        driver.get(localFileLocation);
        driver.manage().window().maximize();
    }
}
