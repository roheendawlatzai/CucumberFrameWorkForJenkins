package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.DbUtils;
import utils.GlobalVariables;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddingJobTitle extends CommonMethods {

    @Then("user clicks on job button and adds new job title")
    public void user_clicks_on_job_button_and_adds_new_job_title() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.adminTab);
        hoverMouse(dash.jobsButton );
        click( dash.addJobsOption );
        click(dash.addJobTitleButton);
        sendText( dash.addJobTitleBox, "LazyBoy" );
        click( dash.btnSave );
    }

    @Then("new job title is added {string} succesfully")
    public void new_job_title_is_added_succesfully(String jobTitle) {
        GlobalVariables.jobTitle=jobTitle;
        String query = "select job_title from `ohrm_job_title` where job_title='LazyBoy';";
        DbUtils.getConnection();
        List<Map<String, String>> jobList= DbUtils.getTableDataAsList(query);
        GlobalVariables.dBjobTitle=jobList.get( 0 ).get( "job_title" );
        System.out.println("BackEnd");
        System.out.println(GlobalVariables.dBjobTitle.toString());
        System.out.println("FrontEnd");
        System.out.println(GlobalVariables.jobTitle);
    }
}
