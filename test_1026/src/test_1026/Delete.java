package test_1026;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//����jdbc���²�������sql�е�add��delete��update
public class Delete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rs = 0;
            connection = DBUtil.getConnection();
            //delete ���
            String sql = "delete from student  where id=10;";
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
