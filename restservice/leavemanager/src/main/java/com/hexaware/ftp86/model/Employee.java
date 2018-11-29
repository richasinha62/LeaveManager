package com.hexaware.ftp86.model;

import com.hexaware.ftp86.persistence.DbConnection;
import com.hexaware.ftp86.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * fullName to store employee fullname;
   * emailId to store employee emailid;
   * mobNumber to store employee mobNumber;
   * dateOfJoining to store employee joining date;
   * department to store employee department;
   * availableLeave to store employee leave availability;
   * mgrId to store manager employee id;
   */

  private int empId;
  private String empFullName;
  private String emailId;
  private String mobNumber;
  private Date dateOfJoining;
  private String department;
  private int availableLeave;
  private int mgrId;


  /**
   * empty constructor initialized.
   */
  public Employee() {

  }

  /**
   * @param argempId to set Employee's ID.
   * @param argempFullName to set Employee's fullname.
   * @param argemailId to set Employee's emailid.
   * @param argmobNumber to set Employee's mobnumber.
   * @param argdateOfJoining to set Employee's joining date.
   * @param argdepartment to set Employee's department.
   * @param argavailableLeave to set Employee's availableLeave.
   * @param argmgrId to set Employee's manager id.
   */

  public Employee(final int argempId, final String argempFullName,
          final String argemailId, final String argmobNumber,
          final Date argdateOfJoining, final String argdepartment,
          final int argavailableLeave, final int argmgrId) {
    this.empId = argempId;
    this.empFullName = argempFullName;
    this.emailId = argemailId;
    this.mobNumber = argmobNumber;
    this.dateOfJoining = argdateOfJoining;
    this.department = argdepartment;
    this.availableLeave = argavailableLeave;
    this.mgrId = argmgrId;
  }


  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argempId to set Employee's ID.
   */
  public final void setEmpId(final int argempId) {
    this.empId = argempId;
  }


  /**
   * Gets the EmployeeName.
   * @return this Employee's name.
   */
  public final String getEmpFullName() {
    return empFullName;
  }

  /**
   *
   * @param argempFullName to set employee name.
   */
  public final void setEmpFullName(final String argempFullName) {
    this.empFullName = argempFullName;
  }

  /**
   * Gets the EmployeeEmailId.
   * @return this Employee's EmailID.
   */
  public final String getEmailId() {
    return emailId;
  }

  /**
   *
   * @param argemailId to set employee emailId.
   */
  public final void setEmailId(final String argemailId) {
    this.emailId = argemailId;
  }

  /**
   * Gets the EmployeeMobileNumber.
   * @return this Employee's Number.
   */
  public final String getMobNumber() {
    return mobNumber;
  }

  /**
   *
   * @param argmobNumber to set employee mobile number.
   */
  public final void setMobNumber(final String argmobNumber) {
    this.mobNumber = argmobNumber;
  }


  /**
   * Gets the EmployeedateOfJoining.
   * @return this Employee's dateOfJoiningt.
   */
  public final Date getDateOfJoining() {
    return dateOfJoining;
  }

  /**
   *
   * @param argdateOfJoining to set employee mobile dateOfJoining.
   */
  public final void setDateOfJoining(final Date argdateOfJoining) {
    this.dateOfJoining = argdateOfJoining;
  }

  /**
   * Gets the EmployeeDepartment.
   * @return this Employee's department.
   */
  public final String getDepartment() {
    return department;
  }

  /**
   *
   * @param argdepartment to set employee mobile department.
   */
  public final void setDepartment(final String argdepartment) {
    this.department = argdepartment;
  }


  /**
   * Gets the EmployeeavailableLeave.
   * @return this Employee's availableLeave.
   */
  public final int getAvailableLeave() {
    return availableLeave;
  }

  /**
   *
   * @param argavailableLeave to set employee availableLeave.
   */
  public final void setAvailableLeave(final int argavailableLeave) {
    this.availableLeave = argavailableLeave;
  }



 /**
  * Gets the ManagerId.
  * @return this Employee's ManagerId.
  */
  public final int getMgrId() {
    return mgrId;
  }

  /**
   *
   * @param argMgrId to set employee ManagerId.
   */
  public final void setMgrId(final int argMgrId) {
    this.mgrId = argMgrId;
  }





  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empFullName, emp.empFullName)
        && Objects.equals(emailId, emp.emailId)
        && Objects.equals(mobNumber, emp.mobNumber)
        && Objects.equals(dateOfJoining, emp.dateOfJoining)
        && Objects.equals(department, emp.department)
        && Objects.equals(availableLeave, emp.availableLeave)
        && Objects.equals(mgrId, emp.mgrId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empFullName, emailId, mobNumber, dateOfJoining, department, availableLeave, mgrId);
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }


  /**
   * Update employee LeaveBalance.
   * @param empid id to get employee id.
   * @param leavendays to get employee leavenoofdays.
   * @return String.
   */
  public static String increment(final int empid, final int leavendays) {
    dao().increment(empid, leavendays);
    return "Leave Balance Updated";
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }


  /**
   * Update leaveBalance of employee.
   * @param empID id to enter employee details.
   * @param leaveTaken  to enter employee Leavetaken.
   * @return Status
   */

  public static String decrement(final int empID, final int leaveTaken) {
    dao().decrement(empID, leaveTaken);
    return "Leave Balance Updated";
  }
}
