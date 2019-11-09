package test1031;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UpdateReview {
    public static boolean Update(String sql) {
    	boolean a=true;//flag means confirm update whether successful or not
        Connection connection = null;
        PreparedStatement ps = null;
        int rs = 0;
            connection = DBUtil.getConnection();
            try {
				ps = connection.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            try {
				rs = ps.executeUpdate(sql);
				System.out.println("ִ执行成功");
			} catch (SQLException e) {
				a=false;
				e.printStackTrace();
			}
            finally {
            }
            return a;
 }
}

