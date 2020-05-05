package svaykong.com.coder.homework3.controller;

import svaykong.com.coder.homework3.staffmember.HourlyEmployee;
import svaykong.com.coder.homework3.staffmember.SalariedEmployee;
import svaykong.com.coder.homework3.staffmember.StaffMember;
import svaykong.com.coder.homework3.staffmember.Volunteer;

import java.util.*;
import java.util.regex.Pattern;

public class SetupEmployeeController {
    // A- Insert Employee
    // B- Display Employee + Sort
    // C- Update Employee
    // D- Remove Employee

    private static final ArrayList<StaffMember> listStaffMember = new ArrayList<>();

    public static void startApplication() {
        initEmployee();
        displayEmployee(listStaffMember);
        startOperation();
    }

    private static void initEmployee() {

        Volunteer volunteerStaff1 = new Volunteer("Adda Adda","Phnom Penh city, Cambodia");
        listStaffMember.add(volunteerStaff1);
        Volunteer volunteerStaff2 = new Volunteer("Issac Newton","NewYork city, England");
        listStaffMember.add(volunteerStaff2);

        SalariedEmployee salariedEmployeeStaff1 = new SalariedEmployee("Bella Bella","Bangkok city, Thailand", null, null);
        listStaffMember.add(salariedEmployeeStaff1);
        SalariedEmployee salariedEmployeeStaff2 = new SalariedEmployee("Daniel Michael","Berlin city, Germany", 1000.0, 100.0);
        listStaffMember.add(salariedEmployeeStaff2);

        HourlyEmployee hourlyEmployeeStaff1 = new HourlyEmployee("Nancy Momoland","Seoul city, Korea",null,null);
        listStaffMember.add(hourlyEmployeeStaff1);
        HourlyEmployee hourlyEmployeeStaff2 = new HourlyEmployee("Cristian Ronaldo","Porto city, Portugal",8,5000.0);
        listStaffMember.add(hourlyEmployeeStaff2);

    }

    //---------Main function---------
    private static void displayEmployee(ArrayList<StaffMember> listStaffMember) {

        listStaffMember.sort(Comparator.comparing(s -> s.getName().toUpperCase()));

        for(StaffMember list : listStaffMember) {
            displayEmployeeStyle(list);
        }

    }

    private static void insertEmployee(ArrayList<StaffMember> listStaffMember) {
        Scanner scanner = new Scanner(System.in);
        boolean isFinish = false;
        while (isFinish == false) {
            System.out.println("=================Insert New Employee===========");
            System.out.println("1- Volunteer");
            System.out.println("2- SalariedEmployee");
            System.out.println("3- HourlyEmployee");
            System.out.println("4- GoBack");
            System.out.print("=> Choose option(1-4) : ");
            String inputNumber = scanner.nextLine();
            if(isValidInputNumber(inputNumber)) {
                switch (inputNumber){
                    case "1":
                        insertVolunteer();
                        displayEmployee(listStaffMember);
                        isFinish = false;
                        break;
                    case "2":
                        insertSalariedEmployee();
                        displayEmployee(listStaffMember);
                        isFinish = false;
                        break;
                    case "3":
                        insertHourlyEmployee();
                        displayEmployee(listStaffMember);
                        isFinish = false;
                        break;
                    case "4":
                        isFinish = true;
                        displayEmployee(listStaffMember);
                        break;
                    case "0":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    default:
                        System.out.println(inputNumber + ": Invalid option number (1-4)!");
                        break;
                }
            }
            else {
                System.out.println(inputNumber + ": is not valid!");
            }
        }

    }

    private static void updateEmployee(ArrayList<StaffMember> listStaffMember){
        Scanner scanner = new Scanner(System.in);
        boolean isValidNumber = false;
        while (isValidNumber == false) {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            if(isValidInputNumber(id)) {
                isValidNumber = true;
            }
            else {
                isValidNumber = false;
            }
            if(isValidNumber) {
                StaffMember customEmployee = findEmployeeById(Integer.parseInt(id), listStaffMember);
                if(customEmployee == null) {
                    System.out.println("ID: "+ id + " not found!");
                }
                else {
                    displayEmployeeAndUpdateStyle(customEmployee);
                }
            }
            else {
                System.out.println(id + ": is not valid id!");
            }
        }
    }

    private static void deleteEmployee(ArrayList<StaffMember> listStaffMember){
        Scanner scanner = new Scanner(System.in);
        boolean isValidNumber = false;
        while (isValidNumber == false) {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            if(isValidInputNumber(id)) {
                isValidNumber = true;
            }
            else {
                isValidNumber = false;
            }
            if(isValidNumber) {
                StaffMember employeeFound = findEmployeeById(Integer.parseInt(id), listStaffMember);
                if(employeeFound == null) {
                    System.out.println("ID: "+ id + " not found!");
                }
                else {
                    displayEmployeeAndDeleteStyle(employeeFound);
                }
            }
            else {
                System.out.println(id + ": is not valid id!");
            }
        }
    }

    //----------Additional function-------
    private static void startOperation() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============Start Application============");
            System.out.println("1- Insert");
            System.out.println("2- Edit");
            System.out.println("3- Remove");
            System.out.println("4- Exit");
            System.out.print("=> Choose option(1-4) : ");
            String inputNumber = scanner.nextLine();
            if(isValidInputNumber(inputNumber)) {
                switch (inputNumber){
                    case "1":
                        insertEmployee(listStaffMember);
                        break;
                    case "2":
                        updateEmployee(listStaffMember);
                        displayEmployee(listStaffMember);
                        break;
                    case "3":
                        deleteEmployee(listStaffMember);
                        displayEmployee(listStaffMember);
                        break;
                    case "4":
                        System.out.println("☺ GoodBye! 😊");
                        System.exit(0);
                        break;
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    default:
                        System.out.println(inputNumber + ": Choose option number (1-4)!");
                        break;
                }
            }
            else {
                System.out.println(inputNumber + ": is not valid!");
            }
        }
    }

    // insert volunteer staff
    private static void insertVolunteer() {
        // create volunteer object
        Volunteer vol = new Volunteer();

        Scanner volScanner = new Scanner(System.in);
        boolean isValidVolName = false;
        while (isValidVolName == false) {
            System.out.print("Enter staff name: ");
            String volName = volScanner.nextLine();
            if(isValidInputName(volName)) {
                isValidVolName = true;
            }
            else {
                isValidVolName = false;
            }
            if(isValidVolName) {
                vol.setName(capitalize(volName));

                System.out.print("Enter staff address: ");
                vol.setAddress(volScanner.nextLine());
                listStaffMember.add(vol);
                System.out.println("Volunteer staff: "+ capitalize(volName) + " created successfully!");
                System.out.println();
            }
            else {
                System.out.println(volName + ": is not a valid name!");
            }
        }
    }

    // insert salariedEmployee staff
    private static void insertSalariedEmployee() {
        // create salaried employee object
        SalariedEmployee salariedEmp = new SalariedEmployee();

        Scanner salariedEmpScanner = new Scanner(System.in);

        boolean isValidSalariedEmpName = false;
        boolean isValidSalary = false;
        boolean isValidBonus = false;

        while (isValidSalariedEmpName == false) {
            System.out.print("Enter staff name: ");
            String salariedEmpName = salariedEmpScanner.nextLine();
            if(isValidInputName(salariedEmpName)) {
                isValidSalariedEmpName = true;
            }
            else {
                isValidSalariedEmpName = false;
            }
            if(isValidSalariedEmpName) {
                salariedEmp.setName(capitalize(salariedEmpName));
                System.out.print("Enter staff address: ");
                salariedEmp.setAddress(salariedEmpScanner.nextLine());

                while (isValidSalary == false) {
                    System.out.print("Enter staff member salary: ");
                    String inputSalary = salariedEmpScanner.nextLine();
                    if(isValidInputDouble(inputSalary)) {
                        isValidSalary = true;
                    }
                    else {
                        isValidSalary = false;
                    }
                    if(isValidSalary) {
                        salariedEmp.setSalary(Double.parseDouble(inputSalary));
                        while(isValidBonus == false) {
                            System.out.print("Enter staff member bonus: ");
                            String inputBonus = salariedEmpScanner.nextLine();
                            if(isValidInputDouble(inputBonus)) {
                                isValidBonus = true;
                            }
                            else {
                                isValidBonus = false;
                            }
                            if(isValidBonus) {
                                salariedEmp.setBonus(Double.parseDouble(inputBonus));
                                listStaffMember.add(salariedEmp);
                                System.out.println("SalariedEmployee" + capitalize(salariedEmpName) + " create successfully!");
                            }
                            else {
                                System.out.println(inputBonus + ": is not valid bonus!");
                            }
                        }
                    }
                    else {
                        System.out.println(inputSalary + ": is not valid salary!");
                    }
                }
            }
            else {
                System.out.println(salariedEmpName + ": is not a valid name!");
            }
        }

    }

    // insert hourlyEmployee staff
    private static void insertHourlyEmployee() {
        // create salaried employee object
        HourlyEmployee hourlyEmployee = new HourlyEmployee();

        Scanner hourlyEmployeeScanner = new Scanner(System.in);

        boolean isValidHourlyEmpName = false;
        boolean isValidWorkedHour = false;
        boolean isValidRated = false;

        while (isValidHourlyEmpName == false) {
            System.out.print("Enter staff name: ");
            String hourlyEmpName = hourlyEmployeeScanner.nextLine();
            if(isValidInputName(hourlyEmpName)) {
                isValidHourlyEmpName = true;
            }
            else {
                isValidHourlyEmpName = false;
            }
            if(isValidHourlyEmpName) {
                hourlyEmployee.setName(capitalize(hourlyEmpName));
                System.out.print("Enter staff address: ");
                hourlyEmployee.setAddress(hourlyEmployeeScanner.nextLine());

                while (isValidWorkedHour == false) {
                    System.out.print("Enter workedHour: ");
                    String hourlyEmpWorkedHour = hourlyEmployeeScanner.nextLine();
                    if(isValidInputNumber(hourlyEmpWorkedHour)) {
                        isValidWorkedHour = true;
                    }
                    else {
                        isValidWorkedHour = false;
                    }
                    if(isValidWorkedHour) {
                        hourlyEmployee.setHoursWorked(Integer.parseInt(hourlyEmpWorkedHour));
                        while(isValidRated == false) {
                            System.out.print("Enter rate: ");
                            String hourlyEmpRated = hourlyEmployeeScanner.nextLine();
                            if(isValidInputDouble(hourlyEmpRated)) {
                                isValidRated = true;
                            }
                            else {
                                isValidRated = false;
                            }
                            if(isValidRated) {
                                hourlyEmployee.setRate(Double.parseDouble(hourlyEmpRated));
                                listStaffMember.add(hourlyEmployee);
                                System.out.println("SalariedEmployee" + capitalize(hourlyEmpName) + " create successfully!");
                            }
                            else {
                                System.out.println(hourlyEmpRated + ": is not valid rated!");
                            }
                        }
                    }
                    else {
                        System.out.println(hourlyEmpWorkedHour + ": is not valid workedHour!");
                    }
                }
            }
            else {
                System.out.println(hourlyEmpName + ": is not valid name!");
            }

        }

    }

    // make a first letter to capital
    private static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    // checking user input is a valid number
    private static boolean isValidInputNumber(String input) {
        Pattern numberPattern = Pattern.compile("^[1-9]\\d*$");
        if(!numberPattern.matcher(input).matches()) {
            return false;
        }
        else {
            return true;
        }
    }

    // checking user input is a valid name
    private static boolean isValidInputName(String input) {
        Pattern stringPattern = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        if(!stringPattern.matcher(input).matches()) {
            return false;
        }
        else {
            return true;
        }
    }

    // checking user input is a valid double
    private static boolean isValidInputDouble(String input) {
        Pattern doublePattern = Pattern.compile("[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?");
        if(!doublePattern.matcher(input).matches()) {
            return false;
        }
        else {
            return true;
        }
    }

    // finding employee by id then get it object
    private static StaffMember findEmployeeById(Integer id, List<StaffMember> employees) {
        for (StaffMember staffMember : employees) {
            if (staffMember.getId().equals(id)) {
                return staffMember;
            }
        }
        return null;
    }

    // display employee each class object individual
    private static void displayEmployeeStyle(StaffMember customEmployee) {
        if(customEmployee.getClass() == Volunteer.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("Thanks!");
            System.out.println();
        }
        if(customEmployee.getClass() == SalariedEmployee.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("Salary: " + ((SalariedEmployee) customEmployee).getSalary());
            System.out.println("Bonus: " + ((SalariedEmployee) customEmployee).getBonus());
            System.out.println("Payment: " + customEmployee.pay());
            System.out.println();
        }
        if(customEmployee.getClass() == HourlyEmployee.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("HoursWorked: " + ((HourlyEmployee) customEmployee).getHoursWorked());
            System.out.println("Rated: " + ((HourlyEmployee) customEmployee).getRate());
            System.out.println("Payment: " + customEmployee.pay());
            System.out.println();
        }
    }

    // display employee found by its own object class then update it to staff-member arraylist
    private static void displayEmployeeAndUpdateStyle(StaffMember customEmployee) {
        if(customEmployee.getClass() == Volunteer.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("Thanks!");
            System.out.println();
            Scanner volScanner = new Scanner(System.in);
            boolean isValidVolName = false;
            while (isValidVolName == false) {
                System.out.print("Enter name: ");
                String volName = volScanner.nextLine();
                if(isValidInputName(volName)) {
                    isValidVolName = true;
                }
                else {
                    isValidVolName = false;
                }
                if(isValidVolName) {
                    customEmployee.setName(capitalize(volName));
                    System.out.println("Updated Successfully!");
                }
                else {
                    System.out.println(volName + ": is not valid name!");
                }
            }
        }

        if(customEmployee.getClass() == SalariedEmployee.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("Salary: " + ((SalariedEmployee) customEmployee).getSalary());
            System.out.println("Bonus: " + ((SalariedEmployee) customEmployee).getBonus());
            System.out.println("Payment: " + customEmployee.pay());
            System.out.println();

            Scanner salariedEmpScanner = new Scanner(System.in);
            boolean isValidSalariedEmpName = false;
            boolean isValidSalariedEmpSalary = false;
            boolean isValidSalariedEmpBonus = false;

            while (isValidSalariedEmpName == false) {
                System.out.print("Enter name: ");
                String salariedEmpName = salariedEmpScanner.nextLine();
                if(isValidInputName(salariedEmpName)) {
                    isValidSalariedEmpName = true;
                }
                else {
                    isValidSalariedEmpName = false;
                }
                if(isValidSalariedEmpName) {
                    customEmployee.setName(capitalize(salariedEmpName));

                    while (isValidSalariedEmpSalary == false) {
                        System.out.print("Enter salary: ");
                        String salariedEmpSalary = salariedEmpScanner.nextLine();
                        if(isValidInputDouble(salariedEmpSalary)) {
                            isValidSalariedEmpSalary = true;
                        }
                        else {
                            isValidSalariedEmpSalary = false;
                        }
                        if(isValidSalariedEmpSalary) {
                            ((SalariedEmployee) customEmployee).setSalary(Double.parseDouble(salariedEmpSalary));

                            while (isValidSalariedEmpBonus == false) {
                                System.out.print("Enter bonus: ");
                                String salariedEmpBonus = salariedEmpScanner.nextLine();
                                if(isValidInputDouble(salariedEmpBonus)) {
                                    isValidSalariedEmpBonus = true;
                                }
                                else {
                                    isValidSalariedEmpBonus = false;
                                }
                                if(isValidSalariedEmpBonus) {
                                    ((SalariedEmployee) customEmployee).setBonus(Double.parseDouble(salariedEmpBonus));
                                    System.out.println("Updated Successfully!");
                                }
                                else {
                                    System.out.println(salariedEmpBonus + ": is not valid bonus!");
                                }
                            }
                        }
                        else {
                            System.out.println(salariedEmpSalary + ": is not valid salary!");
                        }
                    }
                }
                else {
                    System.out.println(salariedEmpName + ": is not valid name!");
                }
            }
        }

        if(customEmployee.getClass() == HourlyEmployee.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("HoursWorked: " + ((HourlyEmployee) customEmployee).getHoursWorked());
            System.out.println("Rated: " + ((HourlyEmployee) customEmployee).getRate());
            System.out.println("Payment: " + customEmployee.pay());
            System.out.println();

            Scanner hourlyEmpScanner = new Scanner(System.in);
            boolean isValidHourlyEmpName = false;
            boolean isValidHourlyEmpWorkedHour = false;
            boolean isValidHourlyEmpRated = false;

            while (isValidHourlyEmpName == false) {
                System.out.print("Enter name: ");
                String hourlyName = hourlyEmpScanner.nextLine();
                if(isValidInputName(hourlyName)) {
                    isValidHourlyEmpName = true;
                }
                else {
                    isValidHourlyEmpName = false;
                }
                if(isValidHourlyEmpName) {
                    customEmployee.setName(capitalize(hourlyName));

                    while (isValidHourlyEmpWorkedHour == false) {
                        System.out.print("Enter hoursWorked: ");
                        String hourlyWorkedHour = hourlyEmpScanner.nextLine();

                        if(isValidInputNumber(hourlyWorkedHour)) {
                            isValidHourlyEmpWorkedHour = true;
                        }
                        else {
                            isValidHourlyEmpWorkedHour = false;
                        }
                        if(isValidHourlyEmpWorkedHour) {
                            ((HourlyEmployee) customEmployee).setHoursWorked(Integer.parseInt(hourlyWorkedHour));

                            while (isValidHourlyEmpRated == false) {
                                System.out.print("Enter rated: ");
                                String hourlyRated = hourlyEmpScanner.nextLine();
                                if(isValidInputDouble(hourlyRated)) {
                                    isValidHourlyEmpRated = true;
                                }
                                else {
                                    isValidHourlyEmpRated = false;
                                }
                                if(isValidHourlyEmpRated) {
                                    ((HourlyEmployee) customEmployee).setRate(Double.parseDouble(hourlyRated));
                                    System.out.println("Updated Successfully!");
                                }
                                else {
                                    System.out.println(hourlyRated + ": is not valid rated!");
                                }
                            }
                        }
                        else {
                            System.out.println(hourlyWorkedHour + ": is not valid workedHour!");
                        }
                    }

                }
                else {
                    System.out.println(hourlyName + ": is not valid name!");
                }
            }
        }
    }

    // display employee found by its own object class then remove it from staff-member arraylist
    private static void displayEmployeeAndDeleteStyle(StaffMember customEmployee) {
        if(customEmployee.getClass() == Volunteer.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("Thanks!");
            System.out.println();
            listStaffMember.remove(customEmployee);
            System.out.println("Removed Successfully!");
        }
        if(customEmployee.getClass() == SalariedEmployee.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("Salary: " + ((SalariedEmployee) customEmployee).getSalary());
            System.out.println("Bonus: " + ((SalariedEmployee) customEmployee).getBonus());
            System.out.println("Payment: " + customEmployee.pay());
            System.out.println();
            listStaffMember.remove(customEmployee);
            System.out.println();
            System.out.println("Removed Successfully!");
        }
        if(customEmployee.getClass() == HourlyEmployee.class) {
            System.out.println("ID: " + customEmployee.getId());
            System.out.println("Name: " + customEmployee.getName());
            System.out.println("Address: " + customEmployee.getAddress());
            System.out.println("HoursWorked: " + ((HourlyEmployee) customEmployee).getHoursWorked());
            System.out.println("Rated: " + ((HourlyEmployee) customEmployee).getRate());
            System.out.println("Payment: " + customEmployee.pay());
            System.out.println();
            listStaffMember.remove(customEmployee);
            System.out.println();
            System.out.println("Removed Successfully!");
        }
    }

}
