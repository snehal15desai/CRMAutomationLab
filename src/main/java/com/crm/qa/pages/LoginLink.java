package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLink extends TestBase {
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginLink;


    //Initializing page objects
    public LoginLink() {
        PageFactory.initElements(TestBase.driver, this);
    }

    //Actions
    public LoginPage ClickLogin(){
        loginLink.click();
        return new LoginPage();
    }
}
