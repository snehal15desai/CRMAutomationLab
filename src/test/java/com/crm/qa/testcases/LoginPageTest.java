package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{
    LoginPage loginpage;
    HomePage homePage;

    public LoginPageTest()  {
        super();
    }

    @BeforeMethod
    public void setup()  {
        initialization();
        loginpage=new LoginPage();

    }

    @Test(priority =1)
    public void loginPageTitleTest()
    {
        String title=loginpage.validateLoginPageTitle();
        Assert.assertEquals(title,"Cogmento CRM");
    }

   /* @Test(priority = 2)
    public void crmLogoImageTest()
    {
        boolean flag=loginpage.validateCRMLogo();
        Assert.assertTrue(flag);
    }*/


    @Test(priority = 2)
    public void loginTest()
    {
        LoginPage loginpage = new LoginPage();
        homePage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
    }




    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
