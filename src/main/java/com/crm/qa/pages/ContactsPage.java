package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
    WebElement contactLabel;

    @FindBy(name="first_name")
    WebElement firstName;

    @FindBy(name="last_name")
    WebElement lasttName;

    @FindBy(name="category")
    WebElement cat;

    @FindBy(xpath ="//button[normalize-space()='Save']")
    WebElement save;

    //Initializing the Page Objects
    public ContactsPage()
    {
        PageFactory.initElements(driver,this);
    }


    public boolean verifyContactLabel()
    {
        return contactLabel.isDisplayed();
    }

    public void selectContactName()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Snehal Desai')]")).click();
    }

    public void createNewContact(String fname,String lname,String category)
    {
        firstName.sendKeys(fname);
        lasttName.sendKeys(lname);
        Select select = new Select(cat);
        select.selectByVisibleText(category);
        save.click();
    }


}
