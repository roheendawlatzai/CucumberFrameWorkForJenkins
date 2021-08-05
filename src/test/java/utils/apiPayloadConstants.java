package utils;

import org.json.JSONObject;


public class apiPayloadConstants {

    public static String createEmployeePayload() {

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Accesss\",\n" +
                "  \"emp_lastname\": \"Control\",\n" +
                "  \"emp_middle_name\": \"Allow\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1990-07-10\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Healer\"\n" +
                "}";

        return createEmployeePayload;
    }

    /*
     * Second way to send payload/body using JSONObject
     */
//    public static String createEmployeeBody() {
//        /*
//         *
//         * We imported a dependency for JSONObject
//         */
//
//        JSONObject obj = new JSONObject();
//        obj.put("emp_firstname", "Syntax");
//        obj.put("emp_lastname", "API");
//        obj.put("emp_middle_name", "Instructor");
//        obj.put("emp_gender", "F");
//        obj.put("emp_birthday", "1990-07-10");
//        obj.put("emp_status", "Employee");
//        obj.put("emp_job_title", "Healer");
//
//        return obj.toString();
//    }
//
//    public static String createEmployeeBodyMoreDynamic(String firstName, String lastName, String middleName,
//                                                       String gender, String employeeBday, String employeeStatus, String employeeJobTitle){
//
//        JSONObject obj = new JSONObject();
//        obj.put("emp_firstname", firstName);
//        obj.put("emp_lastname", lastName);
//        obj.put("emp_middle_name", middleName);
//        obj.put("emp_gender", gender);
//        obj.put("emp_birthday", employeeBday);
//        obj.put("emp_status", employeeStatus);
//        obj.put("emp_job_title", employeeJobTitle);
//
//        return obj.toString();
//    }

}