package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //PageFactory - OR(Object Repository)
    @FindBy(name="email")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(xpath ="//div[@class='ui fluid large blue submit button']")
    WebElement submit;

    @FindBy(xpath ="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    //Initializing page objects
    public LoginPage()  {
        PageFactory.initElements(TestBase.driver,this);
    }

    //Actions

    public String validateLoginPageTitle()
    {
        return driver.getTitle();
    }

   /* public boolean validateCRMLogo()
    {
        return crmLogo.isDisplayed();
    }*/

    public HomePage login(String uname, String pwd)
    {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        submit.click();
        return new HomePage();
    }
}
