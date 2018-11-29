package com.hexaware.ftp86.persistence;

import com.hexaware.ftp86.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for leavedetails.
 */
public interface LeaveDetailsDAO {
  /**
   * return all the details of all the Leavedetails.
   * @return the Leavedetails array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the details of the selected Leavedetails.
   * @param leaveid the id of the Leavedetails
   * @return the Leavedetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID = :leaveid")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails find(@Bind("leaveid") int leaveid);

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee.
   * @param startDate leaveStartDate of employee.
   * @param endDate leaveEndDate of employee.
   * @return the total record count.
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS "
      +    " WHERE EMP_ID= :empID AND (START_DATE BETWEEN :startDate AND :endDate "
      +    " OR END_DATE BETWEEN :startDate AND :endDate)"
      )
  int count(@Bind("empID") int empID, @Bind("startDate") String startDate,
      @Bind("endDate") String endDate);

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> empHistory(@Bind("empID") int empID);

  /**
   * return Manager the details of the Leave Id.
   * @param leaveID the id of the employee
   * @return the ManagerID value
   */

  @SqlQuery("SELECT E1.EMP_ID FROM EMP_DETAILS E1  "
      + " JOIN EMP_DETAILS E2 ON E1.Emp_ID=E2.MGR_ID WHERE E2.EMP_ID =(SELECT EMP_ID FROM LEAVE_DETAILS "
      + "   WHERE LEAVE_ID=:leaveID)")
   int showManager(@Bind("leaveID") int leaveID);


  /**
   * return all the details of the selected Leavedetails.
   * @param empid the id of the Leavedetails
   * @return the Leavedetails object
   */

  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE "
      + " EMP_ID IN "
      + " (SELECT E2.EMP_ID FROM "
      + " EMP_DETAILS E1 INNER JOIN "
      + " EMP_DETAILS E2 ON E1.EMP_ID = E2.MGR_ID "
      + " WHERE E1.EMP_ID = :empid)  AND "
      + " LEAVE_STATUS ='PENDING' ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> pending(@Bind("empid") int empid);


  /**
   * @param leavemanagercomm Updated Manager Response data.
   * @param leavestatus Updated Manager Status data.
   * @param leaveid the id of the LeaveDetails
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET COMMENTS = :leavemanagercomm, LEAVE_STATUS = :leavestatus WHERE "
      + "LEAVE_ID = :leaveid")
  void comment(@Bind("leavemanagercomm") String leavemanagercomm, @Bind("leavestatus") String leavestatus,
      @Bind("leaveid") int leaveid);


  /**
 * insert all the details of the employee leave.
 * @param empId the employee id of the employee.
 * @param sDate the start date of the employee.
 * @param eDate the end date of the employee.
 * @param days the number of days of the employee.
 * @param ltype the leaveType details of employee.
 * @param lstatus the LeaveStatus details of employee.
 * @param reason the reason for applying.
 * @param appliedDate the applied date of the employee.
 */
  @SqlUpdate("insert into LEAVE_DETAILS  "
      +
      "             (EMP_ID, "
      +
      "              START_DATE, "
      +
      "              END_DATE, "
      +
      "              NO_OF_DAYS, "
      +
      "              LEAVE_TYPE, "
      +
      "              LEAVE_STATUS, "
      +
      "              LEAVE_REASON, "
      +
      "              APPLIED_ON) "
      +
      "values       ( "
      +
      "              :empId, "
      +
      "              :startDate, "
      +
      "              :endDate, "
      +
      "              :nodays, "
      +
      "              :leavetype, "
      +
      "              :leavestatus, "
      +
      "              :leavereason, "
      +
      "              :appliedOn)")

void apply(@Bind("empId") int empId,
       @Bind("startDate") String sDate,
       @Bind("endDate") String eDate,
       @Bind("nodays") int days,
       @Bind("leavetype") String ltype,
       @Bind("leavestatus") String lstatus,
       @Bind("leavereason") String reason,
       @Bind("appliedOn") String appliedDate);

  /**
  * close with no args is used to close the connection.
  */
  void close();

}
