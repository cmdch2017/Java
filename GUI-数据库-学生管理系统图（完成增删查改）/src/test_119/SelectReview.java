package test_119;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectReview {
	public static List<StudentInfo> select() {
		List<StudentInfo> o=new ArrayList<>();
		Connection connection=DBUtil.getConnection();
		String sql="select * from student";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StudentInfo l=new StudentInfo(null, null, null);
				l.setNum(rs.getString("number"));
                l.setName(rs.getString("name"));
                l.setSex(rs.getString("sex"));
             /*  System.out.println(
                		String.format("number=%s,name=%s,sex=%s",l.getNum(),l.getName(),l.getSex()));*/
                o.add(l);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return o;
	}
}
