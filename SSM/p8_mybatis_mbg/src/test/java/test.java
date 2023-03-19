import com.study.mapper.empMapper;
import com.study.pojo.emp;
import com.study.pojo.empExample;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void test1(){
        //简易版的操作 只能完成基础的功能
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        System.out.println(mapper.selectByPrimaryKey(1));
    }
    @Test
    public void testExample1(){
        //尊享版 查询所有
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        //如果我查询的条件为空---->那就是查询所有的意思
        List<emp> emps = mapper.selectByExample(null);
        System.out.println(emps);
    }

    @Test
    public void testExample2(){
        //需求：查询年龄21-23或 dept=2 或 "zs"
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        //需要这样的类型，就创建这样的对象
        empExample empExample = new empExample();
        //可以使用链式编程 创建example对象中已经书写好了相关的方法，直接调用即可
        //如果需要表达or 可以先example.or()后确定
        empExample.createCriteria().andAgeBetween(21,23);
        empExample.or().andDeptIdEqualTo(2);
        empExample.or().andEmpNameEqualTo("zs");
        List<emp> emps = mapper.selectByExample(empExample);
        System.out.println(emps);
    }
    @Test
    public void testExample3(){
        //测试普通的修改功能---->只能根据主键后进行修改，修改成相对应对象的样子
        emp e=new emp(5,"update",10,null);
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        mapper.updateByPrimaryKey(e);
    }

    @Test
    public void testExample4(){
        //选择性修改功能（普通修改如果遇到null，直接修改成null，选择性修改遇到null会不进行修改）
        emp e=new emp(5,null,null,3);
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        mapper.updateByPrimaryKeySelective(e);
    }
    @Test
    public void testExample5(){
        //选择性修改+尊享版的筛选(部门为1的全部修改为11，其他信息不变)
        emp e=new emp(null,null,null,11);
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        empExample empExample = new empExample();
        empExample.createCriteria().andDeptIdEqualTo(1);
        mapper.updateByExampleSelective(e,empExample);

    }

}
