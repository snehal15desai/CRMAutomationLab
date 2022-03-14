import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginLink;
import com.crm.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLinkTest extends TestBase {
    LoginPage loginPage=new LoginPage();
    LoginLink link = new LoginLink();
    public LoginLinkTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()  {
        initialization();
    }

    @Test
    public void ClickLoginTest()
    {
        loginPage = link.ClickLogin();

    }

    @AfterMethod
    public  void tearDown()
    {
        driver.quit();
    }

}
