package com.study.sql;

import com.study.sql.pojo.book_1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//使用jdbc技术
@SpringBootTest
public class demo1 {


    @Test
    //测试jdbc的查找--query方式 自定义返回类型
    public void test1(@Autowired JdbcTemplate jdbc){
        String sql="select * from book";
        List<book_1> query = jdbc.query(sql, new RowMapper<book_1>() {
            @Override
            public book_1 mapRow(ResultSet rs, int rowNum) throws SQLException {
                //返回的类型
                book_1 b = new book_1();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setType(rs.getString("type"));
                b.setDescription(rs.getString("description"));
                return b;
            }
        });
        System.out.println(query);

    }

    @Test
    //测试jdbc查找--query返回集合类型
    public void test2(@Autowired JdbcTemplate jdbc){
        String sql="select * from book ";
        List<Map<String, Object>> maps = jdbc.queryForList(sql);
        maps.forEach(System.out::println);
    }

    @Test
    //测试修改功能--update
    public void test3(@Autowired JdbcTemplate jdbc){
        String sql="insert into book values(31,'1','2','3')";
        int update = jdbc.update(sql);
        System.out.println(update);
    }

}
