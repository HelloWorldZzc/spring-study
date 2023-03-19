import com.study.mapper.empMapper;
import com.study.pojo.emp;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    public void getEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        List<emp> empByCondition = mapper.getEmpByCondition(new emp(1,"zl",20,1));
        System.out.println(empByCondition);

    }

    @Test
    public void getEmpByCondition2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        List<emp> empByCondition = mapper.getEmpByCondition2(new emp(1,"zl",20,1));
        System.out.println(empByCondition);

    }

    @Test
    public void getEmpByCondition3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        List<emp> empByCondition = mapper.getEmpByCondition2(new emp(1,"zl",20,1));
        System.out.println(empByCondition);
        System.out.println("---------------");
        List<emp> empByCondition3 = mapper.getEmpByCondition3(new emp(20));
        System.out.println(empByCondition3);

    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        emp emp1 = new emp(0, "小明1", 20, 1);
        emp emp2 = new emp(0, "小明2", 20, 1);
        emp emp3 = new emp(0, "小明3", 20, 2);
        List<emp> list = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(list);
    }

    @Test
    public void deleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        Integer[] empIds = new Integer[]{6,7};
        mapper.deleteMoreEmp(empIds);
    }

}
