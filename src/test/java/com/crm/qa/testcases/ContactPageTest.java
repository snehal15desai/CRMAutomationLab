package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {
    LoginPage loginpage;
    HomePage homePage;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TaskPage taskPage;

    public ContactPageTest()
    {
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
        contactsPage=homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void contactsPageLabelTest()
    {
        Assert.assertTrue(contactsPage.verifyContactLabel(),"Contact label is missing on the page");
    }

    @Test(priority = 2)
    public void selectContactsTest()
    {
       contactsPage.selectContactName();
    }

    @Test(priority = 3)
    public void createnewContactTest()
    {
        homePage.clickOnNewContactLink();
        contactsPage.createNewContact("Tom","Peter","Lead");
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
