package test_1026;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//����jdbc���²�������sql�е�add��delete��update
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
            try {
				rs = ps.executeUpdate(sql);
				System.out.println("ִ�гɹ�");
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
            finally {
            }

 }
}
