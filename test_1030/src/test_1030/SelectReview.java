package test_1030;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectReview {
	public static void main(String[] args) {
		Connection connection=DBUtil.getConnection();
		String sql="select id,sn,name,qq_mail,classes_id from student where qq_mail " + 
				"like ?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			//select id,sn,name,qq_mail,classes_id from student where qq_mail 
			//like '%qq.com'
			ps.setString(1,"%qq.com");
			//执行结果集
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Integer id=rs.getInt("id");
				Integer sn=rs.getInt("sn");
                String name=rs.getString("name");
                String qqMail=rs.getString("qq_mail");
                Integer ClassesId=rs.getInt("classes_id");
                System.out.println(
                		String.format("id=%s,sn=%s,name=%s,mail=%s,classesId=%s",id,sn,name,qqMail,ClassesId));
			}
			//DBUtil.close(connection, ps, rs);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
