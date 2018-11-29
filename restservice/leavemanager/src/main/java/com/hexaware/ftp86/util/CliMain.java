package com.hexaware.ftp86.util;
import java.util.Scanner;
import java.text.ParseException;
import com.hexaware.ftp86.model.LeaveDetails;
import com.hexaware.ftp86.model.Employee;
import java.text.SimpleDateFormat;
/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Employee Leave History");
    System.out.println("5. Pending Leave Status");
    System.out.println("6. Approve / Deny");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistory();
        break;
      case 5:
        pendingLeaves();
        break;
      case 6:
        approveDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }
  private void pendingLeaves() {
    int mgrId;
    System.out.println("Enter Employ Id");
    mgrId = Integer.parseInt(option.next());
    LeaveDetails[] pending = LeaveDetails.listPending(mgrId);
    for (LeaveDetails e : pending) {
      System.out.println(e.getLeaveId() + " " + e.getEmpId() + " "
          + e.getLeaveSdate() + " " + e.getLeaveEdate() + " " + e.getLeaveNdays() + " "
          + e.getLeaveType() + " " + e.getLeaveStatus() + " " + e.getLeaveReason()
          + e.getLeaveAppliedOn() + " " + e.getLeaveManagerComm());
    }
  }


  /**
  * For Approval and Denial.
  */
  public static void approveDeny() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a leave ID:");
    int leaveId = sc.nextInt();
    System.out.println("Enter Employ Id  ");
    int mgrId = sc.nextInt();
    System.out.println("Decide what you want to do (APPROVE / DENY): ");
    String ch = sc.next();
    System.out.println("Manager Comments  ");
    sc.nextLine();
    String mgrCom = sc.nextLine();
    String res = LeaveDetails.approveDeny(leaveId, mgrId, ch, mgrCom);
    System.out.println(res);
  }

  private void applyLeave() {
    int empid = 0;
    while (true) {
      System.out.println("Enter an Employee Id");
      String empId = option.next();
      try {
        empid = Integer.parseInt(empId);
        Employee.listById(empid).getEmpId();
        break;
      } catch (NumberFormatException nfe) {
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("-----Please enter correct employee id------");
        System.out.println("-------------------------------------------");
      } catch (NullPointerException e) {
        System.out.println();
        System.out.println("--------------No Such Employee---------------");
        System.out.println("---------------------------------------------");
        System.out.println("-----Please enter correct employee id--------");
        System.out.println("---------------------------------------------");
      }
    }
    System.out.println();
    System.out.println("Your available leave balance is: " + Employee.listById(empid).getAvailableLeave());
    String endDate = null;
    String startDate = null;
    while (true) {
      try {
        System.out.println("Enter Start Date of your leave (yyyy-MM-dd): ");
        startDate = option.next();
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
        sdfrmt.setLenient(false);
        sdfrmt.parse(startDate);
        System.out.println("Enter End Date of your leave (yyyy-MM-dd): ");
        endDate = option.next();
        SimpleDateFormat sdfrm = new SimpleDateFormat("yyyy-MM-dd");
        sdfrm.setLenient(false);
        sdfrm.parse(endDate);
        break;
      } catch (ParseException ex) {
        System.out.println("------------------------------");
        System.out.println("Please enter in correct date/format.");
        System.out.println("------------------------------");
      }
    }
    System.out.println("Enter the number of days you want leave for: ");
    int noOfdays = option.nextInt();
    System.out.println("Enter the type of leave you want. (EL / SL / ML): ");
    String leaveType = option.next();
    System.out.println("Please mention the reason for taking leave: ");
    String leaveReason = option.next();
    String res = null;
    try {
      res = LeaveDetails.applyLeave(empid, startDate,
                    endDate, noOfdays, leaveType.toUpperCase(),
                    leaveReason
      );
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(res);
  }

  private void listEmployeeDetail() {
    int empid = 0;
    while (true) {
      try {
        System.out.println("Enter an Employee Id");
        String empId = option.next();
        empid = Integer.parseInt(empId);
        Employee employee = Employee.listById(empid);
        System.out.println(employee.getEmpId() + " " + employee.getEmpFullName() + " "
              + employee.getEmailId() + " " + employee.getMobNumber() + " " + employee.getDateOfJoining() + " "
              + employee.getDepartment() + " " + employee.getAvailableLeave() + " " + employee.getMgrId());
        break;
      } catch (NumberFormatException nfe) {
        System.out.println("-------------------------------------------");
        System.out.println("-----please enter correct employee id------");
        System.out.println("-------------------------------------------");
      } catch (NullPointerException e) {
        System.out.println();
        System.out.println("--------------No Such Employee---------------");
        System.out.println("---------------------------------------------");
        System.out.println("-----please enter correct employee id--------");
        System.out.println("---------------------------------------------");
      }
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + " " + e.getEmpFullName() + " "
          + e.getEmailId() + " " + e.getMobNumber() + " " + e.getDateOfJoining() + " "
          + e.getDepartment() + " " + e.getAvailableLeave() + " " + e.getMgrId());
    }
  }

  private void leaveHistory() {
    int empid = 0;
    while (true) {
      System.out.println("Enter an Employee Id");
      String empId = option.next();
      try {
        empid = Integer.parseInt(empId);
        Employee.listById(empid);
        LeaveDetails[] leaves = LeaveDetails.leaveHis(empid);
        if (leaves.length == 0) {
          System.out.println("Sorry, No such employee History..");
        } else {
          System.out.println();
          for (LeaveDetails e : leaves) {
            System.out.println(e.getLeaveId() + " | " + e.getEmpId() + " | "
                + e.getLeaveSdate() + " | " + e.getLeaveEdate() + " | " + e.getLeaveNdays() + " | "
                + e.getLeaveType() + " | " + e.getLeaveStatus() + " | " + e.getLeaveReason()
                + e.getLeaveAppliedOn() + " | " + e.getLeaveManagerComm());
          }
        }
        break;
      } catch (NumberFormatException nfe) {
        System.out.println("-------------------------------------------");
        System.out.println("-----please enter correct employee id------");
        System.out.println("-------------------------------------------");
        listEmployeeDetail();
      } catch (NullPointerException e) {
        System.out.println();
        System.out.println("--------------No Such Employee---------------");
        System.out.println("---------------------------------------------");
        System.out.println("-----please enter correct employee id--------");
        System.out.println("---------------------------------------------");
        listEmployeeDetail();
      }
    }
  }
  /**
   * The main entry point.
   * @throws ParseException throws Parse Exception
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
