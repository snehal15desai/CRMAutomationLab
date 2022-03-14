package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Signupage extends TestBase{
      @FindBy(name="email")
        WebElement email;
      @FindBy(name="password")
        WebElement password;

      @FindBy(xpath ="//div[@class='ui fluid large blue submit button']")
        WebElement login;


    public Signupage() throws IOException {
    }
}


