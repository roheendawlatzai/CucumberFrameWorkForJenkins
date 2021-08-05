package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashBoardPage extends CommonMethods {

    @FindBy(id = "welcome")
    public WebElement welcomemessage;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOPtion;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(xpath="//div[@class='menu']/ul/li")
    public List<WebElement> dashboardtabs;

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminTab;

    @FindBy(id = "menu_admin_Job")
    public WebElement jobsButton;

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement addJobsOption;

    @FindBy(id = "btnAdd")
    public WebElement addJobTitleButton;

    @FindBy(id = "jobTitle_jobTitle")
    public WebElement addJobTitleBox;

    @FindBy(id = "btnSave")
    public WebElement btnSave;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]")
    public List<WebElement> jobTitleList;














    

    public DashBoardPage(){
        PageFactory.initElements(driver, this);
    }

}
