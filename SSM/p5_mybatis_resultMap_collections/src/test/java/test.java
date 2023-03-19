import com.study.mapper.deptMapper;
import com.study.pojo.dept;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class test {
    @Test
    public void getDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deptMapper mapper = sqlSession.getMapper(deptMapper.class);
        dept deptAndEmpByDeptId = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(deptAndEmpByDeptId);
    }
    @Test
    public void getDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deptMapper mapper = sqlSession.getMapper(deptMapper.class);
        dept deptAndEmpByStepOne = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(deptAndEmpByStepOne);
    }


}
