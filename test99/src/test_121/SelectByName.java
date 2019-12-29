package test_121;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectByName {
	public static void main(String[] args) {
		SelectByName l=new SelectByName();
		String a=l.select("appearance3");
		System.out.println(a);
	}
	public String select(String name) {
		StringBuilder l=new StringBuilder();
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps         = null;
		try {
			 String sql="select * from app where name=?";
			 ps=connection.prepareStatement(sql);
			 ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				l.append(rs.getString("no")+",");
				l.append(rs.getString("name")+",");
				l.append(rs.getString("price")+",");
				l.append(rs.getString("note"));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return l.toString();
	}
}
