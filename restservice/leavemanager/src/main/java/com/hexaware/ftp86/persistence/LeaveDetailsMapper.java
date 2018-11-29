package com.hexaware.ftp86.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp86.model.LeaveDetails;
import com.hexaware.ftp86.model.LeaveStatus;
import com.hexaware.ftp86.model.LeaveType;
/**
 * Mapper class to map from result set to Leavedetails object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped Leavedetails object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    String s = rs.getString("LEAVE_TYPE");
    LeaveType lt1 = LeaveType.valueOf(s);

    String s2 = rs.getString("LEAVE_STATUS");
    LeaveStatus lt2 = LeaveStatus.valueOf(s2);
    /**
     * @return Leavedetails
     */
    return new LeaveDetails(rs.getInt("LEAVE_ID"), rs.getInt("EMP_ID"),
              rs.getDate("START_DATE"), rs.getDate("END_DATE"),
              rs.getInt("NO_OF_DAYS"), lt1,
              lt2, rs.getString("LEAVE_REASON"),
              rs.getDate("APPLIED_ON"), rs.getString("COMMENTS"));
  }
}
