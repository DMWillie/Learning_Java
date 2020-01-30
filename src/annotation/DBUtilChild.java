package annotation;

/*  Author: 北辰
    日期: 30/01/2020
    功能:@Inherited 表示该注解具有继承性。
    设计一个DBUtil的子类，其getConnection2方法，可以获取到父类DBUtil上的注解信息
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilChild extends DBUtil{

    public static Connection getConnection2() throws SQLException, NoSuchMethodException, SecurityException {
        JDBCConfig config = DBUtilChild.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
        Connection c = getConnection2();
        System.out.println(c);
    }
}
