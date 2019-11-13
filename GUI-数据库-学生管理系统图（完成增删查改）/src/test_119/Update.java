package test_119;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//对于jdbc更新操作包含sql中的add，delete和update
public class Update {
	public boolean updateStudent(String name,String number){
        Connection        connection = null;
        PreparedStatement ps         = null;
        try {
            connection = DBUtil.getConnection();
            //update student set name='王小龙' where number='012';
            String sql = "update student set name=?" +
                    "where number=" +
                    "?";
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
	public static void main(String[] args) {
		Update l=new Update();
		boolean a=l.updateStudent("Son12","012");
		if(a) {
			System.out.println(a);
		}
	}
}
