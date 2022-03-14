package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginpage;
    HomePage homePage;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TaskPage taskPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginpage = new LoginPage();
        contactsPage=new ContactsPage();
        dealsPage=new DealsPage();
        taskPage=new TaskPage();
        homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"Cogmento CRM","Home Page Title is not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameLabelTest()
    {
        Assert.assertTrue(homePage.verifyUserNameLabel());
    }

    @Test(priority = 3)
    public void clickOnContactsTest()
    {
        contactsPage =homePage.clickOnContactsLink();
    }

    @Test(priority = 4)
    public void clickOnDealsPageTest()
    {
       dealsPage= homePage.clickOnDealsLink();
    }

    @Test(priority = 5)
    public void clickOnTasksPageTest()
    {
        taskPage = homePage.clickOnTasksLink();
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
