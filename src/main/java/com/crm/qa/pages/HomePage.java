package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//span[contains(text(),'Snehal Desai')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement newcontactLink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasksLink;

    //Initializing the Page Objects
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle()
    {
        return driver.getTitle();
    }

    public boolean verifyUserNameLabel()
    {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink()
    {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink()
    {
        dealsLink.click();
        return new DealsPage();
    }

    public TaskPage clickOnTasksLink()
    {
        tasksLink.click();
        return new TaskPage();
    }

    public void clickOnNewContactLink()
    {
        Actions action=new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newcontactLink.click();

    }
}
