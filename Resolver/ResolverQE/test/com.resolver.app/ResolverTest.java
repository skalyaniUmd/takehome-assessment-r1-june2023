package com.resolver.app;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import java.util.List;
import org.testng.Reporter;
import static com.resolver.app.Constants.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class ResolverTest extends BaseTest{

    @BeforeMethod
    public void openPage(){
        utilities.openPage(driver);
    }

    @AfterMethod (enabled = false)
    public void cleanUpAfterMethod(){
        driver.quit();
    }

    @Test
    public void test1_SampleLogin() {

        Reporter.log("Executing Test 1");

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

    @Test
    public void test2_ListItems() {

        Reporter.log("Executing Test 2");

        List<WebElement> listItems = testPage.findListOfItems();
        //Assert that there are three values in the listgroup
        assertEquals("There are three values in the list group", EXPECTED_ITEMS_IN_LIST, listItems.size());
        //Assert that the second list item's value is set to "List Item 2"
        assertTrue(listItems.get(1).getText().contains(EXPECTED_SECOND_ITEM_VALUE));
        //Assert that the second list item's badge value is 6
        assertEquals("Badge Value is 6.", EXPECTED_SECOND_ITEM_BADGE_VALUE, testPage.findSecondItemInList().getText());

    }

    @Test
    public void test3_dropDown() {

        Reporter.log("Executing Test 3");

        //Assert that "Option 1" is the default selected value
        assertEquals("Default option is Option 1.", EXPECTED_OPTION1, testPage.findDropDown().getText());
        testPage.findDropDown().click();
        testPage.findOption3().click();
        //Assert that "Option 3" is the selected value
        assertEquals("Selected option is Option 3.", EXPECTED_OPTION3, testPage.findDropDown().getText());

    }

    @Test
    public void test4_EnabledDisabledButton() {

        Reporter.log("Executing Test 4");

        assertEquals("Button 1 is enabled.", true, testPage.findEnabledButton().isEnabled());
        assertEquals("Button 2 is disabled.", false, testPage.findDisabledButton().isEnabled());

    }

    @Test
    public void test5_WaitForButton() {

        Reporter.log("Executing Test 5");

        wait.until(ExpectedConditions.visibilityOfElementLocated(testPage.test5Button)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(testPage.test5Alert));
        String actualAlertMessage = testPage.findTest5Alert().getText();
        assertEquals("Alert message should be same.", EXPECTED_ALERT_MESSAGE, actualAlertMessage);
        assertEquals("Button is disabled now.", false, testPage.findTest5Button().isEnabled());

    }

    @Test (dataProvider = "coordinatesAndValues")
    public void test6_ValueInGrid(int x, int y, String expectedValueOfCell) {

        Reporter.log("Executing Test 6");

        String actualValueOfCell = testPage.findCellValueInTheGrid(x+1,y+1).getText();
        assertEquals("Expected and Actual values of cell match.", expectedValueOfCell, actualValueOfCell);

    }

    //Provides coordinates and expected cell values for test6_ValueInGrid
    @DataProvider(name = "coordinatesAndValues")
    public static Object[][] cellCoordinatesAndExpectedValues() {
        return new Object[][] {{2, 2, "Ventosanzap"}};
    }

}