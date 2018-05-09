import com.alison.mybatis.bean.User;
import com.alison.mybatis.dao.UserMapper;
import com.alison.mybatis.tool.MyBatisUtil;
import com.alison.mybatis.vo.UserCustom;
import com.alison.mybatis.vo.UserQueryVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void TestFind() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("男");
        userCustom.setUsername("zhangsan");
        userQueryVo.setUserCustom(userCustom);
        //调用UserMapper的方法
        List<UserCustom> list = userMapper.findUserList(userQueryVo);
        System.out.println(list);
    }

    //测试用户信息综合查询总数
    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //创建usermapper对象,mybatis自动生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("男");
        userCustom.setUsername("zhangsan");
        userQueryVo.setUserCustom(userCustom);
        //调用UserMapper的方法
        System.out.println(userMapper.findUserCount(userQueryVo));
    }

    //测试根据id查询用户信息，使用 resultMap 输出
    @Test
    public void testFindUserByIdResultMap() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //创建usermapper对象,mybatis自动生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper的方法
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserListHe() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("男");
//        userCustom.setUsername("zhangsan");
        userQueryVo.setUserCustom(userCustom);
        //调用UserMapper的方法
        UserCustom userCustom1 = userMapper.findUserListHe(userQueryVo);
        System.out.println(userCustom1);
    }
}
