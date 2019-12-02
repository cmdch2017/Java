package test_121;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//对于jdbc更新操作包含sql中的add，delete和update
public class Update {
	public boolean updateStudent(String Floinfo){
        Connection        connection = null;
        PreparedStatement ps         = null;
        String[] strs=Floinfo.split(",");
        try {
            connection = DBUtil.getConnection();
            //update student set name='王小龙' where number='012';
            String sql = "update app set no=?,name=?,price=?,note=? where no=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, strs[0]);
            ps.setString(2, strs[1]);
            ps.setString(3, strs[2]);
            ps.setString(4, strs[3]);
            ps.setString(5, strs[0]);
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
