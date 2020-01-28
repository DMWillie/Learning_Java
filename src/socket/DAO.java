package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: socket编程中的DAO,聊天机器人数据库DAO接口
 */

public interface DAO {
    //查询(根据receive查询response)
    public String query(String receive);
}
