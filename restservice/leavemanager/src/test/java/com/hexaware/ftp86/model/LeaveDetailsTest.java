package com.hexaware.ftp86.model;

import com.hexaware.ftp86.persistence.LeaveDetailsDAO;
import com.hexaware.ftp86.persistence.EmployeeDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.Assume.assumeNoException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import java.text.ParseException;
import org.junit.Before;
//import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
//import mockit.integration.junit4.JMockit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
  /**
   * leavemanagercomm to store  manager comments.
   */
public class LeaveDetailsTest {
  /**
   * leavemanagercomm to store  manager comments.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testLeaveDetails() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-13");
    Date date2 = sdf.parse("2018-11-15");
    Date date3 = sdf.parse("2018-11-10");
    LeaveDetails ld = new LeaveDetails(1, 1000, date1,
                    date2, 3, LeaveType.SL, LeaveStatus.PENDING, "Sick Leave", date3, "null");
    assertEquals(1, ld.getLeaveId());
    assertEquals(1000, ld.getEmpId());
    assertEquals(sdf.parse("2018-11-13"), ld.getLeaveSdate());
    assertEquals(sdf.parse("2018-11-15"), ld.getLeaveEdate());
    assertEquals(3, ld.getLeaveNdays());
    assertEquals(LeaveType.SL, ld.getLeaveType());
    assertEquals(LeaveStatus.PENDING, ld.getLeaveStatus());
    assertEquals("Sick Leave", ld.getLeaveReason());
    assertEquals(sdf.parse("2018-11-10"), ld.getLeaveAppliedOn());
    assertEquals("null", ld.getLeaveManagerComm());
    LeaveDetails ld1 = null;
    assertFalse(ld.equals(ld1));
    Employee e1 = new Employee();
    assertFalse(ld.equals(e1));
  }
  /**
   * leavemanagercomm to store  manager comments.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testStudentSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-13");
    Date date2 = sdf.parse("2018-11-15");
    Date date3 = sdf.parse("2018-11-10");
    LeaveDetails ld = new LeaveDetails();
    ld.setLeaveId(1);
    ld.setEmpId(1000);
    ld.setLeaveSdate(sdf.parse("2018-11-13"));
    ld.setLeaveEdate(sdf.parse("2018-11-15"));
    ld.setLeaveNdays(3);
    ld.setLeaveType(LeaveType.SL);
    ld.setLeaveStatus(LeaveStatus.PENDING);
    ld.setLeaveReason("Sick Leave");
    ld.setLeaveAppliedOn(sdf.parse("2018-11-10"));
    ld.setLeaveManagerComm("null");


    assertEquals(1, ld.getLeaveId());
    assertEquals(1000, ld.getEmpId());
    assertEquals(sdf.parse("2018-11-13"), ld.getLeaveSdate());
    assertEquals(sdf.parse("2018-11-15"), ld.getLeaveEdate());
    assertEquals(3, ld.getLeaveNdays());
    assertEquals(LeaveType.SL, ld.getLeaveType());
    assertEquals(LeaveStatus.PENDING, ld.getLeaveStatus());
    assertEquals("Sick Leave", ld.getLeaveReason());
    assertEquals(sdf.parse("2018-11-10"), ld.getLeaveAppliedOn());
    assertEquals("null", ld.getLeaveManagerComm());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param edao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO edao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(1, "Anshu",
           "anu123@gmail.com", "9949391111", sdf.parse("2018-08-01"), "Java", 44, 1);
    new Expectations() {
      {
        edao.find(100); result = e100;
        edao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
  /**
   * leavemanagercomm to store  manager comments.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testHashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-13");
    Date date2 = sdf.parse("2018-11-15");
    Date date3 = sdf.parse("2018-11-10");
    LeaveDetails ld1 = new LeaveDetails(1, 1000, date1,
                        date2, 3, LeaveType.SL, LeaveStatus.PENDING, "Sick Leave", date3, "null");
    LeaveDetails ld2 = new LeaveDetails(1, 1000, date1,
                        date2, 3, LeaveType.SL, LeaveStatus.PENDING, "Sick Leave", date3, "null");
    LeaveDetails ld3 = new LeaveDetails(3, 2000, sdf.parse("2018-12-11"),
                        sdf.parse("2018-12-20"), 10, LeaveType.EL, LeaveStatus.PENDING, "Sick",
                        sdf.parse("2018-12-9"), "null");
    assertEquals(ld1.hashCode(), ld2.hashCode());
    assertNotEquals(ld1.hashCode(), ld3.hashCode());
    assertNotEquals(ld2.hashCode(), ld3.hashCode());
  }
  /**
   * test equals.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-11");
    Date date2 = sdf.parse("2018-11-11");
    Date date3 = sdf.parse("2018-11-11");
    LeaveDetails e1 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e2 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e3 = new LeaveDetails(4, 2000, sdf.parse("2018-12-01"),
        sdf.parse("2018-12-10"), 10,  LeaveType.EL, LeaveStatus.PENDING,
        "GOING HOME", sdf.parse("2018-11-16"), "sorry");
    assertTrue(e1.equals(e2));
    assertFalse(e1.equals(e3));
    assertFalse(e2.equals(e3));
  }

//   @Test
//   public final void  testToString() throws ParseException {
//     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//     Date date1 = sdf.parse("2018-11-13");
//     Date date2 = sdf.parse("2018-11-15");
//     Date date3 = sdf.parse("2018-11-10");
//     LeaveDetails ld1 = new LeaveDetails(1, 1000, date1, date2, 3, LeaveType.SL, getLeaveStatus.PENDING,
//                                         "Sick Leave", date3, "Rejected");
//     String res = "LeaveID" + ld1.getLeaveId()
//                  + "\nEmployee Id" + ld1.getEmpId()
//                  + "\nLeave Start Date" + ld1.getLeaveSdate()
//                  + "\nLeave End Date" + ld1.getLeaveEdate()
//                  + "\nNo of Leave Days" + ld1.getLeaveNdays()
//                  + "\nLeave Type" + ld1.getLeaveType()
//                  + "\nLeave Status" + ld1.getLeaveStatus()
//                  + "\nLeave Reason" + ld1.getLeaveReason()
//                  + "\nLeave Applied on" + ld1.getLeaveAppliedOn()
//                  + "\nManager's comment" + ld1.getLeaveManagerComm();
//     assertEquals(res, ld1.toString());
//   }
  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

   /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException mocking the dao class
   */
  @Test
  public final void testListPending(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    new Expectations() {
      {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final ArrayList<LeaveDetails> es1 = new ArrayList<LeaveDetails>();
        final ArrayList<LeaveDetails> es2 = new ArrayList<LeaveDetails>();

        es1.add(new LeaveDetails(1, 100, sdf.parse("2019-07-13"), sdf.parse("2019-07-13"),
                                1, LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"),
                                "enjoy"));

        es1.add(new LeaveDetails(2, 101, sdf.parse("2018-12-20"), sdf.parse("2018-12-20"),
                                1, LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"),
                                "enjoy"));

        es1.add(new LeaveDetails(1, 100, sdf.parse("2019-07-13"), sdf.parse("2019-07-13"),
                                1, LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"),
                                "enjoy"));

        es1.add(new LeaveDetails(3, 102, sdf.parse("2019-09-09"), sdf.parse("2019-09-11"),
                                2, LeaveType.ML, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"),
                                "enjoy"));
        dao.pending(4); result = es1;
        dao.pending(5); result = es2;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] l = LeaveDetails.listPending(4);
    assertEquals(4, l.length);
    LeaveDetails[] l2 = LeaveDetails.listPending(5);
    assertEquals(0, l2.length);
  }
  /**
   * Test to check the functionalty of approveDeny.
   * @param dao to mock the dao class
   * @param edao to mock the edao class
   * @throws ParseException mocking the dao class
   * @throws NullPointerException mocking the dao class
   */
  @Test
  public final void testapply(@Mocked final EmployeeDAO edao, @Mocked final LeaveDetailsDAO dao)
   throws ParseException, NullPointerException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date today = new Date();
    new Expectations() {
      {
        dao.count(1, "2018-12-27", "2018-12-28"); result = 0;
        dao.count(1, "2018-12-30", "2018-12-30"); result = 1;
      }
    };
    new Expectations() {
      {
        edao.find(1); result = new Employee(1, "Rahul Kanna", "rahul157@gmail.com", "890765452",
                                           sdf.parse("2017-11-11"), "Testing", 24, 200);
        edao.find(2); result = new Employee(2, "Rahul Kanna", "rahul157@gmail.com", "890765452",
                                           sdf.parse("2017-11-11"), "Testing", 24, 0);
        edao.find(3); result = null;
      }
    };
    new Expectations() {
      {
        dao.apply(1, "2018-12-27", "2018-12-28", 2, "SL", "PENDING",
                                   "sick", sdf.format(today));
        dao.apply(2, "2018-12-27", "2018-12-28", 2, "SL", "APPROVED",
                                   "sick", sdf.format(today));
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
        }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
        }
    };
    String str6 = LeaveDetails.applyLeave(1, "2018-12-27", "2018-12-28", 2, "SL",
                                        "sick");
    assertEquals(str6, "Leave Applied Successfully For 2 Days.");
    String str2 = LeaveDetails.applyLeave(2, "2018-12-27", "2018-12-28", 2, "SL",
                                        "sick");
    assertEquals(str2, "Leave Applied Successfully...");
    String str8 = LeaveDetails.applyLeave(1, "2018-12-30", "2018-12-30", 1, "SL",
                                        "sick");
    assertEquals(str8, "already applied on given date");
    // String str1 = LeaveDetails.applyLeave(1, "2018-11-26", "2018-11-28", 3, "SL",
    //                                     "sick");
    // assertEquals(str1, "Start should be greater or equal to current date");
    String str3 = LeaveDetails.applyLeave(1, "2018-12-27", "2018-12-28", 5, "SL",
                                        "sick");
    assertEquals(str3, "NO Of Days Should be right");
    String str5 = LeaveDetails.applyLeave(1, "2018-12-27", "2019-12-28", 112, "SL",
                                       "sick");
    assertEquals(str5, "insufficient leav balance");
    String str9 = LeaveDetails.applyLeave(3, "2018-12-27", "2018-12-28", 3, "SL",
                                        "sick");
    assertEquals(str9, "invalid employee");
    String str10 = LeaveDetails.applyLeave(1, "2018-11-28", "2018-11-30", 3, "SL",
                                        "sick");
    assertEquals(str10, "Start should be greater or equal to current date");
    String str11 = LeaveDetails.applyLeave(1, "2018-12-28", "2018-12-26", 3, "SL",
                                        "sick");
    assertEquals(str11, "Start Date Must be Greater than EndDate...");
  }
/**
   * Test to check the functionalty of approveDeny.
   * @param dao to mock the dao class
   * @throws ParseException mocking the dao class
   */
  @Test
  public final void testapproveDeny(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final LeaveDetails ld1 = new LeaveDetails(200, 1, sdf.parse("2018-12-19"), sdf.parse("2018-11-26"),
                   3, LeaveType.SL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-29"), "Pending");
    final LeaveDetails ld2 = new LeaveDetails(300, 2, sdf.parse("2018-12-21"), sdf.parse("2018-12-26"),
                   6, LeaveType.SL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-30"), "Approve");
    final LeaveDetails ld3 = new LeaveDetails(600, 5, sdf.parse("2018-11-19"), sdf.parse("2018-11-24"),
                   6, LeaveType.SL, LeaveStatus.REJECTED, "sick", sdf.parse("2018-12-01"), "Rejected");
    final LeaveDetails ld4 = new LeaveDetails(400, 3, sdf.parse("2018-12-21"), sdf.parse("2018-12-26"),
                   6, LeaveType.SL, LeaveStatus.APPROVED, "sick", sdf.parse("2018-11-30"), "Approve");

    new Expectations() {
      {
        dao.find(200); result = ld1;
        dao.find(300); result = ld2;
        dao.find(600); result = ld3;
        dao.find(400); result = ld4;
        dao.find(500); result = null;
      }
    };
    new Expectations() {
      {
       // dao.showManager(1); result = 1001;
        dao.showManager(300); result = 2002;
        dao.showManager(200); result = 1001;
        dao.showManager(400); result = 3002;
        dao.showManager(600); result = 4002;
      }
    };
    new Expectations() {

      {
        dao.comment("Takecare", "APPROVED", 300);
        dao.comment("Sorry", "REJECTED", 400);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
        }
    };
    String str1 = LeaveDetails.approveDeny(500, 1001, "APPROVE", "Takecare");
    assertEquals(str1, "Invalid LeaveId");
    String str2 = LeaveDetails.approveDeny(300, 2002, "APPROVE", "Takecare");
    assertEquals(str2, "Leave Approved Successfully");
    String str3 = LeaveDetails.approveDeny(200, 2002, "APPROVE", "Takecare");
    assertEquals(str3, "You are not authorised to access this employee.");
    String str4 = LeaveDetails.approveDeny(300, 2002, "DENY", "Sorry");
    assertEquals(str4, "Leave Rejected");
    String str5 = LeaveDetails.approveDeny(400, 3002, "DENY", "Sorry");
    assertEquals(str5, "Leave Rejected");
    String str6 = LeaveDetails.approveDeny(600, 4002, "APPROVE", "Takecare");
    assertEquals(str6, "Leave Approved Successfully");
    String str7 = LeaveDetails.approveDeny(400, 3002, "APPROVE", "Takecare");
    assertEquals(str7, "Already on given status");
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listAll();
    assertEquals(0, es.length);
  }
}
