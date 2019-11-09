package test_1026;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//对于jdbc更新操作包含sql中的add，delete和update
public class Delete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rs = 0;
            connection = DBUtil.getConnection();
            //delete 语句
            String sql = "delete from student  where id=10;";
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
