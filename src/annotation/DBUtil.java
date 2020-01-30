package annotation;

/*  Author: 北辰
    日期: 30/01/2020
    功能: 有了自定义注解@JDBCConfig之后，我们就把非注解方式DBUtil(util包中的DBUtil类)改造成为注解方式DBUtil
    如例所示，数据库相关配置信息本来是以属性的方式存放的，现在改为了以注解的方式，提供这些信息了
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//以注解的方式提供这些信息
@JDBCConfig(ip="127.0.0.1",database="how2java",encoding="UTF-8",
        loginName="root", password="admin")
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**解析注解
     * 接下来就通过反射，获取这个DBUtil这个类上的注解对象
     * JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
     * 拿到注解对象之后，通过其方法，获取各个注解元素的值：
     *  */
    public static Connection getConnection() throws SQLException,NoSuchMethodException,
            SecurityException{
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);

        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",
                ip,port,database,encoding);
        return DriverManager.getConnection(url,loginName,password);
    }

    public static void main(String[] args) throws SQLException,NoSuchMethodException,
            SecurityException{
        Connection c = getConnection();
        System.out.println(c);
    }
}
