package test_121;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//对于jdbc更新操作包含sql中的add，delete和update
public class Insert {
	public static void main(String[] args) {
		Insert l=new Insert();
		l.insertStudent("7,a,b,c");
	}
	public boolean insertStudent(String Floinfo){
		String[] strs=Floinfo.split(",");
        Connection        connection = null;
        PreparedStatement ps         = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into app(no,name,price,note) values " +
                    " (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, strs[0]);
            ps.setString(2, strs[1]);
            ps.setString(3, strs[2]);
            ps.setString(4, strs[3]);
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
