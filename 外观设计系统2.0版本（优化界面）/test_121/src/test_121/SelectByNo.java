package test_121;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectByNo {
	public static void main(String[] args) {
		SelectByNo l=new SelectByNo();
		String a=l.select("1");
		String[] nameArray=a.split(",");
		String name=nameArray[1];
		System.out.println(name);
	}
	public String select(String no) {
		StringBuilder l=new StringBuilder();
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps         = null;
		try {
			 String sql="select * from app where no=?";
			 ps=connection.prepareStatement(sql);
			 ps.setString(1, no);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				l.append(rs.getString("no")+",");
				l.append(rs.getString("name")+",");
				l.append(rs.getString("price")+",");
				l.append(rs.getString("note"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return l.toString();
	}
}
