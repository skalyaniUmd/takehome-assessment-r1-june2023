package com.resolver.app;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import static com.resolver.app.Constants.LOCAL_FILE_LOCATION;

public class Utilities {
    /**
     * @param driver This method opens QE-index.html page.
     */
    public void openPage(WebDriver driver) {
        try {
            driver.get(LOCAL_FILE_LOCATION);
        } catch (InvalidArgumentException e) {
            Reporter.log("File location issue: " + e.getMessage());
        }
        driver.manage().window().maximize();
    }
}
