package week4;

import java.util.ArrayList;

import static util.Assert.assertEquals;

public class TaskT04N10Test {
    public static void main(String[] args) {
        testSearchingEmployeeLower();
        testSearchingEmployeeUpper();
        testSearchingIfNoFragment();
        testEmployeesWorkingMoreThanThreeYears();
        testIfNoEmployeeWorkedMoreThanThreeYears();
    }

    public static void testSearchingEmployeeLower() {
        DataBase dataBase = new DataBase();
        dataBase.fillEmployees("GOLIN", "ALEXEY", "ROME", 2, 2010);
        dataBase.fillEmployees("UROV", "IVAN", "RIMOVICH", "BUDVA", 1, 2017);
        dataBase.fillEmployees("alexin", "marat", "moscow", 5, 2009);
        dataBase.fillEmployees("Mol", "Kim", "aLeXeevich", "RiGA", 4, 2000);
        dataBase.fillEmployees("GORIN", "Natan", "Tula", 8, 1992);
        ArrayList<Employee> expected = new ArrayList<>();
        for (Employee employee : dataBase.getEmployees()) {
            if ((employee.getMiddleName() != null && employee.getMiddleName().toUpperCase().contains("LEX")
                    || (employee.getFirstName().toUpperCase().contains("LEX"))
                    || (employee.getLastName().toUpperCase().contains("LEX"))))
                expected.add(employee);
        }
        assertEquals("Week4.TaskT04N10Test.testSearchingEmployeeLower", expected
                , dataBase.findEmployeesByNameFragment("lex"));
    }

    public static void testSearchingEmployeeUpper() {
        DataBase dataBase = new DataBase();
        dataBase.fillEmployees("GOLIN", "ALEXEY", "ROME", 2, 2010);
        dataBase.fillEmployees("UROV", "IVAN", "RIMOVICH", "BUDVA", 1, 2017);
        dataBase.fillEmployees("alexin", "marat", "moscow", 5, 2009);
        dataBase.fillEmployees("Mol", "Kim", "aLeXeevich", "RiGA", 4, 2000);
        dataBase.fillEmployees("GORIN", "Natan", "Tula", 8, 1992);
        ArrayList<Employee> expected = new ArrayList<>();
        for (Employee employee : dataBase.getEmployees()) {
            if ((employee.getMiddleName() != null && employee.getMiddleName().toUpperCase().contains("LEX")
                    || (employee.getFirstName().toUpperCase().contains("LEX"))
                    || (employee.getLastName().toUpperCase().contains("LEX"))))
                expected.add(employee);
        }
        assertEquals("Week4.TaskT04N10Test.testSearchingEmployeeUpper", expected
                , dataBase.findEmployeesByNameFragment("LEX"));
    }

    public static void testSearchingIfNoFragment() {
        DataBase dataBase = new DataBase();
        dataBase.fillEmployees("GOLIN", "ALEXEY", "ROME", 2, 2010);
        dataBase.fillEmployees("UROV", "IVAN", "RIMOVICH", "BUDVA", 1, 2017);
        dataBase.fillEmployees("alexin", "marat", "moscow", 5, 2009);
        dataBase.fillEmployees("Mol", "Kim", "aLeXeevich", "RiGA", 4, 2000);
        dataBase.fillEmployees("GORIN", "Natan", "Tula", 8, 1992);
        ArrayList<Employee> expected = new ArrayList<>();
        assertEquals("Week4.TaskT04N10Test.testSearchingIfNoFragment", expected
                , dataBase.findEmployeesByNameFragment("OCT"));
    }

    public static void testEmployeesWorkingMoreThanThreeYears() {
        DataBase dataBase = new DataBase();
        dataBase.fillEmployees("GOLIN", "ALEXEY", "ROME", 2, 2010);
        dataBase.fillEmployees("UROV", "IVAN", "RIMOVICH", "BUDVA", 1, 2018);
        dataBase.fillEmployees("alexin", "marat", "moscow", 5, 2019);
        dataBase.fillEmployees("Mol", "Kim", "aLeXeevich", "RiGA", 4, 2017);
        dataBase.fillEmployees("GORIN", "Natan", "Tula", 8, 1992);
        ArrayList<Employee> expected = new ArrayList<>();
        for (Employee employee : dataBase.getEmployees()) {
            if (employee.getCountOfWorkedYears() >= 3)
                expected.add(employee);
        }
        assertEquals("Week4.TaskT04N10Test.testEmployeesWorkingMoreThanThreeYears", expected
                , dataBase.findEmployeesByWorkedYears(3));
    }

    public static void testIfNoEmployeeWorkedMoreThanThreeYears() {
        DataBase dataBase = new DataBase();
        dataBase.fillEmployees("GOLIN", "ALEXEY", "ROME", 2, 2019);
        dataBase.fillEmployees("UROV", "IVAN", "RIMOVICH", "BUDVA", 1, 2020);
        dataBase.fillEmployees("alexin", "marat", "moscow", 5, 2019);
        ArrayList<Employee> expected = new ArrayList<>();
        assertEquals("Week4.TaskT04N10Test.testIfNoEmployeeWorkedMoreThanThreeYears", expected
                , dataBase.findEmployeesByWorkedYears(3));
    }
}