package com.hexaware.ftp86.integration.test;
// import  com.hexaware.ftp86.model;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp86");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
   
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

    
  public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }

}


/**
 * leavedetails class to store employee personal details.
 * @author hexware
 */
class LeaveDetails {

  /**
   * leaveid to store leave id.
   */
  private int leaveId;
  /**
   * empid to store employee id.
   */
  private int empId;
  /**
   * leavesdate to store leave Start date.
   */
  private Date leaveSdate;
  /**
   * LEAVE_EDATE to store leave End date.
   */
  private Date leaveEdate;
  /**
   * leavendays to store leave no of days.
   */
  private int leaveNdays;
  /**
   * leavetype to store  leave type.
   */
  private LeaveType leaveType;
  /**
   * leavestatus to store  leave status.
   */
  private LeaveStatus leaveStatus;
  /**
   * leavereason to store leave reason.
   */
  private String leaveReason;
  /**
   * leaveappliedon to store leave appliedon.
   */
  private Date leaveAppliedOn;
  /**
   * leavemanagercomm to store  manager comments.
   */
  private String leaveManagerComm;

  /**
   * empty constructor initialized.
   */
  public LeaveDetails() {

  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, empId, leaveSdate, leaveEdate, leaveNdays, leaveType, leaveStatus,
    leaveReason, leaveAppliedOn, leaveManagerComm);
  }

  /**
   * @param argLeaveId to initialize Leavedetails id.
   * @param argEmpId to initialize employee id.
   * @param argLeaveSdate to initialize Leavedetails start date.
   * @param argLeaveEdate to initialize Leavedetails end date.
   * @param argLeaveNdays to initialize Leavedetails no of days.
   * @param argLeaveType to initialize Leavedetails type.
   * @param argLeaveStatus to initialize Leave status.
   * @param argLeaveReason to initialize Leave reason.
   * @param argLeaveAppliedOn to initialize leave applied on.
   * @param argLeaveManagerComm to initialize leave manager comments.
   */

  public LeaveDetails(final int argLeaveId, final int argEmpId, final Date argLeaveSdate, final Date argLeaveEdate,
      final int argLeaveNdays, final LeaveType argLeaveType, final LeaveStatus argLeaveStatus,
      final String argLeaveReason, final Date argLeaveAppliedOn, final String argLeaveManagerComm) {
    this.leaveId = argLeaveId;
    this.empId = argEmpId;
    this.leaveSdate = argLeaveSdate;
    this.leaveEdate = argLeaveEdate;
    this.leaveNdays = argLeaveNdays;
    this.leaveType = argLeaveType;
    this.leaveStatus = argLeaveStatus;
    this.leaveReason = argLeaveReason;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.leaveManagerComm = argLeaveManagerComm;
  }

  /**
   * Gets the leave id.
   * @return this Employee's leave ID.
   */
  public final int getLeaveId() {
    return leaveId;
  }

  /**
   *
   * @param argLeaveId to set leave id.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   *
   * @param argEmpId to set employee Name.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * Gets the Leave start date.
   * @return this Leave start date.
   */
  public final Date getLeaveSdate() {
    return leaveSdate;
  }

  /**
   *
   * @param argLeaveSdate to set Leave start date.
   */
  public final void setLeaveSdate(final Date argLeaveSdate) {
    this.leaveSdate = argLeaveSdate;
  }
   /**
   * Gets the EmployeeEmail.
   * @return this Employee's email.
   */
  public final Date getLeaveEdate() {
    return leaveEdate;
  }

  /**
   *
   * @param argLeaveEdate to set employee id.
   */
  public final void setLeaveEdate(final Date argLeaveEdate) {
    this.leaveEdate = argLeaveEdate;
  }
   /**
   * Gets the EmployeeMob.
   * @return this Employee's Mob.
   */
  public final int getLeaveNdays() {
    return leaveNdays;
  }

  /**
   *
   * @param argLeaveNdays to set employee Mob.
   */
  public final void setLeaveNdays(final int argLeaveNdays) {
    this.leaveNdays = argLeaveNdays;
  }
   /**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }

  /**
   *
   * @param argLeaveType to set employee Doj.
   */
  public final void setLeaveType(final LeaveType argLeaveType) {
    this.leaveType = argLeaveType;
  }
   /**
   * Gets the EmployeeLeavbal.
   * @return this Employee's Leavbal.
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }

  /**
   *
   * @param argLeaveStatus to set employee Leavbal.
   */
  public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }
   /**
   * Gets the EmployeeMgrid.
   * @return this Employee's Mgrid.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }

  /**
   *
   * @param argLeaveReason to set employee Mgrid.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }
    /**
   * Gets the EmployeeMgrid.
   * @return this Employee's Mgrid.
   */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }

  /**
   *
   * @param argLeaveAppliedOn to set employee Mgrid.
   */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }
    /**
   * Gets the EmployeeMgrid.
   * @return this Employee's Mgrid.
   */
  public final String getLeaveManagerComm() {
    return leaveManagerComm;
  }

  /**
   *
   * @param argLeaveManagerComm to set employee Mgrid.
   */
  public final void setLeaveManagerComm(final String argLeaveManagerComm) {
    this.leaveManagerComm = argLeaveManagerComm;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ld = (LeaveDetails) obj;
    if (Objects.equals(leaveId, ld.leaveId)
        && Objects.equals(empId, ld.empId)
        && Objects.equals(leaveSdate, ld.leaveSdate)
        && Objects.equals(leaveEdate, ld.leaveEdate)
        && Objects.equals(leaveNdays, ld.leaveNdays)
        && Objects.equals(leaveType, ld.leaveType)
        && Objects.equals(leaveStatus, ld.leaveStatus)
        && Objects.equals(leaveReason, ld.leaveReason)
        && Objects.equals(leaveAppliedOn, ld.leaveAppliedOn)
        && Objects.equals(leaveManagerComm, ld.leaveManagerComm)) {
      return true;
    }
    return false;
  }
}

enum LeaveStatus {
    /**
     * PENDING for pending.
    */
    PENDING,
    /**
     * APPROVED for Approved.
    */
    APPROVED,
    /**
     * DENIED for Denied.
    */
    REJECTED
}

enum LeaveType {
    /**
     * EARNED for EL.
    */
    EL,

    /**
     * EARNED for SL.
    */
    SL,
    /**
     * EARNED for ML.
    */
    ML
}
