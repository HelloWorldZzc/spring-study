package com.example.p26_mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.p26_mybatisplus.mapper.userMapper;
import com.example.p26_mybatisplus.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class wrapperTest {

    @Autowired
    private userMapper userMapper;

    @Test
    //组装查询条件
    public void test01(){
        //查询用户名包含a，年龄在20-30之间，邮箱不为null的用户信息
        //SELECT * FROM user_mybatis_plus WHERE (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","a")
                .between("age",20,30)
                .isNotNull("email");
        List<user> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    @Test
    //排序
    public void test02(){
        //按照年龄降序查询用户，若年龄相同，则id降序
        //SELECT * FROM user_mybatis_plus ORDER BY age DESC,id DESC
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByDesc("id");

        List<user> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    //组装删除条件
    public void test03(){
        //删除name=name0且邮箱不为空的用户信息
        //DELETE FROM user_mybatis_plus WHERE (name = ? AND email IS NOT NULL)
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        Map<String,Object> map=new HashMap<>();
        map.put("name","name0");
        queryWrapper.allEq(map)
                .isNotNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println("影响的行数："+delete);
    }

    @Test
    //条件优先级查询 and 与 or 的
    public void test04(){
        //(将年龄大于20并且用户名中包含a)或者(邮箱为null)的信息查询
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or(s->s.isNull("email"));

        List<user> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    //条件优先级
    public void test05(){
        //将用户名中包含A并且(年龄大于20或邮箱为null)的用户信息展示
        //SELECT * FROM user_mybatis_plus WHERE (name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        //queryWrapper.like("name","a").and(i->i.gt("age",20).or(t->t.isNull("email")));
        List<user> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    //实现子查询
    public void test06(){
     //查询id<5的信息，要求使用子查询
        //SELECT * FROM user_mybatis_plus WHERE (id IN (select id from user_mybatis_plus where id<5))
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.inSql("id","select id from user_mybatis_plus where id<5");
        List<user> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    //使用updateWrapper进行修改
    public void test07(){
        //(对年龄大于20或邮箱为空)并且用户名包含a的用户进行修改：email、age
        //UPDATE user_mybatis_plus SET age=?,email=? WHERE (name LIKE ? AND (age > ? OR email IS NULL))
        UpdateWrapper<user> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("age",18)
                .set("email","update@xxx.com")
                .like("name","a")
                .and(s->s.gt("age",20).or().isNull("email"));
        //在updateWrapper中进行修改以后，就不必指定实体类了
        int update = userMapper.update(null, updateWrapper);
        System.out.println("受影响的行数："+update);
    }

    @Test
    //在 07的基础上 使用传统的queryWrapper进行修改
    public void test08(){
        //UPDATE user_mybatis_plus SET age=?, email=? WHERE (name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(s->s.gt("age",20).or().isNotNull("email"));
        user u=new user();
        u.setEmail("update");
        u.setAge(19);
        int update = userMapper.update(u, queryWrapper);
        System.out.println("受影响的行数："+update);
    }

    @Test
    //condition
    public void test09(){
        //一些数据是根据用户输入的，那么在此方法中对其进行模拟操作
        //根据用户传输的数据执行相关的SQL语句
        String username="";
        Integer ageB=10;
        Integer ageE=30;
        QueryWrapper<user> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.like(StringUtils.isNotBlank(username),"name",username)
                .gt(ageB!=null,"age",ageB)
                .le(ageE!=null,"age",ageE);
        //SELECT * FROM user_mybatis_plus WHERE (age > ? AND age <= ?)
        List<user> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    //lambdaQueryWrapper
    public void test10(){
        //使用lambda表达式 进行查询操作
        String username="";
        Integer ageB=10;
        Integer ageE=30;
        LambdaQueryWrapper<user> lqw=new LambdaQueryWrapper<>();
        //第二列对应的是数据库中的栏位名
        lqw.like(StringUtils.isNotBlank(username),user::getName,username)
                .gt(ageB!=null,user::getAge,ageB)
                .gt(ageE!=null,user::getAge,ageE);
        List<user> users = userMapper.selectList(lqw);
        //SELECT * FROM user_mybatis_plus WHERE (age > ? AND age > ?)
        users.forEach(System.out::println);

    }

    //lambdaUpdateWrapper 修改
    @Test
    public void test11(){
        //将name=name0 的 age 进行修改为20
        LambdaUpdateWrapper<user> luw=new LambdaUpdateWrapper<>();
        luw.set(user::getAge,20)
                .eq(user::getName,"name0");
        int update = userMapper.update(null, luw);
        System.out.println("受影响的行数："+update);
    }

    @Test
    //扩展：查询姓名包含a字符的的用户名，年龄--->普通方式
    public void test12(){
        QueryWrapper<user> qw=new QueryWrapper<>();
        qw.select("name","age")
                .like("name","a");
        List<Map<String, Object>> users = userMapper.selectMaps(qw);
        users.forEach(System.out::println);
    }

    @Test
    //查询：姓名包含a字符的用户名--->lambda表达式
    public void test13(){
        LambdaQueryWrapper<user> lqw=new LambdaQueryWrapper<>();
        lqw.select(user::getName,user::getAge)
                .like(user::getName,"a");
        List<Map<String, Object>> maps = userMapper.selectMaps(lqw);
        maps.forEach(System.out::println);

    }
}
