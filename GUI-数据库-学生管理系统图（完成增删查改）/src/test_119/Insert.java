package test_119;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//对于jdbc更新操作包含sql中的add，delete和update
public class Insert {
	public boolean insertStudent(String name,String number){
        Connection        connection = null;
        PreparedStatement ps         = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into student(name," +
                    "number) values " +
                    " (?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, number);
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
