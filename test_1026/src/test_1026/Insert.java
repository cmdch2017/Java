package test_1026;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//对于jdbc更新操作包含sql中的add，delete和update
public class Insert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rs = 0;
            connection = DBUtil.getConnection();
            String sql = "insert into student(id,sn,name,classes_id) values(10,1211,'tom',2);";
            try {
				ps = connection.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
            try {
				rs = ps.executeUpdate(sql);
				System.out.println("执行成功");
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
            finally {
            }

 }
}
