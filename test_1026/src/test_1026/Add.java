package test_1026;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Add {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
            connection = DBUtil.getConnection();
            String sql = "insert into student(id,sn,name,classes_id) values(10,1211,'tom',2);";
            try {
				ps = connection.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
            try {
				 ps.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

 }
}
