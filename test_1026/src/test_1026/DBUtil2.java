package test_1026;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtil2 {

    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    /**
     * 1.加载驱动
     * 2.建立连接
     * 3.创建执行对象Statement
     * 4.执行sql
     * 5.处理结果集ResultSet
     * 6.释放资源
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
        	//注册链接MySQL的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager
                    .getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(connection);
            //创建执行对象Statement
            statement = connection.createStatement();
            //执行sql
            String sql = "select * from student";
            //处理结果集ResultSet
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                Integer sn = resultSet.getInt("sn");
                String name = resultSet.getString(3);
                String qq = resultSet.getString(4);
                Integer classesId = resultSet.getInt(5);
                System.out.println(String.format("id=%s,sn=%s," +
                        "name=%s,qq=%s,classesId=%s",
                        id, sn, name, qq, classesId));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	//释放资源
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
