package com.resolver.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;
import static com.resolver.app.Constants.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class ResolverTest {
    WebDriver driver;
    Utilities utilities;
    WebDriverWait wait;
    TestPage testPage;

    @BeforeClass
    public void setUp(){

        String driverLocation = "/Users/sureshkalyani/JAVA/chromedriver";
        System.setProperty("webdriver.chromedriver.path",driverLocation);
        driver = new ChromeDriver();
        utilities = new Utilities();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testPage = new TestPage(driver);
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }

    @BeforeMethod
    public void openPage(){
        utilities.openPage(driver);
    }

    @Test(enabled = true)
    public void test1_SampleLogin() {

        WebElement emailField =  testPage.findEmail();
        WebElement passwordField = testPage.findPassword();
        WebElement loginButton = testPage.findLoginButton();

        //Assert that both the email address and password inputs are present as well as the login button
        assertEquals(true, emailField.isDisplayed());
        assertEquals(true, passwordField.isDisplayed());
        assertEquals(true, loginButton.isDisplayed());

        //Enter in an email address and password combination into the respective fields
        emailField.sendKeys(EMAIL);
        passwordField.sendKeys(PASSWORD);
    }

    @Test (enabled = true)
    public void test2_ListItems() {

        List<WebElement> listItems = testPage.findListOfItems();
        //Assert that there are three values in the listgroup
        assertEquals("There are three values in the list group", EXPECTEDITEMSINLIST, listItems.size());
        //Assert that the second list item's value is set to "List Item 2"
        assertTrue(listItems.get(1).getText().contains(EXPECTEDSECONDITEMVALUE));
        //Assert that the second list item's badge value is 6
        assertEquals("Badge Value is 6.", EXPECTEDSECONDITEMBADGEVALUE, testPage.findSecondItemInList().getText());

    }

    @Test (enabled = true)
    public void test3_dropDown() {
        //Assert that "Option 1" is the default selected value
        assertEquals("Default option is Option 1.", EXPECTEDOPTION1, testPage.findDropDown().getText());
        testPage.findDropDown().click();
        testPage.findOption3().click();
        //Assert that "Option 3" is the selected value
        assertEquals("Selected option is Option 3.", EXPECTEDOPTION3, testPage.findDropDown().getText());

    }

    @Test (enabled = true)
    public void test4_EnabledDisabledButton() {

        assertEquals("Button 1 is enabled.", true, testPage.findEnabledButton().isEnabled());
        assertEquals("Button 2 is disabled.", false, testPage.findDisabledButton().isEnabled());

    }

    @Test (enabled = true)
    public void test5_WaitForButton() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(testPage.test5Button)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(testPage.test5Alert));
        String actualAlertMessage = testPage.findTest5Alert().getText();
        assertEquals("Alert message should be same.", EXPECTEDALERTMESSAGE, actualAlertMessage);
        assertEquals("Button is disabled now.", false, testPage.findTest5Button().isEnabled());

    }

    @Test (dataProvider = "test6")
    public void test6_ValueInGrid(int x, int y, String expectedValueofCell) {

        String actualValueOfCell = testPage.findCellValueInTheGrid(x+1,y+1).getText();
        assertEquals("Expected and Actual values of cell match.", expectedValueofCell, actualValueOfCell);

    }

    @DataProvider(name = "test6")
    public static Object[][] cellCoordinatesAndExpectedValues() {
        return new Object[][] {{2, 2, "Ventosanzap"}};
    }

}