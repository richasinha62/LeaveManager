package com.hexaware.ftp86.util;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.ws.rs.core.MediaType;
import com.hexaware.ftp86.model.LeaveDetails;


/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/employees")
public class LeaveDetailsRest {


  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Path("/leavedetails")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeesleave() {
    System.out.println("Employees leave details List");
    final LeaveDetails[] leavedetails = LeaveDetails.listAll();
    return leavedetails;
  }

  // /**
  //  * Returns a specific employee's details.
  //  * @param id the id of the employee
  //  * @return the employee details
  //  */
  // @POST
  // @Path("/leaveInsert/")
  // @Consumes(MediaType.APPLICATION_JSON)
  // @Produces(MediaType.APPLICATION_JSON)
  // public final String leaveInsert(final LeaveDetails ld) {
  //   String result = LeaveDetails.applyLeave(ld.getempid(), ld.getleaveid(), ld.getleavesdate(),
  //           ld.getleaveedate(), ld.getleavendays(), ld.getleavetype(), ld.leavestatus(),
  //           ld.getleavereason());
  //   return result;
  // }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/leavedetails/leaveid/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leaveListById(@PathParam("id") final int id) {
    final LeaveDetails l = LeaveDetails.listById(id);
    if (l == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return l;
  }

  /**
   * Returns a list of all the employees.
   * @param id the id of the employee
   * @return a list of all the employees
   */
  @GET
  @Path("/leavedetails/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeesleave(@PathParam("id") final int id) {
    System.out.println("Employees leave details List");
    final LeaveDetails[] leavedetails = LeaveDetails.leaveHis(id);
    return leavedetails;
  }

  /**
   * Returns a specific employee's leave  details.
   * @param empId the id of the Employee
   * @param ld the object of the LeaveDetails
   * @throws ParseException for Parsing errors.
   * @return the Leave details
   */

  @POST
  @Path("/applyleave/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String employeeApplyLeave(@PathParam("empId") final int empId,
                   final LeaveDetails ld) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String leType = ld.getLeaveType().toString();
    String result = LeaveDetails.applyLeave(empId, sdf.format(ld.getLeaveSdate()), sdf.format(ld.getLeaveEdate()),
                          ld.getLeaveNdays(), leType, ld.getLeaveReason());
    return result;
  }
 /**
   * Returns a specific employee's leave  details.
   * @param empId the id of the Employee
   * @param led the object of the LeaveDetails
   * @throws ParseException for Parsing errors.
   * @return the Leave details
   */
  @POST
  @Path("/approvedeny/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String employeeapproveDeny(final LeaveDetails led, @PathParam("empId") final int empId)
  throws ParseException {
    String leStatus = led.getLeaveStatus().toString();
    String status = null;
    if (leStatus.equals("APPROVED")) {
      status = "APPROVE";
    } else {
      status = "DENY";
    }
    String results = LeaveDetails.approveDeny(led.getLeaveId(), empId, status, led.getLeaveManagerComm());
    return results;
  }




  /**
   * Returns a list of all the employees.
   * @param id the id of the employee
   * @return a list of all the employees
   */
  @GET
  @Path("/pending/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeespending(@PathParam("id") final int id) {
    final LeaveDetails[] pending = LeaveDetails.listPending(id);
    return pending;
  }
}


