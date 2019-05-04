import com.damu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {

    //使用junit进行测试
    @Test

    public void testDemo1() throws IOException {
        //初始化mybatis配置环境
        String resource = "mybatis.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory
                = new SqlSessionFactoryBuilder().build(is);

        //打开和数据库之间的回话
        SqlSession session = factory.openSession();

        List<User> ulist = session.selectList("userList");
        for (User user:ulist
             ) {
            System.out.println(user);
        }
        //关闭资源
        session.close();
    }
}
