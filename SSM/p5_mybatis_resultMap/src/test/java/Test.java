import com.study.mapper.deptMapper;
import com.study.mapper.empMapper;
import com.study.pojo.emp;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;


public class Test {
    @org.junit.Test
    //根据id查询员工信息(演示类型不匹配问题解决方案)
    public void getEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        emp test = mapper.getEmpByEmpId(2);
        System.out.println(test);

    }
    @org.junit.Test
    //多对一查询--->级联
    public void getEmpAndDeptJL(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        emp test = mapper.getEmpAndDeptJL(2);
        System.out.println(test);
    }

    //多对一查询--->association
    @org.junit.Test
    public void getEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        emp empAndDeptByEmpId = mapper.getEmpAndDeptByEmpId(1);
        System.out.println(empAndDeptByEmpId);
    }

    //多对一 分步查询
    @org.junit.Test
    public void getEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        emp emp = mapper.getEmpAndDeptByStepOne(4);
        System.out.println(emp);
    }

}
