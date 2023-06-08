package com.resolver.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestPage {

    WebDriver driver;
    public TestPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("inputEmail");
    By password = By.id("inputPassword");
    By loginButton = By.xpath("//*[@id=\"test-1-div\"]/form/button");
    By listOfItems = By.xpath("//*[@id=\"test-2-div\"]/ul/li");
    By secondItemInList = By.xpath("//*[@id=\"test-2-div\"]/ul/li[2]/span");
    By dropDown = By.xpath("//*[@id=\"dropdownMenuButton\"]");
    By option3 = By.xpath("//*[@id=\"test-3-div\"]/div/div/a[3]");
    By enabledButton = By.xpath("//*[@id=\"test-4-div\"]/button[1]");
    By disabledButton = By.xpath("//*[@id=\"test-4-div\"]/button[2]");
    By test5Button = By.xpath("//*[@id=\"test5-button\"]");
    By test5Alert = By.xpath("//*[@id=\"test5-alert\"]");


    public  WebElement findEmail() {
        return driver.findElement(email);
    }

    public WebElement findPassword() {
        return driver.findElement(password);
    }

    public WebElement findLoginButton() {
        return driver.findElement(loginButton);
    }

    public List<WebElement> findListOfItems() {
        return  driver.findElements(listOfItems);
    }

    public WebElement findSecondItemInList() {
        return driver.findElement(secondItemInList);
    }

    public WebElement findDropDown() {
        return driver.findElement(dropDown);
    }

    public WebElement findOption3() {
        return driver.findElement(option3);
    }
    public WebElement findEnabledButton() {
        return driver.findElement(enabledButton);
    }
    public WebElement findDisabledButton() {
        return driver.findElement(disabledButton);
    }
    public WebElement findTest5Button() {
        return driver.findElement(test5Button);
    }
    public WebElement findTest5Alert() {
        return driver.findElement(test5Alert);
    }
    public WebElement findCellValueInTheGrid(int x, int y){
        By cellAtXAndY = By.xpath("//*[@id=\"test-6-div\"]/div/table/tbody/tr[" + x + "]/td[" + y + "]");
        return driver.findElement(cellAtXAndY);
    }

}
