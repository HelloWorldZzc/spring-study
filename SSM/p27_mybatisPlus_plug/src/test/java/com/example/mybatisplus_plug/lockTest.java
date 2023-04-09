package com.example.mybatisplus_plug;

import com.example.mybatisplus_plug.mapper.productMapper;
import com.example.mybatisplus_plug.pojo.product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class lockTest {
    @Autowired
    private productMapper productMapper;


    @Test
    //测试程序是否已经跑通
    public void test01(){
        List<product> products = productMapper.selectList(null);
        products.forEach(System.out::println);
    }

    @Test
    //使用乐观锁解决案例所出现的问题
    public void test02(){
        //进行查询操作
        product productA = productMapper.selectById(1);
        product productB = productMapper.selectById(1);
        //A用户+20
        productA.setPrice(productA.getPrice()+20);
        int update = productMapper.updateById(productA);
        System.out.println("用户A操作结果："+update);
        //B用户-10
        productB.setPrice(productB.getPrice()-10);
        int i = productMapper.updateById(productB);
        System.out.println("用户B操作结果"+i);
        //如果操作结果为false重新获取
        if (i==0){
            product productC = productMapper.selectById(1);
            productB.setPrice(productC.getPrice()-10);
            int j = productMapper.updateById(productB);
            System.out.println("重新操作的结果："+j);
        }
        System.out.println("最后的结果"+productMapper.selectById(1).getPrice());


    }
}
