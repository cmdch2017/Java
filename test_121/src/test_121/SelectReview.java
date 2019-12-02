package test_121;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectReview {
	public ArrayList<String> select() {
		ArrayList<String> o=new ArrayList<>();
		Connection connection=DBUtil.getConnection();
		String sql="select * from app";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StringBuilder l=new StringBuilder();
				l.append(rs.getString("no")+",");
				l.append(rs.getString("name")+",");
				l.append(rs.getString("price")+",");
				l.append(rs.getString("note"));
                o.add(l.toString());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return o;
	}
}
