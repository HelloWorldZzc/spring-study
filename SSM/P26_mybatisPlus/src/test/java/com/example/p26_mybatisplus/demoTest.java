package com.example.p26_mybatisplus;

import com.example.p26_mybatisplus.mapper.userMapper;
import com.example.p26_mybatisplus.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@SpringBootTest
public class demoTest {

    @Autowired
    private userMapper userMapper;

    @Test
    //测试mybatis-plus是否能正常运行
    public void Test(){
        List<user> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    //测试base中的insert
    public void testInsert(){
        user user=new user();
        user.setName("zs");
        user.setAge(23);
        user.setEmail("123@qq.com");
        userMapper.insert(user);
        System.out.println("添加的用户id："+user.getId());
    }

    @Test
    //测试base中根据id删除
    public void testDeleteById(){
        userMapper.deleteById(1640559163754786817L);
    }

    @Test
    //测试base中根据多个id删除
    public void testDeleteByIds(){
        ArrayList<Long> list=new ArrayList<>();
        Collections.addAll(list,1L,2L);
        userMapper.deleteBatchIds(list);
    }

    @Test
    //测试base中根据map属性删除
    public void testDeleteByMap(){
        //DELETE FROM user_mybatis_plus WHERE name = ? AND age = ?
        Map<String,Object> map=new HashMap<>();
        map.put("name","zs");
        map.put("age",23);
        userMapper.deleteByMap(map);
    }

    @Test
    //根据实体类中的id进行修改
    public void testUpdateById(){
        user user=new user();
        user.setId(3L);
        user.setName("ls");
        //将id=3进行修改，修改的名字为ls(user中只有这两个)
        userMapper.updateById(user);
    }

    @Test
    //根据id查询用户信息
    public void testSelectById(){
        user user = userMapper.selectById(4L);
        System.out.println(user);
    }

    @Test
    //更多多个id查询用户信息
    //SELECT id,name,age,email FROM user_mybatis_plus WHERE id IN ( ? , ? )
    public void testSelectByIds(){
        ArrayList<Long> list=new ArrayList<>();
        Collections.addAll(list,3L,4L);
        List<user> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    //根据map查询数据
    public void testSelectByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","zs");
        map.put("age",23);
        List<user> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    //查询所有的用户信息
    public void testSelectAll(){
        List<Map<String, Object>> maps = userMapper.selectMaps(null);
        maps.forEach(System.out::println);
    }

    @Test
    //自定义mapper 根据id查询
    public void testDIY(){
        Map<String, Object> map = userMapper.selectMapById(3L);
        System.out.println(map);

    }


}
