package com.hexaware.ftp86.model;
import com.hexaware.ftp86.persistence.EmployeeDAO;
import com.hexaware.ftp86.persistence.LeaveDetailsDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.junit.Test;
//import org.junit.Before;
//import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
//import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
  /**
   * unit test for employ.
   */
public class EmployeeTest {
/**
 * @throws ParseException throws Parse Exception
 */
  @Test
  public final void testEmployee() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj1 = new Employee(1, "Sonal", "sonal@gmail.com", "987456321", sdf.parse("2014-08-17"), "java", 10, 1000);
    assertEquals(1, obj1.getEmpId());
    assertEquals("Sonal", obj1.getEmpFullName());
    assertEquals("sonal@gmail.com", obj1.getEmailId());
    assertEquals("987456321", obj1.getMobNumber());
    assertEquals(sdf.parse("2014-08-17"), obj1.getDateOfJoining());
    assertEquals("java", obj1.getDepartment());
    assertEquals(10, obj1.getAvailableLeave());
    assertEquals(1000, obj1.getMgrId());
    Employee ee1 = null;
    assertFalse(obj1.equals(ee1));
    LeaveDetails l1 = new LeaveDetails();
    assertFalse(obj1.equals(l1));
  }
  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testEmployeeSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj1 = new Employee();
    obj1.setEmpId(13);
    obj1.setEmpFullName("rahul perumalla");
    obj1.setEmailId("rahul@gmail.com");
    obj1.setMobNumber("9848351574");
    obj1.setDateOfJoining(sdf.parse("2015-10-10"));
    obj1.setDepartment("junit");
    obj1.setAvailableLeave(15);
    obj1.setMgrId(2000);

    assertEquals(13, obj1.getEmpId());
    assertEquals("rahul perumalla", obj1.getEmpFullName());
    assertEquals("rahul@gmail.com", obj1.getEmailId());
    assertEquals("9848351574", obj1.getMobNumber());
    assertEquals(sdf.parse("2015-10-10"), obj1.getDateOfJoining());
    assertEquals("junit", obj1.getDepartment());
    assertEquals(15, obj1.getAvailableLeave());
    assertEquals(2000, obj1.getMgrId());
  }

  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee e1 = new Employee(1, "Sonal", "sonal@gmail.com", "987456321",
                              sdf.parse("2014-08-17"), "java", 10, 1000);
    Employee e2 = new Employee(1, "Sonal", "sonal@gmail.com",
                              "987456321", sdf.parse("2014-08-17"), "java", 10, 1000);
    Employee e3 = new Employee(2, "rahul", "rahul@gmail.com", "984588456",
                               sdf.parse("2014-08-18"), "sql", 12, 3000);
    assertEquals(e1, e2);
    assertNotEquals(e1, e3);
    assertNotEquals(e2, e3);
    // Employee ed1 = null;
    // assertFalse(ed1.equals(e1));
    // LeaveDetails l2 = new LeaveDetails();
    // assertFalse(l2.equals(e1));
  }

  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testHashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee e1 = new Employee(1, "Sonal", "sonal@gmail.com", "987456321",
                              sdf.parse("2014-08-17"), "java", 10, 1000);
    Employee e2 = new Employee(1, "Sonal", "sonal@gmail.com", "987456321",
                              sdf.parse("2014-08-17"), "java", 10, 1000);
    Employee e3 = new Employee(2, "rahul", "rahul@gmail.com", "984588456",
                              sdf.parse("2016-08-18"), "sql", 12, 3000);
    assertEquals(e1.hashCode(), e2.hashCode());
    assertNotEquals(e1.hashCode(), e3.hashCode());
    assertNotEquals(e2.hashCode(), e3.hashCode());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testListAll(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1, "Piush", "piush@gmail.com", "9883145678",
                            sdf.parse("2018-11-01"), "Java", 5, 1000));
        es.add(new Employee(2, "Rahul", "rahul@gmail.com", "987456321",
                            sdf.parse("2014-08-17"), "java", 10, 1000));
        es.add(new Employee(3, "Sonal", "sonal@gmail.com", "987456321",
                            sdf.parse("2016-10-20"), "java", 10, 1000));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1, "Piush", "piush@gmail.com", "9883145678",
                            sdf.parse("2018-11-01"), "Java", 5, 1000), es[0]);
    assertEquals(new Employee(2, "Rahul", "rahul@gmail.com", "987456321",
                            sdf.parse("2014-08-17"), "java", 10, 1000), es[1]);
    assertEquals(new Employee(3, "Sonal", "sonal@gmail.com", "987456321",
                            sdf.parse("2016-10-20"), "java", 10, 1000), es[2]);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param edao mocking the dao class.
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testDecrement(@Mocked final EmployeeDAO edao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "Anshu", "anshu@gmail.com", "84823444",
         sdf.parse("2018-08-01"), "java", 1, 12);
    new Expectations() {
      {
        edao.find(100); result = e100;
      }
    };
    new Expectations() {
      {
        edao.decrement(100, 2);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    Employee e1 = Employee.listById(100);
    assertEquals(e1, e100);
    String result = Employee.decrement(100, 2);
    assertEquals("Leave Balance Updated", result);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param edao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testIncrement(@Mocked final EmployeeDAO edao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "AnshuB", "anu123@gmail.com", "84823444",
               sdf.parse("2018-08-01"), "java", 1, 12);
    new Expectations() {
      {
        edao.find(100); result = e100;
      }
    };
    new Expectations() {
      {
        edao.increment(100, 12);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    Employee e1 = Employee.listById(100);
    assertEquals(e1, e100);
    String result = Employee.increment(100, 12);
    assertEquals("Leave Balance Updated", result);
  }
  /**
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-12-11");
    Date date2 = sdf.parse("2018-11-15");
    Date date3 = sdf.parse("2018-11-10");

    final Employee e100 = new Employee(1, "Anshu", "anshu123@gmail.com", "9883145678",
                                       sdf.parse("2018-12-11"), "Java", 5, 1000);
    final Employee e101 = new Employee(3, "Richa", "richa@gmail.com", "789421457",
                                       sdf.parse("2018-11-15"), "DotNet", 7, 0);
    final Employee e102 = new Employee(2, "Sonal", "sonal123@gmail.com", "4583128906",
                                      sdf.parse("2018-11-10"), "Testing", 10, 2000);
    new Expectations() {
      {
        dao.find(1); result = e100;
        dao.find(2); result = e101;
        dao.find(3); result = e102;
        dao.find(100); result = null;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e1 = Employee.listById(1);
    assertEquals(e100, e1);

    Employee e2 = Employee.listById(2);
    assertEquals(e101, e2);

    Employee e3 = Employee.listById(3);
    assertEquals(e102, e3);

    Employee e4 = Employee.listById(-1);
    assertNull(e4);

    Employee e5 = Employee.listById(100);
    assertNull(e5);
  }
 /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException mocking the dao class
   */
  @Test
  public final void testEmpHistory(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final ArrayList<LeaveDetails> es1 = new ArrayList<LeaveDetails>();
        final ArrayList<LeaveDetails> es2 = new ArrayList<LeaveDetails>();
        final ArrayList<LeaveDetails> es3 = new ArrayList<LeaveDetails>();

        es1.add(new LeaveDetails(1, 100, sdf.parse("2019-07-13"), sdf.parse("2019-07-13"),
                                1, LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-23"),
                                "enjoy"));

        es1.add(new LeaveDetails(2, 100, sdf.parse("2020-07-13"), sdf.parse("2020-07-13"),
                                1, LeaveType.EL, LeaveStatus.APPROVED, "sick", sdf.parse("2018-11-23"),
                                "enjoy"));

        es1.add(new LeaveDetails(3, 100, sdf.parse("2020-09-13"), sdf.parse("2020-09-13"),
                                1, LeaveType.ML, LeaveStatus.APPROVED, "sick", sdf.parse("2018-11-23"),
                                "enjoy"));

        es2.add(new LeaveDetails(1, 101, sdf.parse("2018-12-20"), sdf.parse("2018-12-20"),
                                1, LeaveType.SL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-23"),
                                "enjoy"));
        dao.empHistory(100); result = es1;
        dao.empHistory(101); result = es2;
        dao.empHistory(102); result = es3;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] e1 = LeaveDetails.leaveHis(100);
    assertEquals(3, e1.length);
    LeaveDetails[] e2 = LeaveDetails.leaveHis(101);
    assertEquals(1, e2.length);
    LeaveDetails[] e3 = LeaveDetails.leaveHis(102);
    assertEquals(0, e3.length);
  }
}
