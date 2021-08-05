package API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExample {
    static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjcxMDAyMDAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNzE0MzQwMCwidXNlcklkIjoiMjk4NyJ9.nnUarMyisahS3swGSyFde8FgeT50K_MBCujC0AyEQ3E";
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    static String employee_id;

    //@Test
    public void sampleTest() {

        RequestSpecification preparedRequest = given().header("Authorization", token ).header
                ("Content-Type","application/json").queryParam("employee_id", "14496A");
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        //System.out.println(response.asString());
    }
    @Test
    public void aPostCreateEmployee(){
        RequestSpecification preparedRequest = given().header("Authorization",token ).header("Content-Type","application/json").body( "{\n" +
                "  \"emp_firstname\": \"Monia\",\n" +
                "  \"emp_lastname\": \"Jonia\",\n" +
                "  \"emp_middle_name\": \"Shonia\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1990-07-10\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Healer\"\n" +
                "}");

        Response response = preparedRequest.when().post("/createEmployee.php");
        //response.prettyPrint();
        employee_id= response.jsonPath().getString( "Employee.employee_id" );
        //System.out.println(employee_id);

        response.then().assertThat().statusCode( 201 );
        response.then().assertThat().body( "Message",equalTo("Employee Created"));
        response.then().assertThat().body( "Employee.emp_firstname", equalTo( "Monia" ));
        response.then().assertThat().header( "Server", "Apache/2.4.39 (Win64) PHP/7.2.18" );

    }
    @Test
    public void bGetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header( "Authorization", token ).header( "Content_Type", "application/json" ).queryParam( "employee_id", employee_id );
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        String empID = response.jsonPath().getString("employee.employee_id" );
        System.out.println(empID);

        boolean comparingEmpIDs = empID.contentEquals( employee_id );
        Assert.assertTrue( comparingEmpIDs );

        Assert.assertTrue( empID.contentEquals( employee_id ));

        String firstName = response.jsonPath().getString( "employee.emp_firstname" );
        //System.out.println(firstName);
    }

    //@Test
    public void cGetAllEmployees(){
        RequestSpecification preparedRequest = given().header( "Authorization", token ).header( "Content_Type", "application/json" ).queryParam( "employee_id", employee_id );
        Response response = preparedRequest.when().get( "/getAllEmployees.php" );
        String allEmployees = response.prettyPrint();
        JsonPath js =  new JsonPath( allEmployees );
        int count = js.getInt( "Employees.size()");
        //System.out.println(count);

        for (int i=0; i<count; i++){
            String employeeIDs = js.getString( "Employees["+ i +"].employee_id");
            //System.out.println(employeeIDs);
            if (employeeIDs.contentEquals( employee_id )){
                //System.out.println("Employee ID " +employee_id+ " is present in response body");
                String firstName = js.getString( "Employees["+ i +" ].emp_firstname");
                System.out.println(firstName);
                break;
            }
        }
    }
    @Test
    public void dPutUpdateCreatedEmployee(){
        RequestSpecification preparedRequest = given().header( "Authorization", token ).header( "Content_Type", "application/json" ).body( "{\n" +
                "  \"employee_id\": \"" +employee_id+ "\",\n" +
                "  \"emp_firstname\": \"Tupac\",\n" +
                "  \"emp_lastname\": \"Shakur\",\n" +
                "  \"emp_middle_name\": \"Quola\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1990-12-07\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Tester\"\n" +
                "}");
        Response response = preparedRequest.when().put("/updateEmployee.php" );
        response.prettyPrint();

    }
}
