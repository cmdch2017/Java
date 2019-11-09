package test_1026;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    private static MysqlDataSource DATASOURCE
                        = new MysqlDataSource();

    static{
        DATASOURCE.setUrl(URL);
        DATASOURCE.setUser(USER_NAME);
        DATASOURCE.setPassword(PASSWORD);
    }

    /**
     * ��װһ������ֵΪConnection�ķ���������ȡ���ݿ�����
     * 1. Class.forName("com.mysql.jdbc.Driver");
     *    DriverManager.getConnection();
     *
     * 2. DataSource:
     */
    public static Connection getConnection(){
        try {
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("��ȡ���ݿ�����ʧ��");
        }
    }

    /**
     * �ͷ����ݿ���Դ��
     * @param connection ���ݿ�����
     * @param ps ���ݿ��������
     * @param rs ���������
     */
    public static void close(Connection connection,
                 PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(connection != null)
                connection.close();
        }catch (SQLException e){
            throw new RuntimeException("�ͷ����ݿ���Դ����");
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }

}
