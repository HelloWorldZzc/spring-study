import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.mapper.empMapper;
import com.study.pojo.emp;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        //查询功能之前开启分页插件的功能
        Page<Object> objects = PageHelper.startPage(1, 3);
        List<emp> list=mapper.selectAll();
        //查询功能之后可以获取相关的数据
        PageInfo<emp> empPageInfo = new PageInfo<>(list, 3);
        System.out.println(empPageInfo);
    }
}
