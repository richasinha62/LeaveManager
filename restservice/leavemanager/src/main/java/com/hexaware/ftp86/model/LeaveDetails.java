package com.hexaware.ftp86.model;

import com.hexaware.ftp86.persistence.DbConnection;
import com.hexaware.ftp86.persistence.LeaveDetailsDAO;
import com.hexaware.ftp86.persistence.EmployeeDAO;
import java.util.Date;
import java.util.Objects;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * leavedetails class to store employee personal details.
 * @author hexware
 */
public class LeaveDetails {

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

  /**
   * Default constructor.
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

  /**
   * The dao for LeaveDetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * The dao for EmployeeDetails.
   */
  private static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  /**
   * list all employee details.
   * @return all employees' details
   */
  public static LeaveDetails[] listAll() {

    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }

/**
   * list all employee leave details.
   * @param mgrId id to get employee leave Details.
   * @return all employee leave details
   */
  public static LeaveDetails[] listPending(final int mgrId) {

    List<LeaveDetails> e = dao().pending(mgrId);
    return e.toArray(new LeaveDetails[e.size()]);
  }

  /**
   * list employee details by id.
   * @param leaveId id to get employee details.
   * @return Employee
   */
  public static LeaveDetails listById(final int leaveId) {
    return dao().find(leaveId);
  }

 /**
   * list employee details by id.
   * @param empId id to get employee details.
   * @return Employee
   */
  public static LeaveDetails[] leaveHis(final int empId) {
    List<LeaveDetails> es = dao().empHistory(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
  * returns ManagerId for. LeaveId value
  * @param leaveId id to get employee manager details.
  * @return int.
  */
  public static int showManager(final int leaveId) {
    return dao().showManager(leaveId);
  }

  /**
   * NO of overlapping Leaves.
   * @param empId id to get employee details.
   * @param startDate id to get employee details.
   * @param endDate id to get employee details.
   * @return count of no of employee.
   */
  public static int countNo(final int empId, final String startDate, final String endDate) {
    int count = dao().count(empId, startDate, endDate);
    return count;
  }

// /**
//    * Method for Approve or Deny the Leave.
//    * @param leaveId to enter LeaveId to approve/deny.
//    * @param empId to enter empId to approve/deny.
//    * @param lstatus to enter status to approve/deny.
//    * @param mgrcomments to get manager comments.
//    * @throws NullPointerException This will throw the Exception.
//    * @return String.
//    */

  // public static String approveDeny(final int leaveId, final int empId,
  //final String lstatus, final String mgrcomments)
  //                                 throws NullPointerException {
  //   LeaveDetails ld = LeaveDetails.listById(leaveId);
  //   int noOfDays = ld.getleavendays();
  //   int emplId = ld.getempid();
  //   int empdId = LeaveDetails.showManager(leaveId);
  //   String res = null;
  //   String dbStatus = null;
  //   if (empId != empdId) {
  //     res = "You are not authorised to access this employee.";
  //     return res;
  //   }
  //   if (lstatus.equals("YES") || lstatus.equals("yes")) {
  //     dbStatus = "APPROVED";
  //     res = "Leave Approved Successfully";
  //   } else {
  //     dbStatus = "REJECTED";
  //     edao().increment(emplId, noOfDays);
  //     res = "Leave Rejected";
  //   }
  //   dao().comment(mgrcomments, dbStatus, leaveId);
  //   return res;
  // }


/**
   * Method for Approve or Deny the Leave.
   * @param leaveId to enter LeaveId to approve/deny.
   * @param empId to enter empId to approve/deny.
   * @param lStatus to enter status to approve/deny.
   * @param mgrComments to get manager comments.
   * @return String.
   */

  public static String approveDeny(final int leaveId, final int empId, final String lStatus, final String mgrComments) {
    LeaveDetails ld = LeaveDetails.listById(leaveId);
    String res = null;
    if (ld != null) {
      int noOfDays = ld.getLeaveNdays();
      int emplId = ld.getEmpId();
      int empdId = LeaveDetails.showManager(leaveId);
      String dbStatus = null;
      System.out.println(lStatus);
      System.out.println(ld.getLeaveStatus());
      if (empId != empdId) {
        res = "You are not authorised to access this employee.";
        return res;
      }
      if (lStatus.equals("APPROVE") && ld.getLeaveStatus().equals(LeaveStatus.PENDING)) {
        dbStatus = "APPROVED";
        dao().comment(mgrComments, dbStatus, leaveId);
        res = "Leave Approved Successfully";
      } else if (lStatus.equals("DENY") && ld.getLeaveStatus().equals(LeaveStatus.APPROVED)) {
        dbStatus = "REJECTED";
        edao().increment(emplId, noOfDays);
        dao().comment(mgrComments, dbStatus, leaveId);
        res = "Leave Rejected";
      } else if (lStatus.equals("APPROVE") && ld.getLeaveStatus().equals(LeaveStatus.REJECTED)) {
        dbStatus = "APPROVED";
        edao().decrement(emplId, noOfDays);
        dao().comment(mgrComments, dbStatus, leaveId);
        res = "Leave Approved Successfully";
      } else {
        if (lStatus.equals("DENY") && ld.getLeaveStatus().equals(LeaveStatus.PENDING)) {
          dbStatus = "REJECTED";
          edao().increment(emplId, noOfDays);
          dao().comment(mgrComments, dbStatus, leaveId);
          res = "Leave Rejected";
        } else {
          res = "Already on given status";
        }
      }
    } else {
      res = "Invalid LeaveId";
    }
    return res;
  }

/**
   * Applyy Leave for employee.
   * @param empId id to set employee id.
   * @param startDate id to set employee startDate.
   * @param endDate id to set employee endDate.
   * @param noOfdays id to set employee noOfdays.
   * @param leaveType id to set employee leaveType.
   * @param leaveReason id to set employee leaveReason.
   * @throws ParseException throws Parse Exception
   * @return String
   */
  public static String applyLeave(final int empId,
                                  final String startDate,
                                  final String endDate,
                                  final int noOfdays,
                                  final String leaveType,
                                  final String leaveReason
  ) throws ParseException {
    String s = null;
    Employee emplo = Employee.listById(empId);
    if (emplo != null) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date stDate = sdf.parse(startDate);
      Date enDate = sdf.parse(endDate);
      Calendar start = Calendar.getInstance();
      start.setTime(stDate);
      Calendar end = Calendar.getInstance();
      end.setTime(enDate);
      int count = 0;
      for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
          count++;
        }
      }
      System.out.println(count);
      long diff = enDate.getTime() - stDate.getTime();
      System.out.println(diff);
      long days = diff / (1000 * 60 * 60 * 24);
      Date today = new Date();
      String appliedOn = sdf.format(today);
      days = days + 1;
      long availBal = 0;
      long dif = 0;
      long updLeave = 0;
      String leaveStatus = null;
      int overlap = LeaveDetails.countNo(empId, startDate, endDate);
      availBal = emplo.getAvailableLeave();
      dif = availBal - days;
      updLeave = days - count;
      if (days <= 0) {
        s = "Start Date Must be Greater than EndDate...";
      } else if (dif < 0) {
        s = "insufficient leav balance";
      } else if (noOfdays != days) {
        s = "NO Of Days Should be right";
      } else if (stDate.compareTo(sdf.parse(appliedOn)) < 0) {
        s = "Start should be greater or equal to current date";
      } else if (overlap > 0) {
        s = "already applied on given date";
      } else {
        if (emplo.getMgrId() == 0) {
          leaveStatus = "APPROVED";
          dao().apply(empId, startDate, endDate, noOfdays,
              leaveType, leaveStatus, leaveReason, appliedOn);
          s = "Leave Applied Successfully...";
        } else {
          leaveStatus = "PENDING";
          dao().apply(empId, startDate, endDate, noOfdays,
              leaveType, leaveStatus, leaveReason, appliedOn);
          int bal = (int) updLeave;
          edao().decrement(empId, bal);
          s = "Leave Applied Successfully For "  + (days - count) + " Days.";
        }
      }
    } else {
      s = "invalid employee";
    }
    return s;
  }
}
