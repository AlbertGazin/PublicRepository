package week4;

import java.util.ArrayList;
import java.util.Calendar;

public class TaskT04N10 {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        /*dataBase.fillEmployees("Ivanov", "Gavriil", "Ivanovich", "Moscow", 12, 1998);
        dataBase.fillEmployees("Sidorov", "Ivan", "Petrovich", "Lvov", 10, 2009);
        dataBase.fillEmployees("Lapin", "Petr", "Sergeevich", "Minsk", 5, 2018);
        dataBase.fillEmployees("Petrov", "Mikhail", "Kiev", 1, 2019);
        dataBase.fillEmployees("Skomorohov", "Leonid", "Ivanovich", "Kazan", 6, 2007);
        dataBase.fillEmployees("Jukov", "Maxim", "IGOREVICH", "Vladimir", 7, 2017);
        dataBase.fillEmployees("Martynov", "Igor", "Valeryevich", "Praga", 9, 2016);
        dataBase.fillEmployees("Lukashov", "Mikhail", "Berlin", 1, 2020);
        dataBase.fillEmployees("Lopuhov", "Evgeny", "LeONIdoVICH", "S. Peterburg", 4, 1990);
        dataBase.fillEmployees("SIDOROV", "Boris", "PETROVICH", "Ryazan", 8, 2003);
        dataBase.fillEmployees("MOhov", "Sergey", "Sergeevich", "Bryansk", 9, 2006);
        dataBase.fillEmployees("Petrov", "Vladimir", "Kiev", 2, 2017);
        dataBase.fillEmployees("Krushin", "Vladimir", "Gavriilovich", "Riga", 12, 1999);
        dataBase.fillEmployees("GLUKHOV", "IVAN", "MAXIMOVICH", "Lvov", 11, 2004);
        dataBase.fillEmployees("SEMINA", "NATALYA", "SergeevNA", "Minsk", 1, 2011);
        dataBase.fillEmployees("SERGEEVA", "IRINA", "Kiev", 7, 2010);
        dataBase.fillEmployees("IVANENKO", "LYUDMILA", "Moscow", 10, 1997);
        dataBase.fillEmployees("Sidorov", "Ivan", "Petrovich", "Lvov", 10, 2009);
        dataBase.fillEmployees("Lapin", "Petr", "Sergeevich", "Minsk", 5, 2018);
        dataBase.fillEmployees("Petrov", "Mikhail", "Kiev", 1, 2019);*/
        dataBase.fillEmployees("GOLIN", "ALEXEY", "ROME", 2, 2019);
        String nameFragment = "lex";
        ArrayList<Employee> findEmployees = dataBase.findEmployeesByNameFragment(nameFragment);
        System.out.println("Find " + nameFragment + " containing employees :");
        System.out.println();
        for (Employee employee : findEmployees) {
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName()
                    + ", " + employee.getAddress());
        }
        System.out.println();

        System.out.println("Get all employees :");
        ArrayList<Employee> allEmployees = dataBase.getEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName()
                    + ", " + employee.getAddress() + ", " + employee.getHiredMonth() + ", " + employee.getHiredYear()
                    + ", " + employee.getCountOfWorkedYears());
        }

        System.out.println();
        System.out.println("Employees that work more than 3 years :");
        for (Employee employee : dataBase.findEmployeesByWorkedYears(3)) {
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName()
                    + ", " + employee.getAddress());
        }
    }
}

class Employee {
    private final int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH) + 1;
    private final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private int hiredMonth;
    private int hiredYear;

    public Employee(String lastName, String firstName, String middleName, String address, int hiredMonth
            , int hiredYear) {
        this(lastName, firstName, address, hiredMonth, hiredYear);
        setMiddleName(middleName);
    }

    public Employee(String lastName, String firstName, String address, int hiredMonth, int hiredYear) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setHiredMonth(hiredMonth);
        setHiredYear(hiredYear);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHiredMonth() {
        return hiredMonth;
    }

    public void setHiredMonth(int hiredMonth) {
        this.hiredMonth = hiredMonth;
    }

    public int getHiredYear() {
        return hiredYear;
    }

    public void setHiredYear(int hiredYear) {
        this.hiredYear = hiredYear;
    }

    public int getCountOfWorkedYears() {
        if (getHiredYear() >= CURRENT_YEAR) {
            return 0;
        } else {
            if (getHiredMonth() > CURRENT_MONTH) {
                return CURRENT_YEAR - getHiredYear() - 1;
            } else {
                return CURRENT_YEAR - getHiredYear();
            }
        }
    }
}

class DataBase {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void fillEmployees(String lastName, String firstName, String middleName, String address, int hiredMonth
            , int hiredYear) {
        employees.add(new Employee(lastName, firstName, middleName, address, hiredMonth, hiredYear));
    }

    public void fillEmployees(String lastName, String firstName, String address, int hiredMonth, int hiredYear) {
        employees.add(new Employee(lastName, firstName, address, hiredMonth, hiredYear));
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public boolean isMiddleNameExists(Employee employee) {
        return employee.getMiddleName() == null;
    }

    public ArrayList<Employee> findEmployeesByNameFragment(String nameFragment) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : getEmployees()) {
            if (isMiddleNameExists(employee)) {
                if (employee.getFirstName().toUpperCase().contains(nameFragment.toUpperCase())
                        || employee.getLastName().toUpperCase().contains(nameFragment.toUpperCase())) {
                    result.add(employee);
                }
            } else {
                if (employee.getFirstName().toUpperCase().contains(nameFragment.toUpperCase())
                        || employee.getLastName().toUpperCase().contains(nameFragment.toUpperCase())
                        || employee.getMiddleName().toUpperCase().contains(nameFragment.toUpperCase())) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    public ArrayList<Employee> findEmployeesByWorkedYears(int years) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : getEmployees()) {
            if (employee.getCountOfWorkedYears() >= 3) {
                result.add(employee);
            }
        }
        return result;
    }
}