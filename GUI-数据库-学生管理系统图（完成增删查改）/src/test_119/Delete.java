package test_119;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//对于jdbc更新操作包含sql中的add，delete和update
public class Delete {
	public boolean deleteStudent(String number){
        Connection        connection = null;
        PreparedStatement ps         = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from student where number=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, number);
            int num = ps.executeUpdate();
            return num > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, ps, null);
        }
        return false;
    }
}
