package test_1026;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select id,sn,name,qq_mail,classes_id" +
                    " from student where qq_mail" +
                    " like ? and classes_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%qq.com");
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                Integer sn = rs.getInt("sn");
                String name = rs.getString("name");
                String qqMail = rs.getString("qq_mail");
                Integer classesId = rs.getInt("classes_id");
                System.out.println(
                        String.format("id=%s,sn=%s,name=%s," +
                                "mail=%s,classesId=%s", id, sn, name,
                                qqMail, classesId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, ps, rs);
        }
    }
}
